package trees;

public class LeetCodeExcercisesForTrees {
    public static void main(String[] args) {


    }

    public int maxDepth_LC104(TreeNode root) {
        int height = 0;
        if(root.getData() == 0){
            return 0;
        }
        int left = maxDepth_LC104(root.getLeft());
        int right = maxDepth_LC104(root.getRight());
        if(left > right){
            height = 1 + left;
        }else{
            height = 1 + right;
        }
        return height;
    }
}

