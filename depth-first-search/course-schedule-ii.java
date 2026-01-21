import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer>ans=new ArrayList<>();
    
    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
   
        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) {
            int cur = pair[0];
            int pre = pair[1];
            graph.get(pre).add(cur); // key=先修课, value=后续课
        }
        
        boolean can=false;
        int[] visited = new int[numCourses]; 
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited)) return new ArrayList<>();
        }
        return ans;
      
    }
    
    private boolean dfs(int node, int[] visited) {
        if (visited[node] == 1) return false; // 有环
        if (visited[node] == 2) return true;  // 已完成
        
        visited[node] = 1; // 标记访问中
        for (int nei : graph.get(node)) {
            if (!dfs(nei, visited)) return false;
        }
        visited[node] = 2; // 标记完成
        ans.add(node); 
        return true;
    }
}

