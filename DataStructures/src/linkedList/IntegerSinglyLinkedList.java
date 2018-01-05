package linkedList;


public class IntegerSinglyLinkedList {

    private IntegerNodeSinglyLinkedList head;
    private int size;

    public IntegerSinglyLinkedList() {
    }

    public void addToTheList(Integer newNumber){
        IntegerNodeSinglyLinkedList newNode = new IntegerNodeSinglyLinkedList(newNumber);

        if(head == null){
            head = newNode;
        }
        if(size == 1){
            head.setNext(newNode);
            newNode.setNext(null);
        }
        else{
            IntegerNodeSinglyLinkedList current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(null);
        }
    }

    public void addToTheListInSortedOrder(Integer newNumber, Integer existingNumber ){

        IntegerNodeSinglyLinkedList newNode = new IntegerNodeSinglyLinkedList(newNumber);
        IntegerNodeSinglyLinkedList current = head;

        while(current.getNumber() != existingNumber){
            current = current.getNext();
        }

        if(head == null){
            head = newNode;
        }else{

            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
        size ++;
    }

}
