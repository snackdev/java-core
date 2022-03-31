package programmers;

import java.util.Arrays;

public class Sort001 {
    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int commandIdx = 0;
        for (int[] command : commands) {
            int[] sliced = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(sliced);
            answer[commandIdx] = sliced[command[2]-1];
            commandIdx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                        new int[][]{
                                {2, 5, 3},
                                {4, 4, 1},
                                {1, 7, 3}
                        })
        );
    }
}
