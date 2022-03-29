package p100to199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sergi
 */
public class P116 {

    public static void main(String[] args) {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(s.readLine());
            for (int i = 0; i < n; i++) {
                System.out.println("Hola mundo.");
            }
        } catch (IOException ex) {
        }
    }

}
