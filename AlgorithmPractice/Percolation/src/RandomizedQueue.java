import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Illegal item");
        }
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N] = item;
        N++;
        size++;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = StdRandom.uniform(0,N);
        Item dequeue = s[index];
        s[index] = s[N-1];
        s[index] = null;
        N--;
        size--;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return dequeue;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return s[StdRandom.uniform(N)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomOrderIterator();
    }

    private class RandomOrderIterator implements Iterator<Item> {
        private int i = N;
        private Item[] itemsIterator;

        public RandomOrderIterator() {
            createCopy();
            StdRandom.shuffle(itemsIterator);
        }

        private void createCopy(){
            itemsIterator = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                itemsIterator[i] = s[i];
            }
        }

        public boolean hasNext() {
            return i < N;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupported operation.");
            /* not supported */
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return itemsIterator[i++];
        }
    }


    public static void main(String[] args) {

        RandomizedQueue<String> test = new RandomizedQueue<>();
        test.enqueue("egy");
        test.enqueue("kettő");
        test.enqueue("három");
        test.dequeue();
    }

}




