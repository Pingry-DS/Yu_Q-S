import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<E> implements Iterator<Node<E>> {

  private Node<E> current;


  public boolean hasNext() {
    return (current.getNext() != null);
  }

  public Node<E> next() {

    if (hasNext()) {
      return current.getNext();
    }
    throw new NoSuchElementException("No more elements.");
  }



}
