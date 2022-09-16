package AceptaElReto.p600to699;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P616 {

    static Reader in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() throws IOException {
            while (true) {
                int n = in.nextInt();
                if (n == 0) {
                    break;
                }
                int pi = 0, pd = 0;
                boolean ti = true;
                for (int i = 0; i < n; i++) {
                    String s = in.next();
                    if (s.equals("PIC")) {
                        ti = !ti;
                    }
                    if (s.equals("PONG!")) {
                        if (ti) {
                            pi++;
                        } else {
                            pd++;
                        }
                    }
                }
                out.println(pi + " " + pd);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        in = new Reader();
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
