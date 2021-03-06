package trees;

public class PracticeTree {

    private PracticeTreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new PracticeTreeNode(value);
        } else {
            root.insert2(value);
        }
    }

    public void traversInorder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traverLevelorder(){
        if(root != null){
            System.out.println(root.getData());
            root.traverseLevelOrder_LC102(root);
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

    public PracticeTreeNode get(int value) {
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

    public int maxDepth_LC104(PracticeTreeNode root) {
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

    public int minDepth_LC111 (PracticeTreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        if(root.getLeft() == null){
            return minDepth_LC111(root.getRight()) + 1;
        }
        if(root.getRight() == null){
            return minDepth_LC111(root.getLeft()) + 1;
        }else{
            return Math.min((minDepth_LC111(root.getLeft())),(minDepth_LC111(root.getRight())) + 1);
        }
    }
}









