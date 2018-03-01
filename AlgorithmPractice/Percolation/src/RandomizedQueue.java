import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public RandomizedQueue() {
        s = (Item[]) new Object[1];
    }

    // construct an empty randomized queue
    public boolean isEmpty() {
        return N == 0;
    }

    // is the randomized queue empty?
    public int size() {
        return s.length;
    }

    // return the number of items on the randomized queue
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Illegal item");
        }
        if (N == s.length) {
            Item[] copy = (Item[]) new Object[2 * s.length];
            for (int i = 0; i < N; i++)
                copy[i] = s[i];
            s = copy;
        }
        s[N] = item;
        N++;
    }

    // add the item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        RandomOrderIterator r = new RandomOrderIterator();
        Item dequeue = s[r.index];
        s[r.index] = null;
        N--;
        return dequeue;
    }

    // remove and return a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return iterator().next();
    }
    // return a random item (but do not remove it)

    public Iterator<Item> iterator() {

        return new RandomOrderIterator();
    }

    private class RandomOrderIterator implements Iterator<Item> {
        private int i = size();
        private int index = 0;

        public RandomOrderIterator() {

            this.index = StdRandom.uniform((N - 1));
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupported operation.");
            /* not supported */
        }

        public Item next() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return s[index];
        }
    }

// return an independent iterator over items in random order

    public static void main(String[] args) {

        RandomizedQueue<String> test = new RandomizedQueue<>();
        test.enqueue("egy");
        test.enqueue("kettő");
        test.enqueue("három");
        test.dequeue();
    }

}
// unit testing (optional)



