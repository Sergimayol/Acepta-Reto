package p400to499;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P467 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String aux = s.next().toLowerCase();
            s.next();
            if (aux.equals(s.next().toLowerCase())) {
                System.out.println("TAUTOLOGIA");
            } else {
                System.out.println("NO TAUTOLOGIA");
            }
        }
    }

}
