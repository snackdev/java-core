package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hash003 {
    public int solution(String[][] clothes) {
        Map<String, List<String>> grouped = Arrays.asList(clothes).stream()
                .collect(Collectors.groupingBy(cloth -> cloth[1], Collectors.mapping(cloth -> cloth[0], Collectors.toList())));

        return grouped.values().stream().map(list -> list.size()+1).reduce(1, (a,b) -> a*b) - 1;

    }

    public static void main(String[] args) {
        System.out.println(
                new Hash003().solution(new String[][]{
                        new String[]{"yellowhat", "headgear"},
                        new String[]{"bluesunglasses", "eyewear"},
                        new String[]{"green_turban", "headgear"}
                })
        );

    }
}
