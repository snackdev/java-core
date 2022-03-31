package util;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomUtil {
    public static Collection<Integer> toCollection(int[] intArr) {
        return IntStream.of(intArr).boxed().collect(Collectors.toList());
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int a : arr) {
            sb.append(String.format("%s, ", a));
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

}
