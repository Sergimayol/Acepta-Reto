package AceptaElReto.p500to599;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P508 {

    static int ht;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, x, y;
        while (true) {
            ht = 0;
            n = s.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                x = s.nextInt();
                y = s.nextInt();
                if (isIn(x, y)) {
                    ht++;
                }
            }
            System.out.println(ht);
        }
    }

    static boolean isIn(int x, int y) {
        return true;
    }

}
