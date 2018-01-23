package trees;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traversInorder() {
        if (root == null) {
            root.traverseInOrder();
        }
    }


//    public void traversPreOrder() {
//        if (root == null) {
//            root.getData();
//            root.traversPreOrder();
//        }
//
//
//    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }


    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public int maxDepth_LC104(TreeNode root) {
        int height;
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth_LC104(root.getLeft());
            int right = maxDepth_LC104(root.getRight());
            if (left > right) {
                height = 1 + left;
            } else {
                height = 1 + right;
            }
            return height;
        }
    }
}





