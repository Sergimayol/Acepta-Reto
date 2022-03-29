package p100to199;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Sergi
 */
public class P184 {

    public static void main(String[] args) {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int n;
        try {
            while (true) {
                n = Integer.parseInt(s.readLine());
                if (n == 0) {
                    break;
                }
                int min = 0, horas = 0, minT = 0;
                for (int i = 0; i < n; i++) {
                    String[] aux = s.readLine().split("-");
                    String[] h1 = aux[0].split(":");
                    String[] h2 = aux[1].split(":");
                    int hora1 = Integer.parseInt(h1[0]);
                    int hora2 = Integer.parseInt(h2[0]);
                    int min1 = Integer.parseInt(h1[1]);
                    int min2 = Integer.parseInt(h2[1]);
                    int aux1 = (hora1 * +60) + min1;
                    int aux2 = (hora2 * +60) + min2;
                    if (aux1 > aux2) {
                        minT = minT + (((24 * 60) - aux1) + aux2);
                    } else {
                        minT = minT + (aux2 - aux1);
                    }
                }
                System.out.println(P184.toHours(minT));
            }
        } catch (Exception e) {
        }
    }

    public static String toHours(int minutos) {
        String hora = "";
        int horas = (int) minutos / 60;
        int min = minutos % 60;
        if (horas < 10) {
            hora = hora + "0" + horas;
        } else {
            hora = hora + horas;
        }
        if (min < 10) {
            hora = hora + ":0" + min;
        } else {
            hora = hora + ":" + min;
        }
        return hora;
    }
}
