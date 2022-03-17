package basic;

import java.util.Arrays;

public class HardwareInspector {
    public static void inspectProcessor () {
        System.out.println("Available Processor : " + Runtime.getRuntime().availableProcessors());
    }

    public static void inspect() {
        Arrays.asList("HEllo").parallelStream().parallel().map()
    }

    public static void main(String[] args) {
        inspectProcessor();
    }
}
