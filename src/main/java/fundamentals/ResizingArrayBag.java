package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;

/**
 * The {@code ResizingArrayBag} class represents a bag (or multiset) of generic items. It supports
 * insertion and iterating over the items in arbitrary order.
 *
 * <p>This implementation uses a resizing array. The <em>add</em> operation takes constant amortized
 * time; the <em>isEmpty</em>, and <em>size</em> operations take constant time. Iteration takes time
 * proportional to the number of items.
 */
public class ResizingArrayBag<Item> implements Iterable<Item> {
  private Item[] a; // array of items
  private int n; // number of elements on bag

  /** Initializes an empty bag. */
  @SuppressWarnings("unchecked")
  public ResizingArrayBag() {
    a = (Item[]) new Object[2];
    n = 0;
  }

  /**
   * Is this bag empty?
   *
   * @return true if this bag is empty; false otherwise
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Returns the number of items in this bag.
   *
   * @return the number of items in this bag
   */
  public int size() {
    return n;
  }

  // resize the underlying array holding the elements
  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    assert capacity >= n;
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) copy[i] = a[i];
    a = copy;
  }

  /**
   * Adds the item to this bag.
   *
   * @param item the item to add to this bag
   */
  public void add(Item item) {
    if (n == a.length) resize(2 * a.length); // double size of array if necessary
    a[n++] = item; // add item
  }

  /**
   * Returns an iterator that iterates over the items in the bag in arbitrary order.
   *
   * @return an iterator that iterates over the items in the bag in arbitrary order
   */
  @Override
  @Nonnull
  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<Item> {
    private int i = 0;

    @Override
    public boolean hasNext() {
      return i < n;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      return a[i++];
    }
  }
}
