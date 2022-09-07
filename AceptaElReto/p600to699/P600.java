package AceptaElReto.p600to699;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class P600 {

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
        Reader sc = new Reader();
        while (true) {
            int f = sc.nextInt();
            int c = sc.nextInt();
            if (f == 0 || c == 0) {
                break;
            }
            int[][] m = new int[f][c];
            Set<Integer>[] colsMax = new HashSet[f];
            Set<Integer>[] colsMin = new HashSet[f];
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < c; ++j) {
                    m[i][j] = sc.nextInt();
                }
                colsMax[i] = posMaximos(m[i]);
                colsMin[i] = posMinimos(m[i]);
            }
            boolean puntoSilla = false;
            for (int j = 0; j < c && !puntoSilla; ++j) {
                int[] col = columna(m, j);
                for (int filaMin : posMinimos(col)) {
                    if (colsMax[filaMin].contains(j)) {
                        puntoSilla = true;
                        break;
                    }
                }
                for (int filaMax : posMaximos(col)) {
                    if (colsMin[filaMax].contains(j)) {
                        puntoSilla = true;
                        break;
                    }
                }
            }
            System.out.println(puntoSilla ? "SI" : "NO");
        }
    }

    private static Set<Integer> posMaximos(int[] v) {
        Set<Integer> posMaximos = new HashSet<>();
        posMaximos.add(0);
        int maximo = v[0];
        for (int i = 1; i < v.length; ++i) {
            if (v[i] == maximo) {
                posMaximos.add(i);
            } else if (v[i] > maximo) {
                maximo = v[i];
                posMaximos.clear();
                posMaximos.add(i);
            }
        }
        return posMaximos;
    }

    private static Set<Integer> posMinimos(int[] v) {
        Set<Integer> posMinimos = new HashSet<>();
        posMinimos.add(0);
        int minimo = v[0];
        for (int i = 1; i < v.length; ++i) {
            if (v[i] == minimo) {
                posMinimos.add(i);
            } else if (v[i] < minimo) {
                minimo = v[i];
                posMinimos.clear();
                posMinimos.add(i);
            }
        }
        return posMinimos;
    }

    private static int[] columna(int[][] m, int j) {
        int[] col = new int[m.length];
        for (int i = 0; i < m.length; ++i) {
            col[i] = m[i][j];
        }
        return col;
    }

}
