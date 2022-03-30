package p100to199;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class P134 {

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
        String leer;
        char[] palos = new char[4];
        char[] linnea = new char[8];
        int[] num = new int[4];
        int salida;
        while (!(leer = s.readLine()).equals("0")) {
            int j = 0;
            String[] linea = leer.split(" ");
            for (int i = 0; i < linea.length; i++) {
                linnea[i] = linea[i].charAt(0);
            }
            for (int i = 0; i < palos.length; i++) {
                if (linnea[j] == '1') {
                    num[i] = 10;
                } else {
                    num[i] = (int) linnea[j];
                }
                if (num[i] > 64) {
                    if (num[i] == 65) {
                        num[i] = 14;
                    }
                    if (num[i] == 81) {
                        num[i] = 12;
                    }
                    if (num[i] == 74) {
                        num[i] = 11;
                    }
                    if (num[i] == 75) {
                        num[i] = 13;
                    }
                } else {
                    if (num[i] > 10) {
                        num[i] -= 48;
                    }
                }
                j++;
                palos[i] = linnea[j];
                j++;

            }
            if (comprobarPalos(palos)) {
                if ((salida = comprobar(num)) > 0) {
                    if (salida > 10) {
                        if (salida == 11) {
                            System.out.println("J " + palos[0]);
                        }
                        if (salida == 12) {
                            System.out.println("Q " + palos[0]);
                        }
                        if (salida == 13) {
                            System.out.println("K " + palos[0]);
                        }
                        if (salida == 14) {
                            System.out.println("A " + palos[0]);
                        }
                    } else {
                        System.out.println(salida + " " + palos[0]);
                    }
                } else {
                    System.out.println("NADA");
                }
            } else {
                System.out.println("NADA");
            }
        }

    }

    public static int comprobar(int[] a) {
        Arrays.sort(a);
        int huecos = 0;
        int x = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] > 2) {
                return -1;
            }
            if (a[i + 1] - a[i] > 1) {
                x = i;
                huecos++;
            }
        }
        if (huecos <= 1) {
            if (huecos == 1) {
                return a[x] + 1;
            }
            if (a[a.length - 1] >= 14) {
                return a[0] - 1;
            } else {
                return a[a.length - 1] + 1;
            }
        } else {
            return -1;
        }
    }

    public static boolean comprobarPalos(char[] a) {
        return a[0] == a[1] && a[0] == a[2] && a[0] == a[3];
    }

}
