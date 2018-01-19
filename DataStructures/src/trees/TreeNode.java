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
        }
        else{
            if(right == null) {
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
                return left;
            }
        } else {
            if (right != null) {
                return right;
            }
        }

        return null;
    }

    public int min(){
        if(left == null){
            return data;
        }else{
            return left.min();
        }
    }

    public void traverseInOrder(){
        if(left != null){
            left.traverseInOrder();
            System.out.printf(" ");
        }if(right !=null){
            right.traverseInOrder();
        }
    }

    public int max(){
        if(right == null){
            return data;
        }else{
            return right.max();
        }
    }
        public int getData () {
            return data;
        }
        public void setData (int data){
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left){
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right){
            this.right = right;
        }
    public String toString() {
        return "data=" + data;
    }
}
