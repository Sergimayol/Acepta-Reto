package p100to199;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P149 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v, m, t;
        while (s.hasNext()) {
            t = s.nextInt();
            m = 0;
            for (int i = 0; i < t; i++) {
                v = s.nextInt();
                if (v > m) {
                    m = v;
                }
            }
            System.out.println(m);
        }
    }

}
