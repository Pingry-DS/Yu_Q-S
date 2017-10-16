import java.util.Iterator;
import java.util.*;

public class Vector<E> implements SimpleList<E> {

  private int capacity;
  private Object[] data;
  private int size;

  public Vector() {
    this.capacity = 10;
    this.data = new Object[10];
  }
  public Vector(int n) {
    this.capacity = n;
    this.data = new Object[n];
  }
  /**
   * Returns the number of elements in this list.  If this list contains
   * more than <tt>Integer.MAX_VALUE</tt> elements, returns
   * <tt>Integer.MAX_VALUE</tt>.
   *
   * @return the number of elements in this list
   */

  public int size() {
    return this.size;
  }


  /**
   * Returns <tt>true</tt> if this list contains no elements.
   *
   * @return <tt>true</tt> if this list contains no elements
   */

  public boolean isEmpty() {
    return (size == 0);
  }


  /**
   * Returns <tt>true</tt> if this list contains the specified element.
   * More formally, returns <tt>true</tt> if and only if this list contains
   * at least one element <tt>e</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
   *
   * @param o element whose presence in this list is to be tested
   * @return <tt>true</tt> if this list contains the specified element
   * @throws ClassCastException if the type of the specified element
   *         is incompatible with this list
   * (<a href="Collection.html#optional-restrictions">optional</a>)
   * @throws NullPointerException if the specified element is null and this
   *         list does not permit null elements
   * (<a href="Collection.html#optional-restrictions">optional</a>)
   */
  @SuppressWarnings("unchecked")
  public boolean contains(Object o) {
    return (indexOf(o) >= 0);
  }


  /**
   * Returns an iterator over the elements in this list in proper sequence.
   *
   * @return an iterator over the elements in this list in proper sequence
   */
  @SuppressWarnings("unchecked")
  public Iterator<E> iterator() {
    return new VectorIterator(this);
  }

  /**
   * Appends the specified element to the end of this list (optional
   * operation).
   *
   * <p>Lists that support this operation may place limitations on what
   * elements may be added to this list.  In particular, some
   * lists will refuse to add null elements, and others will impose
   * restrictions on the type of elements that may be added.  List
   * classes should clearly specify in their documentation any restrictions
   * on what elements may be added.
   *
   * @param e element to be appended to this list
   * @return <tt>true</tt> (as specified by {@link Collection#add})
   * @throws UnsupportedOperationException if the <tt>add</tt> operation
   *         is not supported by this list
   * @throws ClassCastException if the class of the specified element
   *         prevents it from being added to this list
   * @throws NullPointerException if the specified element is null and this
   *         list does not permit null elements
   * @throws IllegalArgumentException if some property of this element
   *         prevents it from being added to this list
   */
  @SuppressWarnings("unchecked")
  public boolean add(E e) {
    Object[] alter = new Object[newCapacity(1)];
    Object[] copy = data.clone();
    for (int i = 0; i < size; i++) {
      alter[i] = copy[i];}
    alter[size] = e;
    data = alter;
    size++;
    return true;
  }


  /**
   * Removes the first occurrence of the specified element from this list,
   * if it is present (optional operation).  If this list does not contain
   * the element, it is unchanged.  More formally, removes the element with
   * the lowest index <tt>i</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
   * (if such an element exists).  Returns <tt>true</tt> if this list
   * contained the specified element (or equivalently, if this list changed
   * as a result of the call).
   *
   * @param o element to be removed from this list, if present
   * @return <tt>true</tt> if this list contained the specified element
   * @throws ClassCastException if the type of the specified element
   *         is incompatible with this list
   * (<a href="Collection.html#optional-restrictions">optional</a>)
   * @throws NullPointerException if the specified element is null and this
   *         list does not permit null elements
   * (<a href="Collection.html#optional-restrictions">optional</a>)
   * @throws UnsupportedOperationException if the <tt>remove</tt> operation
   *         is not supported by this list
   */
  @SuppressWarnings("unchecked")
  public boolean remove(Object o) {
    Object[] alter = new Object[newCapacity(-1)];
    Object[] copy = data.clone();
    for (int i = 0; i < indexOf(o); i++) {
      alter[i] = copy[i]; }
    for (int i = indexOf(o)+1;i < (size-1); i++) {
      alter[i] = copy[i]; }
    data = alter;
    size--;
    return true;
  }

  /**
   * Removes all of the elements from this list (optional operation).
   * The list will be empty after this call returns.
   */
  public void clear() {
    while (this.size() > 0) {
      this.remove(size());
    }
  }

  // Comparison and hashing


