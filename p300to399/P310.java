package javaapplication34;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergi
 */
public class P310 {

    private static int h;
    private static int k;

    static void addNode(TreeNode n, String[] in) {
        if (k == in.length) {
            return;
        }
        int hj = Integer.parseInt(in[k++]);
        for (int i = 0; i < hj; i++) {
            n.tn.add(new TreeNode());
        }
        for (TreeNode aux : n.tn) {
            addNode(aux, in);
        }
    }

    static void getHeight(TreeNode n, int t) {
        if (n.tn.isEmpty()) {
            if (t > h) {
                h = t;
                return;
            }
        }
        for (TreeNode aux : n.tn) {
            getHeight(aux, t + 1);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int at;
        at = s.nextInt();
        s.nextLine();
        TreeNode n;
        String[] in;
        for (int i = 0; i < at; i++) {
            in = s.nextLine().split(" ");
            n = new TreeNode();
            k = 0;
            addNode(n, in);
            h = Integer.MIN_VALUE;
            getHeight(n, 1);
            System.out.println(h);
        }
    }

}

class TreeNode {

    ArrayList<TreeNode> tn;

    public TreeNode() {
        tn = new ArrayList<>();
    }
}
