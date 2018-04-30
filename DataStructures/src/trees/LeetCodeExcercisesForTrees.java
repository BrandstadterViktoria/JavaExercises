package trees;


import java.util.*;

public class LeetCodeExcercisesForTrees {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.insertInTree(1);
        tree1.insertInTree(0);
        tree1.insertInTree(1);

        Tree treeZ = new Tree();

        Tree tree2 = new Tree();
        tree2.insertInTree(1);
        tree2.insertInTree(2);
        tree2.insertInTree(3);
        tree2.insertInTree(4);
        tree2.insertInTree(0);
        tree2.insertInTree(0);
        tree2.insertInTree(5);

        List<List<Integer>> test = levelOrderBottom(tree2.root);

        for (int i = 0; i < test.size(); i++) {
            for (int j = 0; j < test.get(i).size(); j++) {
                System.out.print(test.get(i).get(j));
            }
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void insert(int value) {
            if (left == null) {
                left = new TreeNode(value);
            } else if (right == null) {
                right = new TreeNode(value);

            } else if (left != null) {
                left.insert(value);
            } else if (right != null) {
                right.insert(value);
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
}


