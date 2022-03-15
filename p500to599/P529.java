package javaapplication34;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P529 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c, ml, lg;
        char[] l;
        c = s.nextInt();
        for (int i = 0; i < c; i++) {
            lg = ml = 0;
            l = s.next().toCharArray();
            for (int j = 0; j < l.length; j++) {
                if (l[j] == 'I') {
                    lg++;
                }
                if (l[j] == 'O') {
                    if (lg > 0) {
                        lg--;
                    } else {
                        ml++;
                    }
                }
                ml = Math.max(lg, ml);
            }
            System.out.println(ml);
        }
    }

}
