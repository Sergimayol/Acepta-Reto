package p500to599;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P551 {

    public static void main(String[] args) {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String line = s.readLine();
                if (line.isEmpty()) {
                    break;
                }
                char[] c = line.toCharArray();
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
        } catch (Exception e) {
        }
    }

}
