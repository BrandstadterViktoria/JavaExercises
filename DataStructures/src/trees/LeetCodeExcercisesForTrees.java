package trees;

public class LeetCodeExcercisesForTrees {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.insertInTree(1);
        tree1.insertInTree(2);
        tree1.insertInTree(3);


        Tree tree2 = new Tree();
        tree2.insertInTree(1);
        tree2.insertInTree(2);
        tree2.insertInTree(3);

        System.out.println(isSameTree(tree1.root, tree2.root));


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void insert(int value) {
            if (value == val) {
                return;
            }

            if (value < val) {
                if (left == null) {
                    left = new TreeNode(value);
                } else {
                    left.insert(value);
                }

            } else {
                if (right == null) {
                    right = new TreeNode(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static class Tree {
        TreeNode root;

        public void insertInTree(int value) {
            if (root == null) {
                root = new TreeNode(value);
            } else {
                root.insert(value);
            }
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        /*LC 100*/

        if (p == null && q == null)
            return true;


        if (p == null || q == null || p.val != q.val)
            return false;


        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}


