package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompleteSeek002 {
    public static boolean isPrime(int num) {
        if (num <2 || num%2==0) {
            if (num == 2) {
                return true;
            }
            return false;
        }
        int sqrtNum = (int) Math.sqrt(num);

        for (int i=2; i<=sqrtNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void permutation(String[] array, int pickNum, int pickIdx, String[] picked, boolean[] visited, Set<Integer> candidates) {
        if (pickNum == pickIdx) {
            candidates.add(
                    Integer.parseInt(Arrays.stream(Arrays.copyOf(picked, pickNum)).reduce((a,b) -> a.concat(b)).get())
            );
            return;
        }
        for (int i=0; i<array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[pickIdx] = array[i];
                permutation(array, pickNum, pickIdx+1, picked, visited, candidates);
                visited[i] = false;
            }
        }
    }

    public static int solution(String numbers) {
        String[] numberStrings = numbers.split("");
        Set<Integer> candidates = new HashSet<>();

        for (int len=1; len<=numberStrings.length; len++) {
            permutation(numberStrings, len, 0, new String[len], new boolean[numberStrings.length], candidates);
        }
        System.out.println(candidates);
        return candidates.stream().filter(candidate -> isPrime(candidate)).collect(Collectors.toList()).size();
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));

        System.out.println(
                IntStream.of(
                        2,7,11,13,17
                ).filter(num -> !isPrime(num))
        );
    }
}
