import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorIterator<E> implements Iterator<Object>{

  private Vector v;

  VectorIterator(Vector vec){
    v = vec;
  }

  public boolean hasNext() {
    return (!v.isEmpty());
  }

  public Object next() {
    int i = -1;
    if (hasNext()) {
      i++;
      return v.get(i);
    }
    throw new NoSuchElementException("No more elements.");
  }


}
