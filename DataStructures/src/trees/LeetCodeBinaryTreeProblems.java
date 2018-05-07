package trees;

import java.util.*;

public class LeetCodeBinaryTreeProblems {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.insertInTree(1);
        tree1.insertInTree(2);
        tree1.insertInTree(3);
        tree1.insertInTree(5);

        Tree treeZ = new Tree();

        Tree tree2 = new Tree();
        tree2.insertInTree(1);
        tree2.insertInTree(3);
        tree2.insertInTree(2);
        tree2.insertInTree(5);
        tree2.insertInTree(3);
        tree2.insertInTree(0);
        tree2.insertInTree(9);

        System.out.println(isBalanced(tree1.root));

       /* List<String> test = binaryTreePaths(tree1.root);

        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i));
        }*/
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void insert(int value) {
            if (value == 0) {

            }
            if (left == null) {
                left = new TreeNode(value);
            } else if (right == null) {
                right = new TreeNode(value);

            } else {
                left.insert(value);
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

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static boolean isSymmetric(TreeNode root) {
        /*LC 101*/

        if (root == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return isSymmetricNode(root.left, root.right);

    }

    private static boolean isSymmetricNode(TreeNode node1, TreeNode node2) {

        if (null == node1 && null == node2)
            return true;
        if (null == node1 && null != node2)
            return false;
        if (null != node1 && null == node2)
            return false;

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricNode(node1.left, node2.right) && isSymmetricNode(node1.right, node2.left);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        /*LC 637*/

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avarageOfLevels = new ArrayList<>();
        TreeNode temp = root;
        queue.add(temp);

        while (!queue.isEmpty()) {
            double avarage = 0.0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                avarage += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            avarageOfLevels.add(avarage / n);
        }

        return avarageOfLevels;

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*LC 107*/

        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode temp = root;
        deque.add(temp);
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp = deque.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            list.add(level);

        }
        Collections.reverse(list);
        return list;

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        /*LC102*/

        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }

        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            lists.add(level);
        }
        return lists;

    }

    public static List<Integer> largestValues(TreeNode root) {
        /*LC 515, You need to find the largest value in each row of a binary tree.*/

        List<Integer> largestValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        TreeNode node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            Collections.sort(list);
            Collections.reverse(list);
            largestValues.add(list.get(0));
        }
        return largestValues;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        /*LC 257 Given a binary tree, return all root-to-leaf paths.*/
        List<String> paths = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return Collections.emptyList();
        } else {
            binaryTreepathshelper(root, str, paths);
            return paths;
        }
    }

    private static void  binaryTreepathshelper (TreeNode node, StringBuilder str, List<String> paths){
        if(node == null) {
            return;
        }
        int sBlength = str.length();
        if (node.left == null && node.right == null) {
            str.append(node.val);
            paths.add(str.toString());
            str.delete(sBlength,str.length());
            return;
        }
        str.append(node.val);
        str.append("->");
        binaryTreepathshelper(node.left,str,paths);
        binaryTreepathshelper(node.right, str, paths);
        str.delete(sBlength, str.length());
    }

    public static boolean isBalanced(TreeNode root) {
        /*LC 110*/
        if(root == null) {
            return true;
        }
       return isBalancedHelper(root.left) == isBalancedHelper(root.right);

    }
    private static int isBalancedHelper(TreeNode node) {
        int height;
        if (node == null) {
            return 0;
        } else {
            int left = isBalancedHelper(node.left);
            int right = isBalancedHelper(node.right);
            if (left > right) {
                height = 1 + left;
            } else {
                height = 1 + right;
            }
        }

        return height;
    }
}


