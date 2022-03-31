package string;

import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String[] args) {
        StringTokenizer st1 = new StringTokenizer("Hello!World!");
        System.out.println("st1 count : " + st1.countTokens());
        while (st1.hasMoreTokens()) {
            System.out.println("st1 : "+st1.nextToken());
        }

        System.out.println("============================");
        StringTokenizer st2 = new StringTokenizer("Hello!World!", "!");
        System.out.println("st2 count : " + st2.countTokens());
        while (st2.hasMoreTokens()) {
            System.out.println("st2 : "+st2.nextToken());
        }

        System.out.println("============================");
        StringTokenizer st3 = new StringTokenizer("Hello!World!", "!", true);
        System.out.println("st3 count : " + st3.countTokens());
        while (st3.hasMoreTokens()) {
            System.out.println("st3 : "+st3.nextToken());
        }
    }
}
