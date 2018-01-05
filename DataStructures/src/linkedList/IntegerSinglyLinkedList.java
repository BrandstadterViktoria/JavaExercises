package linkedList;


public class IntegerSinglyLinkedList {

    private IntegerNodeSinglyLinkedList head;
    private int size;

    public IntegerSinglyLinkedList() {
    }

    public void addToTheList(Integer newNumber) {
        IntegerNodeSinglyLinkedList newNode = new IntegerNodeSinglyLinkedList(newNumber);

        if (head == null) {
            head = newNode;
        }
        if (size == 1) {
            head.setNext(newNode);
            newNode.setNext(null);
        } else {
            IntegerNodeSinglyLinkedList current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(null);
        }
        size++;
    }

    public void addToTheListInSortedOrder(Integer newNumber) {

        IntegerNodeSinglyLinkedList newNode = new IntegerNodeSinglyLinkedList(newNumber);

        if (size == 1 || newNode.getNumber() < head.getNumber()) {
            newNode.setNext(head);
            head.setNext(null);
            newNode = head;

        } else {
            IntegerNodeSinglyLinkedList current = head;
            while (newNode.getNumber() > current.getNumber()) {
                current = current.getNext();
            }
            newNode.setNext(current);



            size++;
        }

    }
