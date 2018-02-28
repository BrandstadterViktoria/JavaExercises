/*Programming Assignment 2: Deques and Randomized Queues
Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.*/

public class Deque <Item> {
    private Item item;
    private Node first;
    private Node last;
    private int size;

    public Deque() {

    }
    private class Node {
        Item item;
        Node next;

        private Node(Item item){
        }
    }

    // construct an empty deque
    public boolean isEmpty() {
      return first == null;
    }

    // is the deque empty?
    public int size() {
    return size;
    }
    // return the number of items on the deque

    public void addFirst(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
            size ++;
        } else {
            Node oldFirst = first;
            first = newNode;
            newNode.next = oldFirst;
            size ++;
        }
    }
    // add the item to the front

    public void addLast(Item item) {
        Node newNode = new Node(item);
        Node oldlast = last;
        last = newNode;
        last.next = null;
        oldlast.next = last;
        size ++;
        if (isEmpty()) {
            first = last;
            size ++;
        } else {
            oldlast.next = last;
        }
    }
    // add the item to the end

    public Item removeFirst() {
        Item removeFirstItem = first.item;
        first = first.next;
        return removeFirstItem;
    }
    // remove and return the item from the front

    public Item removeLast() {
        Item dequedItem = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;

    }
    // remove and return the item from the end

    public Iterator<Item> iterator()         // return an iterator over items in order from front to end

    public static void main(String[] args)   // unit testing (optional)
}

}
