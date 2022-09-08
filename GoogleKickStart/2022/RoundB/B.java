import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B {

    static Reader in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() throws IOException {
            int c = in.nextInt();
            for (int i = 0; i < c; i++) {
                int ans = 0;
                int num = in.nextInt();
                for (int j = 1; j <= num; j++) {
                    if (num % j == 0) {
                        if (isPalindrome(j)) {
                            ans++;
                        }
                    }
                }
                out.println("Case #" + (i + 1) + ": " + ans);
            }
        }

        static boolean isPalindrome(int number) {
            List<Integer> digits = new ArrayList<>();
            while (number > 0) {
                digits.add(number % 10);
                number /= 10;
            }
            return IntStream.range(0, digits.size() / 2)
                    .allMatch(index -> digits.get(index) == digits.get(digits.size() - 1 - index));
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
