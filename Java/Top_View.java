// Problem statement:
// Given a binary tree , print the nodes in left to right manner as visible from above the tree(Top view)

import java.util.*;

public class Top_View {
    static private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    static TreeNode buildTreeLevelWise() {

        int d = sc.nextInt();

        TreeNode root = new TreeNode(d);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode f = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if (c1 != -1) {
                f.left = new TreeNode(c1);
                q.add(f.left);
            }
            if (c2 != -1) {
                f.right = new TreeNode(c2);
                q.add(f.right);
            }
        }
        return root;
    }

    static void verticalOrderPrint(TreeNode root, Map<Integer, Integer> m, int d) {
        if (root == null) {
            return;
        }
        if (!m.containsKey(d)) {
            m.put(d, root.data);
        }
        verticalOrderPrint(root.left, m, d - 1);
        verticalOrderPrint(root.right, m, d + 1);
    }

    public static void main(String[] args) {
        TreeNode root = buildTreeLevelWise();
        Map<Integer, Integer> m = new TreeMap<>();
        verticalOrderPrint(root, m, 0);

        m.forEach((k, v) -> System.out.print(v + " "));
    }
}
/*
Sample Input
1 2 3 4 5 6  -1 -1 -1 -1 -1 -1 -1

Sample Output
4 2 1 3
*/
//Time complexity : O(n) where n is number of node 
//Space complexity : O(1)