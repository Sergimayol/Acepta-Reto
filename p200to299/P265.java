package p200to299;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P265 {

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
            for (int i = 0; i < c.length; i++) {
                String num = "";
                for (int j = (c.length - l); j < c.length; j++) {
                    num += String.valueOf(c[j]);
                }
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                }
                l--;
            }
            System.out.println(sum);
        }
    }

}
