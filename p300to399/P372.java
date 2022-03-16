package p300to399;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P372 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(inv(s.next()));
        }
    }

    private static String inv(String next) {
        String inv = "";
        for (int i = next.length() - 1; i >= 0; i--) {
            if (Character.isUpperCase(next.charAt(0)) && i == next.length() - 1) {
                inv += ("" + Character.toUpperCase(next.charAt(i)));
            } else if (Character.isUpperCase(next.charAt(i))) {
                inv += ("" + Character.toLowerCase(next.charAt(i)));
            } else {
                inv += ("" + next.charAt(i));
            }
        }
        return inv;
    }

}
