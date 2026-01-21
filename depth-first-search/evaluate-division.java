import java.util.*;

class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i=0;i<res.length;i++){
            res[i]=dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return res;
       
    }
    public void buildGraph(List<List<String>> eq, double[] val) {
        for (int i = 0; i < eq.size(); i++) {
            String a = eq.get(i).get(0);
            String b = eq.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val[i]);
            graph.get(b).put(a, 1.0 / val[i]);
        }
    }
    public double dfs(String curr,String target,HashSet visited) {
        if (!graph.containsKey(curr)) return -1.0;
        if (curr.equals(target)) return 1.0;
        for (Map.Entry<String, Double> nei : graph.get(curr).entrySet()) {
            visited.add(curr);
            if (!visited.contains(nei.getKey())) {
                double product = dfs(nei.getKey(), target, visited);
                if (product != -1.0) {
                    return product * nei.getValue();
                }
            }

        }
        return -1.0;


    }
}
