package AceptaElReto.p200to299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P252 {

    static Reader in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() throws IOException {
            String s = in.nextLine().replaceAll(" ", "");
            while (!(s.equals("XXX"))) {
                out.println(isPalindrome(s.toLowerCase()) ? "SI" : "NO");
                s = in.nextLine().replaceAll(" ", "");
            }
        }

        static boolean isPalindrome(String a) {
            StringBuilder str = new StringBuilder(a);
            return str.reverse().toString().equals(a);
        }
    }

    public static void main(String[] args) throws IOException {
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        boolean hasNext() {
            if (st != null && st.hasMoreTokens()) {
                return true;
            }
            String tmp;
            try {
                br.mark(1000);
                tmp = br.readLine();
                if (tmp == null) {
                    return false;
                }
                br.reset();
            } catch (IOException e) {
                return false;
            }
            return true;
        }
    }

}