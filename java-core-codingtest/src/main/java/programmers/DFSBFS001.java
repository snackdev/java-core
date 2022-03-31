package programmers;

import java.util.stream.IntStream;

public class DFSBFS001 {

    public static void dfs(int[] numbers, int target, int accum, int currentIdx, int[] result) {
        if (currentIdx == numbers.length) {
            if (accum == target) {
                result[0] += 1;
            }
            return;
        }
        dfs(numbers, target, accum + numbers[currentIdx], currentIdx+1, result);
        dfs(numbers, target, accum - numbers[currentIdx], currentIdx+1, result);
    }

    public static int solution(int[] numbers, int target) {
        int[] result = {0};

        dfs(numbers, target, 0, 0, result);

        return result[0];
    }


    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{1, 1, 1, 1, 1},
                3
        ));

        System.out.println(solution(
                new int[]{4, 1, 2, 1},
                4
        ));
    }
}
