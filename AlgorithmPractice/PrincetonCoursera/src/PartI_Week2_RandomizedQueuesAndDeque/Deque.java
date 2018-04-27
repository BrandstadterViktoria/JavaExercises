package PartI_Week2_RandomizedQueuesAndDeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    /*Programming Assignment 2: Deques and Randomized Queues
Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.*/

    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {

    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        private Node() {
        }

        @Override
        public String toString() {
            return "Node   " + item;
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid item.");
        }
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = first;
            size++;

        } else {
            Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            oldFirst.previous = first;
            size++;
        }
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid item.");
        }
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            last = newNode;
            first = last;
        } else {
            Node oldLast = last;
            last = newNode;
            newNode.previous = oldLast;
            oldLast.next = last;
            last.next = null;
        }
        size++;
    }


    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        Item removeFirstItem = first.item;
        first = first.next;
        first.previous = null;
        size--;
        return removeFirstItem;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        Item dequedItem = last.item;
        last = last.previous;
        last.next = null;
        size--;
        return dequedItem;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            /* not supported */
            throw new UnsupportedOperationException("UnsupportedOperation");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
      

    }

}

