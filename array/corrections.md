# LeetCode Mistake Book – US SDE 26 Summer Focus

> 说明：
> - 只收录做不熟练的题（🟡/🔴）
---

## 🔴 LC80 – Remove Duplicates from Sorted Array II

### 1. 错误点
- 没想到用 `write - 2` 判断是否是第三次重复
- 思路停留在“计数 + 删除”，不够直观
- 边界容易出错（前两个元素、空数组）

### 2. 正确答案
- Category: Two Pointers / In-place
- 核心思路：
  1. 定义 `write` 指针：指向下一个可以写的位置
  2. 遍历 `read`：
     - 如果 `write < 2` → 可以直接写
     - 否则比较 `nums[read] != nums[write - 2]` → 可以写
- 不要真的删除元素，只管写入合法值

### 3. Java Key Code
```java
int write = 0;
for (int num : nums) {
    if (write < 2 || num != nums[write - 2]) {
        nums[write] = num;
        write++;
    }
}
return write;
```

## 🔴 LC45 – Jump Game II
### 1. 错误点

没理解为什么只遍历到 n-2 就够，不清楚最后一步的边界逻辑


### 2.正确答案

Category: Greedy / Two Pointers

核心思路：

定义 curEnd：当前跳跃能覆盖的最远位置

定义 farthest：在当前跳跃范围内遍历时能到的最远位置

遍历 i = 0 → n-2：

更新 farthest = max(farthest, i + nums[i])

当 i == curEnd → 增加跳跃次数 jumps++，并更新 curEnd = farthest

遍历到 n-2 是关键：最后一步跳跃覆盖终点，不需要再遍历 n-1

### 3. Java Key Code
```
public int jump(int[] nums) {
    int jumps = 0;
    int curEnd = 0;   // 当前跳跃能覆盖的最远位置
    int farthest = 0; // 当前扫描范围内能到的最远位置

    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == curEnd) { // 到达当前跳跃边界
            jumps++;
            curEnd = farthest;
        }
    }
    return jumps;
}
```

### 4. Edge Cases

nums.length == 1 → return 0

nums 包含 0，但保证能跳到终点

最后一跳覆盖终点

### 5. Recall

为什么只遍历到 n-2？ → 最后一跳覆盖终点

如何改成每次最多跳 k 步？ → 更新 farthest = max(farthest, i + min(nums[i], k))

## 🔴 LC380 – Insert Delete GetRandom O(1)
### 1. 错误点

在 remove 中直接使用 ArrayList.remove(index)，忽略了这是 O(n) 操作

删除元素后 没有同步更新 HashMap 中其他元素的 index

一开始误以为 % arr.size() 或 round 能“扩大随机性”

对 “用最后一个元素覆盖被删位置” 这个关键技巧不熟


### 2.正确答案

Category: Design / HashMap + ArrayList

核心思路：

用 ArrayList 存所有元素，支持 O(1) 随机访问

用 HashMap<val, index> 记录每个元素在数组中的位置

删除时不做真正的中间删除：

找到要删元素的 index

用数组最后一个元素覆盖该位置

更新最后一个元素在 map 中的 index

删除数组最后一位 & map 中的 val

getRandom：直接在 [0, size) 中随机取 index

### 3. Java Key Code
```
class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastVal = arr.get(arr.size() - 1);

        // 用最后一个元素覆盖被删除的位置
        arr.set(idx, lastVal);
        map.put(lastVal, idx);

        // 删除最后一个元素
        arr.remove(arr.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int i = (int) (Math.random() * arr.size());
        return arr.get(i);
    }
}

```

