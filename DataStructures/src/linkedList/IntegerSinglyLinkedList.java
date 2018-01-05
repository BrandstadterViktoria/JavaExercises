package linkedList;


public class IntegerSinglyLinkedList {

    private IntegerNodeSinglyLinkedList head;
    private int size;

    public IntegerSinglyLinkedList() {
    }


    public void addToTheListInSortedOrder(Integer newNumber) {

        IntegerNodeSinglyLinkedList newNode = new IntegerNodeSinglyLinkedList(newNumber);

        if (head == null || newNode.getNumber() <= head.getNumber()) {
            newNode.setNext(head);
            head = newNode;
        }

        IntegerNodeSinglyLinkedList current = head.getNext();
        IntegerNodeSinglyLinkedList previous = head;
        while (current != null && current.getNumber() < newNumber) {
            previous = current;
            current = current.getNext();
        }
        newNode.setNext(current);
        previous.setNext(newNode);

        size++;
    }

    public void print() {
        IntegerNodeSinglyLinkedList current = head;
        System.out.println("HEAD");
        while (current.getNext() != null) {
            System.out.println(current);
            System.out.println("=>");
            current = current.getNext();
        }
    }
}


