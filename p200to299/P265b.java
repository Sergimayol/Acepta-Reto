package p200to299;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P265b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum, nl;
        while ((nl = s.nextInt()) != 0) {
            sum = 0;
            char[] c = Integer.toString(nl).toCharArray();
            int l = c.length;
            for (int i = 0; i < l; i++) {
                sum += (c[i] - '0') * (i + 1) * Math.pow(10, l - 1 - i);
            }
            System.out.println(sum);
        }
    }

}
