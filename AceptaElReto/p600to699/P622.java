package AceptaElReto.p600to699;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P622 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n, m, e, p;
        try {
            while (true) {
                n = r.nextInt();
                if (n == 0) {
                    break;
                }
                m = 0;
                for (int i = 0; i < n; i++) {
                    m += r.nextInt();
                }
                e = r.nextInt();
                p = e * (n + 1);
                if (m > p || (m + 10) < p) {
                    System.out.println("IMPOSIBLE");
                } else {
                    System.out.println(p - m);
                }
            }
        } catch (Exception ex) {
        }
    }

}
