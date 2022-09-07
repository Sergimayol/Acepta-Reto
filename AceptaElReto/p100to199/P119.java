package AceptaElReto.p100to199;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P119 {

    public static void main(String[] args) {
        Scanner s;
        int lr, e, es;
        //Valores:
        //Esquinas 3
        //Lateral +2
        //En medio +1
        //Soldado solo +5
        s = new Scanner(System.in);
        while (true) {
            es = 0;
            lr = s.nextInt();
            if (lr == 0) {
                break;
            }
            while (true) {
                if (lr <= 1) {
                    if (lr == 1) {
                        es += 5;
                    }
                    break;
                }
                e = (int) Math.sqrt(lr);
                lr -= e * e;
                es += (4 * 3) + (((e - 2) * 4 * 2)) + ((e * e) - ((4 * e) - 4));
            }
            System.out.println(es);
        }
    }

}
