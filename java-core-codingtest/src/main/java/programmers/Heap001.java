package programmers;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Heap001 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(IntStream.of(scoville).boxed().collect(Collectors.toList()));

        int cnt = 0;
        while (heap.size() > 1) {
            if (heap.peek() >= K) {
                break;
            }
            int min1 = heap.poll();
            int min2 = heap.poll();
            heap.add(min1 + (2*min2));
            cnt++;
        }

        if (heap.size()==1) {
            if (heap.peek() < K) {
                cnt = -1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(
//                solution(new int[]{1, 2, 3, 9, 10, 12}, 7)
                solution(new int[]{8,9}, 7)
        );
    }
}
