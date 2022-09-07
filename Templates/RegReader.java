package Templates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RegReader {
    static final boolean stdin = true;
    static final String filename = "";
    static Reader in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() {

        }
    }

    public static void main(String[] args) throws Exception {
        if (stdin) {
            in = new Reader();
            out = new PrintWriter(System.out);
        } else {
            in = new Reader(filename + ".in");
            out = new PrintWriter(filename + ".out");
        }
        new Solver();
        out.close();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String filename) throws Exception {
            br = new BufferedReader(new FileReader(filename));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
