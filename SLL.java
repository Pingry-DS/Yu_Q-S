public class SLL<E> extends LinkedList<E> implements Stack<E> {

  public boolean push(E element) {
    super.add(element);
    return true;
  }

  public E pop() {
    return super.remove(super.size() -1);
  }

  public E peek() {
    return super.get(super.size() -1);
  }


}
