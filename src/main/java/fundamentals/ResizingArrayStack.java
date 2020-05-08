package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;

/**
 * The {@code ResizingArrayStack} class represents a last-in-first-out (LIFO) stack of generic
 * items. It supports the usual <em>push</em> and <em>pop</em> operations, along with methods for
 * peeking at the top item, testing if the stack is empty, and iterating through the items in LIFO
 * order.
 *
 * <p>This implementation uses a resizing array, which double the underlying array when it is full
 * and halves the underlying array when it is one-quarter full. The <em>push</em> and <em>pop</em>
 * operations take constant amortized time. The <em>size</em>, <em>peek</em>, and <em>is-empty</em>
 * operations takes constant time in the worst case.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a; // array of items
  private int n; // number of elements on stack

  /** Initializes an empty stack. */
  public ResizingArrayStack() {
    a = (Item[]) new Object[2];
    n = 0;
  }

  /**
   * Is this stack empty?
   *
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty() {
    return n == 0;
  }

  /**
   * Returns the number of items in the stack.
   *
   * @return the number of items in the stack
   */
  public int size() {
    return n;
  }

  // resize the underlying array holding the elements
  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    assert capacity >= n;

    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = a[i];
    }
    a = copy;

    // alternative implementation
    // a = java.util.Arrays.copyOf(a, capacity);
  }

  /**
   * Adds the item to this stack.
   *
   * @param item the item to add
   */
  public void push(Item item) {
    if (n == a.length) resize(2 * a.length); // double size of array if necessary
    a[n++] = item; // add item
  }

  /**
   * Removes and returns the item most recently added to this stack.
   *
   * @return the item most recently added
   * @throws java.util.NoSuchElementException if this stack is empty
   */
  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = a[n - 1];
    a[n - 1] = null; // to avoid loitering
    n--;
    // shrink size of array if necessary
    if (n > 0 && n == a.length / 4) resize(a.length / 2);
    return item;
  }

  /**
   * Returns (but does not remove) the item most recently added to this stack.
   *
   * @return the item most recently added to this stack
   * @throws java.util.NoSuchElementException if this stack is empty
   */
  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return a[n - 1];
  }

  /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order.
   */
  @Nonnull
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i;

    public ReverseArrayIterator() {
      i = n - 1;
    }

    @Override
    public boolean hasNext() {
      return i >= 0;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      return a[i--];
    }
  }
}
