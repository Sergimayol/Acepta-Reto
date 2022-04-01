package p400to499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class P464 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String inp = r.readLine();
                if (inp == null) {
                    break;
                }
                int n = Integer.parseInt(inp);
                int sec = 0;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    inp = r.readLine();
                    String total[] = inp.split(":");
                    sec = (Integer.parseInt(total[0]) * 3600) + (Integer.parseInt(total[1]) * 60)
                            + (Integer.parseInt(total[2]));
                    arr[i] = sec;
                }
                int[] ogps = new int[n];
                for (int i = 0; i < n; i++) {
                    ogps[i] = arr[i];
                }
                Arrays.sort(arr);
                int x = 0;
                int pos = 1;
                int mispos = 1;
                int[] aux = new int[n];
                for (int i = 0; i < n; i++) {
                    aux[i] = mispos;
                    pos++;
                    x = i + 1;
                    if (x < n) {
                        if (Math.abs(arr[i] - arr[x]) > 1) {
                            mispos = pos;
                        }

                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (ogps[i] == arr[j]) {
                            System.out.println(aux[j]);
                            break;
                        }
                    }
                }
                System.out.println("---");
            }
        } catch (IOException ex) {
        }
    }

}
