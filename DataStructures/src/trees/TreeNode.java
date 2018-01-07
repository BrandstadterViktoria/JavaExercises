package trees;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }


    public void insert(int value) {
        if (data == value) {
            return;
        }
        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (data == value) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild;
            }
        } else {
            if (rightChild != null) {
                return rightChild;
            }

        }

        return null;
    }

    public int min(){
        if(leftChild == null){
            return data;
        }else{
            return leftChild.min();
        }
    }

    public void traverseInOrder(){
        if(leftChild != null){
            leftChild.traverseInOrder();
            System.out.printf(" ");
        }if(rightChild !=null){
            rightChild.traverseInOrder();
        }
    }

    public int max(){
        if(rightChild == null){
            return data;
        }else{
            return rightChild.max();
        }
    }
        public int getData () {
            return data;
        }
        public void setData (int data){
            this.data = data;
        }

        public TreeNode getLeftChild () {
            return leftChild;
        }

        public void setLeftChild (TreeNode leftChild){
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild () {
            return rightChild;
        }

        public void setRightChild (TreeNode rightChild){
            this.rightChild = rightChild;
        }

    @Override
    public String toString() {
        return "data=" + data;
    }
}
