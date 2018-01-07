package trees;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void insert(int value){
        if( data == value){
            return;
        }
        if( value < data){
            if(leftChild == null){
                leftChild = new TreeNode(value);
            }else {
                leftChild.insert(value);
            }
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }else{
                rightChild.insert(value);
            }
        }
    }
}
