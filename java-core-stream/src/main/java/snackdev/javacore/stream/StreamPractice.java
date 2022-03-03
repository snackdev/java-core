package snackdev.javacore.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {

        IntSummaryStatistics result = Arrays.asList(1,2,3,4).stream()
                .collect(Collectors.collectingAndThen()
                );
        System.out.println(result);
    }
}

