package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

// TODO
public class StackQueue002 {

    static class Job {
        int loc;
        int priority;
        boolean observable;

        Job(int loc, int priority, boolean observable) {
            this.loc = loc;
            this.priority = priority;
            this.observable = observable;
        }
    }


    public static int solution(int[] priorities, int location) {
        LinkedList<Job> jobQueue = new LinkedList<>();
        for (int loc=0; loc < priorities.length; loc++) {
            jobQueue.add(new Job(loc, priorities[loc], loc == location));
        }

        int printed = 0;
        while (jobQueue.size()>1) {
            Job job = jobQueue.pollFirst();

            Job jobMax = jobQueue.stream().max(Comparator.comparingInt(j -> j.priority)).get();

            if (job.priority >= jobMax.priority) {
                printed++;
                if (job.observable) {
                    break;
                }
            } else {
                jobQueue.offerLast(job);
            }
        }

        if (jobQueue.size() == 1) {
            printed++;
        }

        return printed;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{2,1,3,2},
                2
        ));
        System.out.println(solution(
                new int[]{1, 1, 1, 1, 1, 1},
                5
        ));
    }
}
