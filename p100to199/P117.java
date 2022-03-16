package javaapplication34;

import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P117 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        s.nextLine();
        for (int i = 0; i < c; i++) {
            System.out.println("Hola, " + s.nextLine().replace("Soy ", "") + ".");
        }
    }

}
