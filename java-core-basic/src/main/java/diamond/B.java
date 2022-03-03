package diamond;

public interface B extends A{
    default void hello() {
        System.out.println("Hello From B");
    };
}
