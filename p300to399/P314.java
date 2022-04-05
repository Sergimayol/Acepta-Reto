package p300to399;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class P314 {

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

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int nt = s.nextInt();
            if (nt < 3) {
                for (int j = 0; j < nt; j++) {
                    s.nextInt();
                }
                System.out.println("0 0");
            } else {
                int p = 0, v = 0;
                int iz = s.nextInt(), c = s.nextInt(), d = s.nextInt();
                for (int j = 3; j < nt; j++) {
                    if (iz > c && c < d) {
                        v++;
                    }
                    if (iz < c && c > d) {
                        p++;
                    }
                    iz = c;
                    c = d;
                    d = s.nextInt();
                }
                if (iz > c && c < d) {
                    v++;
                }
                if (iz < c && c > d) {
                    p++;
                }
                System.out.println(p + " " + v);
            }
        }
    }

}
