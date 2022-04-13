package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class StackQueue003 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();
        Stack<Integer> doneStack = new Stack<>();
        Queue<Integer> waitQueue = new LinkedList<>();

        IntStream.of(truck_weights).forEach(waitQueue::add);
        IntStream.range(0, bridge_length).forEach(idx -> bridgeQueue.add(0));

        int sec = 0;
        int weightSum = 0;
        int truckOnBridgeNum = 0;
        while (doneStack.size() < truck_weights.length ) {
            sec++;

            int done = bridgeQueue.poll();
            if (done > 0) {
                doneStack.push(done);
                truckOnBridgeNum--;
            }
            weightSum -= done;

            int target = 0;
            if (!waitQueue.isEmpty() && waitQueue.peek()+weightSum <= weight && truckOnBridgeNum < bridge_length) {
                target = waitQueue.poll();
                truckOnBridgeNum++;
            }
            bridgeQueue.add(target);
            weightSum += target;

        }

        return sec;

    }

    public static void main(String[] args) {
        System.out.println(
                new StackQueue003().solution(
                        2,
                        10,
                        new int[]{7,4,5,6}
                )
        );
        System.out.println(
                new StackQueue003().solution(
                        100,
                        100,
                        new int[]{10}
                )
        );
        System.out.println(
                new StackQueue003().solution(
                        100,
                        100,
                        new int[]{10,10,10,10,10,10,10,10,10,10}
                )
        );
        System.out.println(
                new StackQueue003().solution(
                        1,
                        100,
                        new int[]{1,1,1,1,1,1}
                )
        );

    }
}
