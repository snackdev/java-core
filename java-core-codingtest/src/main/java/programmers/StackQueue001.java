package programmers;

import util.CustomUtil;

import java.util.Arrays;
import java.util.stream.IntStream;


public class StackQueue001 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] remainDays = IntStream.range(0, progresses.length)
                .map(idx -> (int)Math.ceil((double) 100-progresses[idx]/speeds[idx]))
                .toArray();


        int[] answer = new int[progresses.length];
        int answerIdx = 0;
        int pointer = 0;
        int day = 0;

        while (pointer < remainDays.length) {
            if (answer[answerIdx] == 0) {
                answer[answerIdx] = 1;
                day = remainDays[pointer];
                pointer++;
                continue;
            }
            if (remainDays[pointer] <= day) {
                pointer++;
                answer[answerIdx] += 1;
            } else {
                answerIdx++;
            }
        }

        return Arrays.copyOf(answer, answerIdx+1);
    }


    public static void main(String[] args) {
        System.out.println(CustomUtil.arrayToString(solution(
                new int[]{93, 99, 99},
                new int[]{1, 30, 5}
        )));

        // FIXME: 수의 나눗셈 형변환 주의
        System.out.println(Math.ceil(((double) 7/3)));
    }
}
