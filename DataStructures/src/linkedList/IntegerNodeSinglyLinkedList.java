package linkedList;

public class IntegerNodeSinglyLinkedList {

    private IntegerNodeSinglyLinkedList next;
    private Integer number;

    public IntegerNodeSinglyLinkedList(Integer number) {
        this.number = number;
    }

    public IntegerNodeSinglyLinkedList getNext() {
        return next;
    }

    public void setNext(IntegerNodeSinglyLinkedList next) {
        this.next = next;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "number=" + number;
    }
}
