
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomLeetCodeExercises_1 {

    public static void main(String[] args) {

        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] numbers1 = {1, 0, 1};
//        System.out.println(singleNumber_LC136(numbers));
//        System.out.println(findDuplicates_LC442(numbers));
        Node test = new Node();
       test.maxSumOfThreeSubarrays_LC689(numbers,2);
    }

    public static int singleNumber_LC136(int[] numbers1) {
        HashMap<Integer, Integer> mapOfNumbers1 = new HashMap<>();
        for (int i = 0; i <= numbers1.length - 1; i++) {
            mapOfNumbers1.put(numbers1[i], (mapOfNumbers1.containsKey(numbers1[i]) ? 0 : 1));
        }
        for (int key : mapOfNumbers1.keySet()) {
            int value = mapOfNumbers1.get(key);
            if (value == 1) {
                return key;
            }
        }

        return -1;
    }

    public static List<Integer> findDuplicates_LC442(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Arrays.sort(nums);
        int current;
        int previous;
        if (nums.length < 2) {
            return duplicates;
        }
        for (int i = 0; i < nums.length; i++) {
            previous = nums[i == 0 ? 0 : i - 1];
            current = nums[i == 0 ? i + 1 : i];
            if (previous == current) {
                if (!duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }
            if (i == nums.length - 1 && (nums[nums.length - 1] == nums[nums.length - 2])) {
                if (!duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }

        }
        return duplicates;
    }

    public static class Node {
        private int data;
        private List<Node> children = new ArrayList<>();
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
        private Node(){

        }

        public Node addChild(Node child) {
            child.setParent(this);
            this.children.add(child);
            return child;
        }

        private void setParent(Node parent) {
            this.parent = parent;
        }

        public void addChildren(List<Node> children) {
            children.forEach(each -> each.setParent(this));
            this.children.addAll(children);
        }

        public Node getParent() {
            return parent;
        }

        public int getData() {
            return data;
        }

        public void maxSumOfThreeSubarrays_LC689(int[] nums, int k) {
        /*Input: [1,2,1,2,6,7,5,1], k= 2
        4, 3, 2, 7, 8, 2, 3, 1
          Output: [0, 3, 5]*/
//        List<Integer> parents = new ArrayList<>();
        int[] indexNumbers = new int[nums.length];
        List<Node> trees = new ArrayList<>();
        int dataParent = 0;
            for (int i = 0; i < nums.length -k ; i++) {
                children.add(new Node(nums[i]));
                dataParent += nums[i];
                if ((i + 1) % k == 0) {
//                    parents.add(dataParent);
                    parent = new Node(dataParent);
                    parent.addChildren(children);
                    trees.add(parent);
                    children.clear();
                    dataParent = 0;
                }
            }
            for (int i = 0; i < trees.size() -1; i++) {
                if(i == 0){
                 continue;
                }
               if(trees.get(i).getParent().getData() > trees.get(i - 1).getParent().getData()){

               }

            }


            }




        }
    }





