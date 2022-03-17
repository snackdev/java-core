package util;

public class ToStringUtil {
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int a : arr) {
            sb.append(String.format("%s, ", a));
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
