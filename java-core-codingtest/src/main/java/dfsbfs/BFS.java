package dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(int[][] graph, int value, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(value));
        visited[value] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.println(x+ " ");
            for (int y : graph[x]) {
                if (!visited[y]) {
                    queue.add(y);
                    visited[y] = true;
                }
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
        bfs(graph, 1, new boolean[graph.length]);
    }
}
