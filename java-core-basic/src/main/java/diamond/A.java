package diamond;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }

    default void bye() {
        System.out.println("Bye from A");
    }
}
