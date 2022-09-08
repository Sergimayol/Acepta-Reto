package Classes;

import java.util.ArrayList;

public class Tree {

    private static int h;
    private static int k;

    static class TreeNode {
        ArrayList<TreeNode> tn;

        public TreeNode() {
            tn = new ArrayList<>();
        }
    }

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

}