  /**
   * Compares the specified object with this list for equality.  Returns
   * <tt>true</tt> if and only if the specified object is also a list, both
   * lists have the same size, and all corresponding pairs of elements in
   * the two lists are <i>equal</i>.  (Two elements <tt>e1</tt> and
   * <tt>e2</tt> are <i>equal</i> if <tt>(e1==null ? e2==null :
   * e1.equals(e2))</tt>.)  In other words, two lists are defined to be
   * equal if they contain the same elements in the same order.  This
   * definition ensures that the equals method works properly across
   * different implementations of the <tt>List</tt> interface.
   *
   * @param o the object to be compared for equality with this list
   * @return <tt>true</tt> if the specified object is equal to this list
   */
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (o instanceof Vector) {
       Vector oList = (Vector) o;
       if (oList.size() == this.size) {
           for (int i = 0; i < size; i++) {
             if (!oList.get(i).equals(this.get(i)))
               return false;}
           return true; } }
    else if (o instanceof LinkedList) {
       LinkedList oList = (LinkedList) o;
       if (oList.size() == this.size) {
           for (int i = 0; i < size; i++) {
             if (!oList.get(i).equals(this.get(i)))
               return false;}
           return true; } }
      return false;
    }




  // Positional Access Operations
  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
   */
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < size && index >= 0) {
      E ret = (E) data[index];
      return ret; }
    else {
      throw new IndexOutOfBoundsException("Index out of Bounds"); } }

  /**
   * Replaces the element at the specified position in this list with the
   * specified element (optional operation).
   *
   * @param index index of the element to replace
   * @param element element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws ClassCastException if the class of the specified element
   *         prevents it from being added to this list
   * @throws NullPointerException if the specified element is null and
   *         this list does not permit null elements
   * @throws IllegalArgumentException if some property of the specified
   *         element prevents it from being added to this list
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
   */

  @SuppressWarnings("unchecked")
  public E set(int index, E element) {
    Object[] alter = new Object[size];
    Object[] copy = data.clone();
    for (int i = 0; i < index; i++) {
      alter[i] = copy[i];  }
    Object previous = copy[index];
    E ret = (E) previous;
    alter[index] = element;
    for (int i = index + 1; i < size; i++) {
      alter[i] = copy[i]; }
    data = alter;
    return ret;
  }


  /**
   * Inserts the specified element at the specified position in this list
   * (optional operation).  Shifts the element currently at that position
   * (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified element is to be inserted
   * @param element element to be inserted
   * @throws UnsupportedOperationException if the <tt>add</tt> operation
   *         is not supported by this list
   * @throws ClassCastException if the class of the specified element
   *         prevents it from being added to this list
   * @throws NullPointerException if the specified element is null and
   *         this list does not permit null elements
   * @throws IllegalArgumentException if some property of the specified
   *         element prevents it from being added to this list
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt; size()</tt>)
   */

  public void add(int index, E element) {
    Object[] alter = new Object[newCapacity(1)];
    Object[] copy = data.clone();
    if (index == 0 && size ==0) {
      alter[0] = element;
      size++;
    }
    else if (index < 0 || index > size ) {
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    for (int i = 0; i < index; i++) {
      alter[i] = copy[i];
    }
    alter[index] = element;
    for (int i = index + 1; i < size; i++) {
      alter[i] = copy[i];
    }
    data = alter;

  }


  /**
   * Removes the element at the specified position in this list (optional
   * operation).  Shifts any subsequent elements to the left (subtracts one
   * from their indices).  Returns the element that was removed from the
   * list.
   *
   * @param index the index of the element to be removed
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
   */

  @SuppressWarnings("unchecked")
  public E remove(int index) {

    Object[] alter = new Object[data.length];
    Object[] copy = data.clone();
    Object obj = copy[index];

    if (index > 0) {
    for (int i = 0; i < index; i++) {
      alter[i] = copy[i];
    }

    for (int j = index; j < copy.length - 1; j++) {
      alter[j] = copy[j];
    }
  }
    else if (index == 0) {
      alter[0] = copy[1];
      for (int i = 2; i < alter.length; i++) {
        Object o = copy[i];
      }
    }
    else
      throw new IndexOutOfBoundsException("Index out of range.");
    size--;
    E ret = (E) obj;
    data = alter;
    return ret;


  }

  // Search Operations


  /**
   * Returns the index of the first occurrence of the specified element
   * in this list, or -1 if this list does not contain the element.
   * More formally, returns the lowest index <tt>i</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
   * or -1 if there is no such index.
   *
   * @param o element to search for
   * @return the index of the first occurrence of the specified element in
   *         this list, or -1 if this list does not contain the element
   * @throws ClassCastException if the type of the specified element
   *         is incompatible with this list
   *         (<a href="Collection.html#optional-restrictions">optional</a>)
   * @throws NullPointerException if the specified element is null and this
   *         list does not permit null elements
   *         (<a href="Collection.html#optional-restrictions">optional</a>)
   */
  @SuppressWarnings("unchecked")
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (data[i] == o)
        return i;  }
    return -1;
  }


  /**
  * Determines how the size of the Vector will adjust to the addition / subtraction of elements
  */
    @SuppressWarnings("unchecked")
  public int newCapacity(int n) {
    int newCapacity = capacity;

    if (n > 0) {
      if ((size + 1) > capacity) {
        newCapacity = capacity * 2;
      }
    }
    if (n < 0) {
      if((size -1) < (capacity /2)) {
        newCapacity = capacity/2; }
      }
    return newCapacity;
  }


}
