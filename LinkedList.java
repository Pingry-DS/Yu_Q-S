import java.util.Iterator;

public class LinkedList<E> implements SimpleList<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public Node<E> getHead() {
    return head;
  }

  public Node<E> getTail() {
    return tail;
  }

  public static void main(String[] args) {

  }


   /**
   * Returns the number of elements in this list.
   * @return the number of elements in this list
   */

  public int size() {
    return this.size;
  }


  /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements
   */

  public boolean isEmpty() {
      return (size() == 0);
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

    if (indexOf(o) > -1) {
      return true;
    }

    if (o == null)
      throw new NullPointerException("List does not permit null elements.");

    if(!o.getClass().equals(head.getContents().getClass()))
      throw new ClassCastException("Specified element incompatible");

    return false;
  }


  /**
   * Returns an iterator over the elements in this list in proper sequence.
   *
   * @return an iterator over the elements in this list in proper sequence
   */
  @SuppressWarnings("unchecked")
  public Iterator<E> iterator() {
    Iterator<E> i = new NodeIterator();
    return i;
  }

  // Modification Operations


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
   * @throws ClassCastException if the class of the specified element
   *         prevents it from being added to this list
   * @throws NullPointerException if the specified element is null and this
   *         list does not permit null elements
   * @throws IllegalArgumentException if some property of this element
   *         prevents it from being added to this list
   */
  @SuppressWarnings("unchecked")
  public boolean add(E e) {
    Node n = new Node(e); //prev and next both initially set to null
    if (head == null) { //if first element in list
      head = n;
      tail = n;
      size++;
      return true;
    }
    if(!e.getClass().equals(head.getContents().getClass()))
      throw new ClassCastException("Specified element incompatible");

    n.setPrev(this.tail);
    this.tail.setNext(n);
    tail = n;
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
   */
  @SuppressWarnings("unchecked")
  public boolean remove(Object o) {
    if(!o.getClass().equals(head.getContents().getClass()))
      throw new ClassCastException("Specified element incompatible");
    if( indexOf(o) > -1)  {
        int index = indexOf(o);
        remove(index);
        return true;
  }
    return false;
  }



  /**
   * Removes all of the elements from this list (optional operation).
   * The list will be empty after this call returns.
   */
  @SuppressWarnings("unchecked")
  public void clear() {
    while (size > 0) {
      remove(size);
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
    if (o instanceof LinkedList) {
      LinkedList oList = (LinkedList) o;

    if (oList.size == size) {
      if (head == null) { //empty
        return (oList.getHead() == null);
      }
      if (head == tail) { //one item
        return (oList.getHead() == oList.getTail());
      }

      for (int i = 0; i < size; i++) {
        if (!oList.get(i).equals(get(i)))
          return false;
      }


      return true;
    }
  }

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
    if (head == null) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    if (index > size) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    else {
    Node<E> n = nodeAt(index);
    return n.getContents();
  }
  }


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
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    if(!element.getClass().equals(head.getContents().getClass()))
      throw new ClassCastException("Specified element incompatible");
    if (element == null) {
      throw new NullPointerException("Does not permit null elements.");}
    if (index >= size) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

      Node<E> change = nodeAt(index);
      E prevCont = change.getContents();
      change.setContents(element);
      return prevCont;
  }

  /**
   * Inserts the specified element at the specified position in this list
   * (optional operation).  Shifts the element currently at that position
   * (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified element is to be inserted
   * @param element element to be inserted
   * @throws ClassCastException if the class of the specified element
   *         prevents it from being added to this list
   * @throws NullPointerException if the specified element is null and
   *         this list does not permit null elements
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt; size()</tt>)
   */
  @SuppressWarnings("unchecked")
  public void add(int index, E element) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    if (element == null) {
      throw new NullPointerException("Does not permit null elements.");
    }
    if (index > size ) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
     Node<E> n = new Node<E>(element);

     if (index == 0) { //this works
       head = n;
       tail = n;
       size++;
     }
     else {
     Node changePrev = nodeAt(index);
     Node changeNext = nodeAt(index-1);
     changePrev.setPrev(n);
     n.setNext(changePrev);
     changeNext.setNext(n);
     n.setPrev(changeNext);
   }
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
    if ((index >= size) || (index < 0)) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    Node<E> rem = nodeAt(index);
    size--;
    E contents = rem.getContents();

    
    if (rem.getNext() == null) { //if @ tail, works
      System.out.println(rem.getPrev());
      rem.getPrev().setNext(null);
      return contents;
    }

      if (rem.getPrev() == null) { //if @ head
      rem.getNext().setPrev(null);
      if(!rem.getNext().equals(null)) {
        head = rem.getNext();
      }
      return contents;
    }

  
    Node<E> next = rem.getNext();
    Node<E> prev = rem.getPrev();
    rem.getPrev().setNext(next);
    rem.getNext().setPrev(prev);
    return contents;
  }

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
    if(!o.getClass().equals(head.getContents().getClass()))
      throw new ClassCastException("Specified element incompatible");
    if (o == null) {
      throw new NullPointerException("Does not permit null elements.");}
    int i = 0;
    for (Node<E> current = head; current.getNext() == null; current = current.getNext()) {
      if (current.getContents().equals(o)) {
        return i;
      }
      i++;
    }
    return -1;
  }
  @SuppressWarnings("unchecked")
  public Node<E> nodeAt(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }
}
