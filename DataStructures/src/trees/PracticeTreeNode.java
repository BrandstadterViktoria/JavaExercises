package trees;

public class PracticeTreeNode {

    private int data;
    private PracticeTreeNode left;
    private PracticeTreeNode right;

    public PracticeTreeNode(int data) {
        this.data = data;

    }

    public void insert2(int value) {
        if (value == data) {
            return;
        }
        if (value < data) {
            if (left == null) {
                left = new PracticeTreeNode(value);
            } else {
                left.insert2(value);
            }
        } else {
            if (right == null) {
                right = new PracticeTreeNode(value);
            } else {
                right.insert2(value);
            }
        }
    }

    public PracticeTreeNode get(int value) {
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

    public void traverseLevelOrder_LC102(PracticeTreeNode root) {
        if (left == null && right != null) {
            System.out.println(data);
        }
        if (left != null && right == null) {
            System.out.println(data);
        }
        if (left != null && right != null) {
            System.out.println(left.data + " ," + right.data);
        }
        if (left != null && right != null) {
            left.traverseLevelOrder_LC102(root);
            right.traverseLevelOrder_LC102(root);
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

    public PracticeTreeNode getLeft() {
        return left;
    }

    public void setLeft(PracticeTreeNode left) {
        this.left = left;
    }

    public PracticeTreeNode getRight() {
        return right;
    }

    public void setRight(PracticeTreeNode right) {
        this.right = right;
    }

    public String toString() {
        return "data=" + data;
    }
}
