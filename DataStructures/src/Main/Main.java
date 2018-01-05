package Main;
import linkedList.Employee;
import linkedList.EmployeeDoublyLinkedList;
import linkedList.IntegerSinglyLinkedList;

public  class Main {
    public static void main(String[] args) {

        /*Employee Mary = new Employee("Mary",56);
        Employee Jackie = new Employee("Jackie",45);
        Employee Bonie = new Employee("Bonie",67);
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToTheFront(Mary);
        list.addToTheFront(Jackie);
        list.print();

        list.addBefore(Bonie,Mary);
        list.print();*/

        IntegerSinglyLinkedList list = new IntegerSinglyLinkedList();
        list.addToTheListInSortedOrder(4);
        list.addToTheListInSortedOrder(2);
        list.addToTheListInSortedOrder(1);
        list.addToTheListInSortedOrder(5);
        list.print();




        /*MyStack palindrome = new MyStack("I did, did I?");
        for (char character : palindrome.getWord().toCharArray()) {
            palindrome.push(character);
        }
        palindrome.print();
        System.out.println(palindrome.isItAPalindrome(palindrome.getWord()));*/

    }

}
