package AceptaElReto.p100to199;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class P171 {

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
        while (n != 0) {
            int[] alts = new int[n];
            for (int i = 0; i < n; i++) {
                alts[i] = s.nextInt();
            }
            int aux = 1, max = alts[n - 1];
            for (int i = alts.length - 2; i >= 0; i--) {
                if (alts[i] > max) {
                    aux++;
                    max = alts[i];
                }
            }
            System.out.println(aux);
            n = s.nextInt();
        }
    }

}
