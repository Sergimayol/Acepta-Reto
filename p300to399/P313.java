import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P313 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), sl, g;
        for (int i = 0; i < n; i++) {
            sl = s.nextInt();
            g = s.nextInt();
            System.out.println(((sl + g >= 0) ? "SI" : "NO"));
        }
    }

}
