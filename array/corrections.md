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


## LC42 – Trapping Rain Water

**状态**：🟡 partially mastered / unstable

---

### 题目描述

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

---

### 最初错误 / 困惑点

* 误以为在双指针过程中，如果出现 `leftMax > rightMax`，仍然可能去结算 `left`，从而担心会“算多水”。
* 没有明确区分 **“当前被结算的位置”** 与 **“全局最大高度”** 的关系。

---

### 正确认知（核心修正）

* 双指针解法的**关键不变量**：

  * **每一步都先结算当前高度较低的一侧**。
  * 因此：

    * 结算 `left` 时，一定满足 `leftMax ≤ rightMax`
    * 结算 `right` 时，一定满足 `rightMax ≤ leftMax`
* 这保证了水位公式中的 `min(leftMax, rightMax)` 正好等于被结算一侧的 `max`，不会算多。

---


### 关键代码（双指针，Java）

```java
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int water = 0;

    while (left < right) {
        if (height[left] < height[right]) {
            leftMax = Math.max(leftMax, height[left]);
            water += leftMax - height[left];
            left++;
        } else {
            rightMax = Math.max(rightMax, height[right]);
            water += rightMax - height[right];
            right--;
        }
    }
    return water;
}
```

---



### 复盘总结（一句话）

> 双指针法通过“每次先处理当前高度较低的一侧”，保证被结算一侧的最大高度不超过另一侧，从而可以当下安全结算水量。

---
## LC151 – Reverse Words in a String（关键一句）

### 重点代码

```java
String[] words = s.trim().split("\s+");
```

---

### 这行代码在做什么（逐点拆解）

1. **`trim()`**

   * 去掉字符串**首尾多余空格**
   * 防止 split 后出现空字符串（`""`）

2. **`split("\s+")`**

   * `\s`：匹配任意空白字符（space / tab 等）
   * `+`：匹配 **一个或多个**
   * 作用：**把连续空格当作一个分隔符**

---

### 为什么不能直接用 `split(" ")`

* `split(" ")` 只匹配**单个空格**
* 遇到多个空格会产生空字符串

示例：

```text
"a   b".split(" ")  → ["a", "", "", "b"]
"a   b".split("\s+") → ["a", "b"]
```

---
# LC76 Minimum Window Substring 错题总结

## 1️⃣ 错误点
- **问题现象**：在长字符串或重复字符的 testcase 中，输出总是空字符串 `""`。
- **根本原因**：在判断窗口内某个字符是否满足目标频率时，使用了 `==` 比较两个 `Integer` 对象。
- **具体表现**：
```java
if(count.get(c) == need.get(c)){
    valid++;
}
```
- **修正**：
```java
if(count.get(c).equals(need.get(c))){  
    valid++;
}
```
---
# LC98 Valid BST

## 错误点
- **问题现象**：觉得迭代只能从下往上
- **修正**：
```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return validate(root.left, min, root.val) &&
               validate(root.right, root.val, max);
    }
}

```

---
#  LeetCode DFS 图论错题总结

## Clone Graph (LC 133)

### 题目核心

* 给定一个图节点，深拷贝整个图
* 图可能有环
* 需要返回新图

### 错误点

* 只 clone 一层邻居 → 图没被完全 clone
* `map.put(node, copy)` 放在递归之后 → 遇到环会无限递归

### 正确思路

* 用 `Map<Node, Node>` 记录已经 clone 的节点（visited）
* DFS 克隆邻居
* 先 put 再递归

### 核心模板

```java
Map<Node, Node> map = new HashMap<>();
Node dfs(Node node) {
    if(map.containsKey(node)) return map.get(node);
    Node copy = new Node(node.val);
    map.put(node, copy);
    for(Node nei: node.neighbors) copy.neighbors.add(dfs(nei));
    return copy;
}
```

---

## Surrounded Regions (LC 130)

### 题目核心

* 2D 矩阵 'O' 和 'X'
* 捕获被 X 包围的 O → 变为 X
* 边界 O 不变

### 错误点

* DFS 返回是否消除思路容易漏边界 O
* 没标记边界 DFS → 部分 O 被误捕获

### 正确思路

* DFS 标记所有边界连通的 O 为临时字符（如 'S'）
* 遍历整个矩阵：

  * 'S' → O
  * O → X

### 核心模板

```java
void dfs(int r, int c, char[][] board) {
    if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!='O') return;
    board[r][c] = 'S';
    dfs(r+1,c,board);
    dfs(r-1,c,board);
    dfs(r,c+1,board);
    dfs(r,c-1,board);
}
```

---

## Evaluate Division (LC 399)

### 题目核心

* 已知 a/b = 2.0 等方程，求查询 x/y
* 转换为图：节点=变量，边=除法关系

### 正确思路

* 构建加权有向图
* DFS / BFS 查找路径，累乘边权值
* 用 HashSet 标记当前 DFS 栈路径，防止环

### 核心模板

```java
Map<String, Map<String, Double>> graph;
double dfs(String curr, String target, Set<String> visited){
    if(!graph.containsKey(curr)) return -1.0;
    if(curr.equals(target)) return 1.0;
    visited.add(curr);
    for(Map.Entry<String, Double> nei : graph.get(curr).entrySet()){
        if(!visited.contains(nei.getKey())){
            double product = dfs(nei.getKey(), target, visited);
            if(product!=-1.0) return product*nei.getValue();
        }
    }
    return -1.0;
}
```

---

##  Course Schedule (LC 207)

### 题目核心

* 判断有向图是否有环
* 课程编号 0~n-1，先修关系 [a,b] 表示 b->a

### 错误点

* ArrayList.add 返回 boolean 不能直接放 map
* DFS 用 boolean visited 无法区分“正在访问”和“已完成” → 环检测失败
* graph 局部变量无法被 DFS 访问

### 正确思路

* DFS + 回溯（pathVisited）检测环
* finished boolean 跳过已完成节点
* 或使用三状态数组（0=未访问,1=访问中,2=完成）

### 核心模板

```java
Map<Integer, List<Integer>> graph;
boolean[] finished;
boolean dfs(int node, Set<Integer> pathVisited){
    if(pathVisited.contains(node)) return false;
    if(finished[node]) return true;
    pathVisited.add(node);
    for(int nei : graph.getOrDefault(node,new ArrayList<>())){
        if(!dfs(nei, pathVisited)) return false;
    }
    pathVisited.remove(node);
    finished[node] = true;
    return true;
}
```

### 回溯作用

* 确保 DFS 栈路径上的节点标记准确
* 检测环只在当前递归路径生效
* 避免 boolean visited 混淆“






