package javaapplication34;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class P174 {

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

    private static boolean isRepetido(int num) {
        int[] cont = new int[10]; // cuenta la cantidad de apariciones de cada digito
        int digito;
        while (num > 0) {
            digito = (int) (num % 10);
            cont[digito]++;
            num /= 10;
        }
        for (digito = 0; digito < 10; digito++) {
            if (cont[digito] > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        final Reader s = new Reader();
        int n = s.nextInt();
        boolean rp, aux;
        for (int i = 0; i < n; i++) {
            int f = s.nextInt(), tmp;
            tmp = f;
            rp = isRepetido(f);
            aux = rp;
            int l = 0, r = 0;
            while (aux == rp) {
                aux = isRepetido(tmp);
                if (aux == rp) {
                    tmp--;
                    l++;
                }
            }
            l--;
            tmp = f;
            aux = rp;
            while (aux == rp) {
                aux = isRepetido(tmp);
                if (aux == rp) {
                    tmp++;
                    r++;
                }
            }
            System.out.println((f - l) + " " + (l + r));
        }
    }

}
