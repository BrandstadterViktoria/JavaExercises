package linkedList;

public class IntegerNodeSinglyLinkedList {

    private Integer next;
    private Integer number;

    public IntegerNodeSinglyLinkedList(Integer next) {
        this.next = next;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
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
