package shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShopExecutor {
    public static final List<Shop> shops = Arrays.asList(
            new Shop("A"),
            new Shop("B"),
            new Shop("C"),
            new Shop("D"),
            new Shop("E"),
            new Shop("F"),
            new Shop("G"),
            new Shop("H"),
            new Shop("I")
    );

    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("Show[%s] price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("Show[%s] price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() ->String.format("Show[%s] price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void executeWithTimestamp(String exprName, Function<String, List<String>> function) {
        long start = System.nanoTime();
        System.out.println(function.apply("macbook pro"));
        long duration = (System.nanoTime()-start) / 1_000_000;
        System.out.println(String.format("[%s]", exprName) + "Done in " + duration + " msecs");
    }

    public static void main(String[] args) {
        executeWithTimestamp("findPrices", ShopExecutor::findPrices);
        executeWithTimestamp("findPricesParallel", ShopExecutor::findPricesParallel);
        executeWithTimestamp("findPricesAsync", ShopExecutor::findPricesAsync);
    }
}
