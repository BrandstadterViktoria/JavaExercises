package linkedList;


public class IntegerSinglyLinkedList {

    private IntegerNodeSinglyLinkedList head;
    private int size;

    public IntegerSinglyLinkedList() {
    }

    public void addoTheList(Integer newNumber, Integer existingNumber ){

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
