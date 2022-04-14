package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort003 {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> reverseOrdered = IntStream.of(citations).boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int target = reverseOrdered.get(answer);
        while (answer+1<=target) {
            answer++;
            if (answer == reverseOrdered.size()){
                break;
            }
            target = reverseOrdered.get(answer);
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Sort003().solution(new int[]{3, 0, 6, 1, 5}));
    }
}
