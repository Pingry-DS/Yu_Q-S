public class Node<E> {
  private Node<E> prev; //backpointer
  private Node<E> next;
  private E contents;

  public Node(E contents) {
    this.contents = contents;
    this.next = null;
    this.prev = null;
  }

  public Node(E contents, Node<E> prev, Node<E> next) {
      this.prev = prev;
      this.next = next;
      this.contents = contents;
  }

  public void setNext(Node<E> next) {
      this.next = next;
  }

  public void setPrev(Node<E> prev) {
      this.next = prev;
  }

  public void setContents(E contents) {
      this.contents = contents;
  }

  public Node<E> getNext() {
    return next;
  }

  public Node<E> getPrev() {
    return prev;
  }

  public E getContents() {
    return contents;
  }


}
