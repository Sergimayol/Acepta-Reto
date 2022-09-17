package AceptaElReto.p600to699;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class P619 {

    static Reader in;
    static PrintWriter out;

    static class Solver {

        // Solution to problem goes here
        Solver() throws IOException {
            while (true) {
                final int w = in.nextInt(), h = in.nextInt();
                if (w == 0 && h == 0) {
                    break;
                }
                if ((w % 8 != 0) || (h % 8 != 0)) {
                    out.println("NO");
                }
                boolean isP = true;
                char[][] map = new char[h][];
                for (int i = 0; i < h; i++) {
                    map[i] = in.readLine().toCharArray();
                }
                for (int i = 0; i < h && isP; i += 8) {
                    for (int j = 0; j < w && isP; j += 8) {
                        Set<Character> set = new HashSet<>();
                        int res1 = i + 8, res2 = j + 8;
                        boolean cont = true;
                        for (int k = i; k < res1 && cont; k++) {
                            for (int l = j; l < res2 && cont; l++) {
                                if (set.size() > 2) {
                                    cont = false;
                                }
                                set.add(map[k][l]);
                            }
                        }
                        isP = set.size() < 3;
                    }
                }
                out.println(isP ? "SI" : "NO");
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

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }

}
