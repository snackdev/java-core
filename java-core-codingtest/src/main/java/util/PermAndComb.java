package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermAndComb {

    public static <T> void permutation(T[] array, int pickNum, int pickIdx, T[] picked, boolean[] visited, List<T[]> results, boolean duplicable) {
        if (pickNum == pickIdx) {
            results.add(Arrays.copyOf(picked, pickNum));
            return;
        }
        for (int i=0; i<array.length; i++) {
            if (duplicable || !visited[i]) {
                visited[i] = true;
                picked[pickIdx] = array[i];
                permutation(array, pickNum, pickIdx+1, picked, visited, results, duplicable);
                visited[i] = false;
            }
        }
    }

    public static <T> void combination(T[] array, int pickNum, int pickIdx, int scanStartIdx, T[] picked, boolean[] visited, List<T[]> results, boolean duplicable) {
        if (pickNum == pickIdx) {
            results.add(Arrays.copyOf(picked, pickNum));
            return;
        }
        for (int i=scanStartIdx; i<array.length; i++) {
            if (duplicable || !visited[i]) {
                visited[i] = true;
                picked[pickIdx] = array[i];
                combination(array, pickNum, pickIdx+1, duplicable ? i : i+1, picked, visited, results, duplicable);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String[] candidates = {"a", "b", "c", "d"};
        int pickNum = 3;
        List<String[]> permResults = new ArrayList<>();
        permutation(candidates, pickNum, 0, new String[pickNum], new boolean[candidates.length], permResults, false);
        System.out.println("========PERM======== : " + permResults.size());
        permResults.forEach(result -> System.out.println(Arrays.asList(result)));

        List<String[]> permResultsWithDup = new ArrayList<>();
        permutation(candidates, pickNum, 0, new String[pickNum], new boolean[candidates.length], permResultsWithDup, true);
        System.out.println("========PERM WITH DUPE======== : " + permResultsWithDup.size());
        permResultsWithDup.forEach(result -> System.out.println(Arrays.asList(result)));

        List<String[]> combResults = new ArrayList<>();
        combination(candidates, pickNum, 0, 0, new String[pickNum], new boolean[candidates.length], combResults, false);
        System.out.println("========COMB======== : " + combResults.size());
        combResults.forEach(result -> System.out.println(Arrays.asList(result)));

        List<String[]> combResultsWithDupe = new ArrayList<>();
        combination(candidates, pickNum, 0, 0, new String[pickNum], new boolean[candidates.length], combResultsWithDupe, true);
        System.out.println("========COMB WITH DUPE======== : " + combResultsWithDupe.size());
        combResultsWithDupe.forEach(result -> System.out.println(Arrays.asList(result)));
    }
}
