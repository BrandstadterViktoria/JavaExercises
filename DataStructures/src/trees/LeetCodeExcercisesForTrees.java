package trees;

public class LeetCodeExcercisesForTrees {
    public static void main(String[] args) {

        Tree intTree = new Tree();
        /*intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);*/

        intTree.insert(1);
        intTree.insert(2);

        intTree.traversInorder();
        System.out.println(intTree.maxDepth_LC104(intTree.get(1)));
        System.out.println(intTree.minDepth_LC111(intTree.get(1)));

    }


}

