package programmers;

import java.util.stream.IntStream;

// TODO 못푼 문제
public class DP001 {
    public int solution(int N, int number) {
        int[] calculated = new int[number+1];

        calculated[1] = N==1 ? 1:2;
        for (int num : IntStream.rangeClosed(2, N).toArray()) {
            if (num == N) {
                calculated[num] = 1;
            } else {

            }

        }

        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new DP001().solution(5,12));
    }
}
