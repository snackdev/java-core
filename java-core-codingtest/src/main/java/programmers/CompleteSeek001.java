package programmers;

import util.CustomUtil;

import java.util.stream.IntStream;

public class CompleteSeek001 {
    public static int[] solution(int[] answers) {
        int[] ans1 = {1,2,3,4,5};
        int[] ans2 = {2,1,2,3,2,4,2,5};
        int[] ans3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = {-1,0,0,0};
        int pointer = 0;
        for (int answer : answers) {
            score[1] += ans1[pointer%ans1.length] == answer ? 1:0;
            score[2] += ans2[pointer%ans2.length] == answer ? 1:0;
            score[3] += ans3[pointer%ans3.length] == answer ? 1:0;
            pointer++;
        }

        int maxScore = IntStream.of(score).max().orElse(0);
        return IntStream.rangeClosed(1, 3).filter(idx -> score[idx] == maxScore).toArray();
    }

    public static void main(String[] args) {
        System.out.println(
                CustomUtil.arrayToString(
                        solution(new int[]{1,2,3,4,5})
                )
        );
        System.out.println(
                CustomUtil.arrayToString(
                        solution(new int[]{1,3,2,4,2})
                )
        );
    }
}
