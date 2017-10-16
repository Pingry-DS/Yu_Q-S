public class QLL<E> extends LinkedList<E> implements Queue<E> {

  public E remove() {
    return super.remove(0);
  }


  public E peek() {
    return super.get(0);
  }


}
