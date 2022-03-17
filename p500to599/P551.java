import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P551 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            char[] c = s.nextLine().toCharArray();
            String r = "";
            for (int i = 0; i < c.length; i++) {
                String f = "";
                if (c[i] == '1') {
                    f += c[i];
                    f += c[i + 1];
                    f += c[i + 2];
                    i = i + 2;
                } else {
                    f += c[i];
                    f += c[i + 1];
                    i++;
                }
                r += (char) Integer.parseInt(f);
            }
            System.out.println(r);
        }
    }

}
