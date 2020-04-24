package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code Bag} class represents a bag (or multiset) of generic items.
 * <p>
 * It supports insertion and iterating over the items in arbitrary order.
 * <p>
 * This implementation uses a singly linked list with a static nested class Node. The <em>add</em>,
 * <em>isEmpty</em>, and <em>size</em> operations take constant time. Iteration takes time
 * proportional to the number of items.
 * <p>
 *
 * @param <Item> the generic type of an item in this bag
 */
public class Bag<Item> implements Iterable<Item> {

  private Node<Item> first;    // beginning of bag
  private int n;               // number of elements in bag

  /**
   * Initializes an empty bag.
   */
  public Bag() {
    first = null;
    n = 0;
  }

  /**
   * Returns true if this bag is empty.
   *
   * @return {@code true} if this bag is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the number of items in this bag.
   *
   * @return the number of items in this bag
   */
  public int size() {
    return n;
  }

  /**
   * Adds the item to this bag.
   *
   * @param item the item to add to this bag
   */
  public void add(Item item) {
    Node<Item> oldfirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldfirst;
    n++;
  }


  /**
   * Returns an iterator that iterates over the items in this bag in arbitrary order.
   *
   * @return an iterator that iterates over the items in this bag in arbitrary order
   */
  @Override
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
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
