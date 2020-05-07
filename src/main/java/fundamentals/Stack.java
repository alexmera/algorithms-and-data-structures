package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;

/**
 * The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items. It supports
 * the usual <em>push</em> and <em>pop</em> operations, along with methods for peeking at the top
 * item, testing if the stack is empty, and iterating through the items in LIFO order.
 *
 * <p>This implementation uses a singly linked list with a static nested class for linked-list
 * nodes. The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 * operations all take constant time in the worst case.
 *
 * @param <Item> the generic type of an item in this stack
 */
public class Stack<Item> implements Iterable<Item> {
  private Node<Item> first; // top of stack
  private int n; // size of the stack

  /** Initializes an empty stack. */
  public Stack() {
    first = null;
    n = 0;
  }

  /**
   * Returns true if this stack is empty.
   *
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the number of items in this stack.
   *
   * @return the number of items in this stack
   */
  public int size() {
    return n;
  }

  /**
   * Adds the item to this stack.
   *
   * @param item the item to add
   */
  public void push(Item item) {
    Node<Item> oldfirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldfirst;
    n++;
  }

  /**
   * Removes and returns the item most recently added to this stack.
   *
   * @return the item most recently added
   * @throws NoSuchElementException if this stack is empty
   */
  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item; // save item to return
    first = first.next; // delete first node
    n--;
    return item; // return the saved item
  }

  /**
   * Returns (but does not remove) the item most recently added to this stack.
   *
   * @return the item most recently added to this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return first.item;
  }

  /**
   * Returns a string representation of this stack.
   *
   * @return the sequence of items in this stack in LIFO order, separated by spaces
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this) {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }

  /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order
   */
  @Override
  @Nonnull
  public Iterator<Item> iterator() {
    return new LinkedIterator(first);
  }

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  private class LinkedIterator implements Iterator<Item> {
    private Node<Item> current;

    public LinkedIterator(Node<Item> first) {
      current = first;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
