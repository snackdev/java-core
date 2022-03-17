package shop;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.IntStream;


public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product, false);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            futurePrice.complete(calculatePrice(product, false));
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithError(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                futurePrice.complete(calculatePrice(product, true));
            }catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }

        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithSupplier(String product, boolean causeError) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product, causeError));
    }

    private double calculatePrice(String product, boolean causeError) {
        delay();
        if (causeError) {
            throw new RuntimeException("Cause ERR");
        }
        return new Random().nextDouble() * name.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doSomething() {
        IntStream.range(0, 5).forEach(n -> delay());
    }

    public static void main(String[] args) {
        Shop shop = new Shop("ABC mart");
        long start = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("macbook pro");
//        Future<Double> futurePrice = shop.getPriceAsyncWithError("macbook pro");
        Future<Double> futurePrice = shop.getPriceAsyncWithSupplier("macbook pro", false);
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        doSomething();

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
