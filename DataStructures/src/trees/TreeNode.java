package trees;

public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;

    }

    public void insert(int value) {
        if (value == data) {
            return;
        }
        if (value < data) {
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

    public TreeNode get(int value) {
        if (data == value) {
            return this;
        }
        if (value < data) {
            if (left != null) {
                return left.get(value);
            }
        } else {
            if (right != null) {
                return right.get(value);
            }
        }
        return null;
    }

    public int min() {
        if (left == null) {
            return data;
        } else {
            return left.min();
        }
    }

    public void traverseInOrder() {
        if (left != null) {
            left.traverseInOrder();
        }

        System.out.print(+data + ",    ");

        if (right != null) {
            right.traverseInOrder();
        }
    }

    public void traverseLevelOrder_LC102(TreeNode root) {
        if (left != null && right != null) {
            left.traverseLevelOrder_LC102(root);
            right.traverseLevelOrder_LC102(root);
        }
        if (left != null && right != null) {
        }
        if (left != null && right != null) {
            System.out.println(left.data + " ," + right.data);
        }
        if (left != null && right == null) {
            System.out.println(data);
        }
        if (left == null && right != null) {
            System.out.println(data);
        } else if (right != null) {

        }

    }

    public int max() {
        if (right == null) {
            return data;
        } else {
            return right.max();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String toString() {
        return "data=" + data;
    }
}
