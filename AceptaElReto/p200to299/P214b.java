package AceptaElReto.p200to299;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P214b {
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

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        Reader(String filename) throws Exception {
            br = new BufferedReader(new FileReader(filename));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
