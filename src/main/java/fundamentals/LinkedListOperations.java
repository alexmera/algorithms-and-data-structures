package fundamentals;

public class LinkedListOperations {

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public static Node<String> createLikedList() {
    Node<String> first = new Node<>();
    first.item = "to";

    Node<String> second = new Node<>();
    second.item = "be";
    first.next = second;

    Node<String> third = new Node<>();
    third.item = "or";
    second.next = third;

    return first;
  }

  public static Node<String> insertAtTheBeginning() {
    Node<String> first = createLikedList();

    Node<String> oldFirst = first;

    first = new Node<>();
    first.item = "not";
    first.next = oldFirst;

    return first;
  }

  public static Node<String> removeFromTheBeginning() {
    Node<String> first = createLikedList();

    first = first.next;

    return first;
  }

  public static Node<String> insertAtTheEnd() {
    Node<String> first = new Node<>();
    first.item = "to";

    Node<String> second = new Node<>();
    second.item = "be";
    first.next = second;

    Node<String> third = new Node<>();
    third.item = "or";
    second.next = third;
    Node<String> last = third;

    Node<String> oldLast = last;

    last = new Node<>();
    last.item = "not";
    oldLast.next = last;

    return first;
  }

  public static void main(String[] args) {
    Node<String> first = insertAtTheEnd();

    for (Node<String> x = first; x != null; x = x.next) {
      System.out.println(x.item);
    }
  }
}
