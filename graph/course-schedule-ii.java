import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1️⃣ 建图
        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) {
            int cur = pair[0], pre = pair[1];
            graph.get(pre).add(cur);
        }

        // 2️⃣ DFS 检测环
        int[] visited = new int[numCourses]; // 0=未访问,1=访问中,2=完成
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited)) return new int[]{}; // 有环 → 空数组
        }

        // 3️⃣ 逆序得到正确拓扑顺序
        Collections.reverse(ans);

        // 4️⃣ 转成 int[]
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private boolean dfs(int node, int[] visited) {
        if (visited[node] == 1) return false; // 有环
        if (visited[node] == 2) return true;  // 已完成

        visited[node] = 1; // 标记访问中
        for (int nei : graph.get(node)) {
            if (!dfs(nei, visited)) return false;
        }
        visited[node] = 2; // 标记完成
        ans.add(node);      // DFS 完成后加入结果
        return true;
    }
}
