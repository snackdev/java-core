package snackdev.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOverview {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5);
//<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
//            <R> Stream<R> map(Function<? super T, ? extends R> mapper);
//
        List<int[]> list =  list1.stream().flatMap(num -> {
            return list2.stream().map(num2 -> new int[]{num, num2});
        }).collect(Collectors.toList());

    }
}
