package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort002 {
    public static int toKey(String value) {
        StringBuilder sb = new StringBuilder();
        if (value.length() ==1) {
            IntStream.range(0, 4).forEach(n -> sb.append(value));
        } else if(value.length() == 2) {
            IntStream.range(0, 2).forEach(n -> sb.append(value));
        } else if(value.length() == 3) {
            sb.append(value);
            sb.append(value.charAt(0));
        } else {
            sb.append(value);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String solution(int[] numbers) {
        List<String> sortedNumStrs = IntStream.of(numbers).boxed()
                .map(num -> String.valueOf(num))
                .sorted((a,b) -> toKey(b) - toKey(a))
                .collect(Collectors.toList());


        return sortedNumStrs.stream().reduce((a,b) -> a+b).map(answer -> {
            if (answer.startsWith("0")){
                return "0";
            }
            return answer;
        }).orElse("");
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
