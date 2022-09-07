package AceptaElReto.p500to599;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P572 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        boolean c, nu;
        for (int i = 0; i < n; i++) {
            String[] l = s.nextLine().split(" ");
            c = nu = false;
            for (int j = 0; j < l.length; j++) {
                if (l[j].contains("0.0")) {
                    c = true;
                }
                if (l[j].contains("9.") || l[j].contains("10")) {
                    nu = true;
                }
            }
            System.out.println((!nu && c) ? "SUSPENSO DIRECTO" : "MEDIA");
        }
    }

}
