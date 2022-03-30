package p300to399;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P371 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        while ((n = s.nextInt()) != 0) {
            int c = 0;
            for (int i = n; i > 0; i--) {
                c += 3 * i;
            }
            System.out.println(c);
        }
    }

}
