/*Programming Assignment 2: Deques and Randomized Queues
Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.*/

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public Deque() {

    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        private Node(Item item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node   " + item;
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
            size++;

        } else {
            Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            oldFirst.previous = first;
            size++;
            if (size == 2) {
                last = first.next;
            }
        }
    }
    // add the item to the front

    public void addLast(Item item) {
        Node newNode = new Node(item);
        Node oldLast = last;
        last = newNode;
        newNode.previous = oldLast;
        oldLast.next = last;
        last.next = null;
        size++;
        if (isEmpty()) {
            first = last;
            size++;
        } else {
            oldLast.next = last;
        }
    }
    // add the item to the end

    public Item removeFirst() {
        Item removeFirstItem = first.item;
        first.next.previous = null;
        first = first.next;
        size--;
        return removeFirstItem;
    }
    // remove and return the item from the front

    public Item removeLast() {
        Item dequedItem = last.item;
        last = last.previous;
        last.next = null;
        size--;
        return dequedItem;
    }
    // remove and return the item from the end

    public Iterator<Item> iterator() {
        return null;

    }
    // return an iterator over items in order from front to end

    private void print() {
        Node current = first;
        while ((current != null)) {
            System.out.print(current);
            System.out.print("  -->  ");
            current = current.next;
        }
    }


    public static void main(String[] args) {
        Deque<String> test = new Deque<>();
        test.addFirst("egy");
        test.addFirst("kettő");
        test.addLast("nulla");
        test.addFirst("három");
        test.print();
        test.removeFirst();
        test.removeLast();
        test.print();

    }// unit testing (optional)
}