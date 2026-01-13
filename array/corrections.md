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
