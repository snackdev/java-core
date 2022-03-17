package collection;

import java.util.*;
import java.util.stream.*;

public class SortPractice {
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int a : arr) {
            sb.append(String.format("%s, ", a));
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void sort() {
        int[] intArr = {1,10,2,9,3,8,4,7,5,6};
        Arrays.sort(intArr);
        System.out.println("Arrays.sort is inplace "+ arrayToString(intArr));
    }

    public static void main(String[] args) {
        sort();
        String[] subjects = {"maths", "english", "history", "physics"};
        ArrayDeque<Integer> deque = new ArrayDeque<>(IntStream.range(0, 10).boxed().collect(Collectors.toList()));
        int[] a = new int[0];




    }
}
