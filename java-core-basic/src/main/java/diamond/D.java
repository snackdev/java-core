package diamond;

public class D implements B, C{

    @Override
    public void bye() {
        System.out.println("Bye from D");
    }

    public static void main(String[] args) {
        new D().hello();
        new D().bye();
    }
}
