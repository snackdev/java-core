package dfsbfs;

public class DFS {
    public static void dfs(int[][] graph, int value, boolean[] visited) {
        visited[value] = true;
        System.out.println(value + " ");
        for (int x : graph[value]) {
            if (!visited[x]) {
                dfs(graph, x, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {},
                {2,3,8},
                {1,7},
                {1,4,5},
                {3,5},
                {3,4},
                {7},
                {2,6,8},
                {1,7}
        };
        dfs(graph, 1, new boolean[graph.length]);
    }
}
