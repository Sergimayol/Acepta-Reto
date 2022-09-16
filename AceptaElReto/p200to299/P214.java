package AceptaElReto.p200to299;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P214 {

    static Scanner in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() throws IOException {
            while (true) {
                int nr = in.nextInt();
                if (nr == 0) {
                    break;
                }
                Map<String, Integer> map = new HashMap<>();
                for (int i = 0; i < nr; i++) {
                    String r = in.next();
                    Integer val = map.get(r);
                    if (val != null) {
                        map.put(r, val + 1);
                    } else {
                        map.put(r, 1);
                    }
                }
                int nrf = in.nextInt();
                for (int i = 0; i < nrf; i++) {
                    String r = in.next();
                    Integer val = map.get(r);
                    if (val != null) {
                        val++;
                    } else {
                        val = 1;
                    }
                    map.put(r, val);
                    out.println(val);
                }
                out.println("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        new Solver();
        out.close();
    }

}
