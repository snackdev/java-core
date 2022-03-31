package programmers;

import java.util.stream.IntStream;

public class DFSBFS002 {

    public static boolean dfs(int n, int[][] graph, int value, boolean[] visited) {
        if (visited[value]){
            return false;
        }

        visited[value] = true;
        for (int to : IntStream.range(0, n).toArray()) {
            if (graph[value][to] == 1 && !visited[to]) {
                dfs(n, graph, to, visited);
            }
        }
        return true;
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int computer : IntStream.range(0, n).toArray()) {
            if (dfs(n, computers, computer, visited)) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(
                3,
                new int[][]{
                        {1,1,0},
                        {1,1,0},
                        {0,0,1}
                }
        ));
        System.out.println(solution(
                3,
                new int[][]{
                        {1,1,0},
                        {1,1,1},
                        {0,1,1}
                }
        ));

    }
}
