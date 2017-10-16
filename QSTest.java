import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.lang.IndexOutOfBoundsException;

public class QSTest {

private QLL<String> ql;
private QV<String> qv;
private SLL<String> sl;
private SV<String> sv;

 @Before
 public void setUp(){
   ql = new QLL<String>();
   qv = new QV<String>();
   sl = new SLL<String>();
   sv = new SV<String>();
 }

 /**
 * Tests for the Queue
 */

 @Test  //for LinkedList
 public void testAddQ1() {
   ql.add("Hello");
   ql.add("World");
   assertEquals(ql.peek(), "Hello");
 }

 @Test
 public void testValidRemoveQ1() {
   ql.add("Hello");
   ql.add("World");
   ql.remove();
   assertEquals(ql.peek(), "World");
 }

 @Test //for Vector
 public void testAddQ2() {
   qv.add("Hello");
   qv.add("World");
  assertEquals(qv.peek(), "Hello");
 }

 @Test
 public void testValidRemoveQ2() {
   qv.add("Hello");
   qv.add("World");
   qv.remove();
   assertEquals(qv.peek(), "World");
 }

 /**
 * For Stack
 */

 @Test  //for LinkedList
 public void testAddS1() {
   sl.push("Hello");
   sl.push("World");
   assertEquals(sl.peek(), "World");
 }

 @Test
 public void testValidRemoveS1() {
   sl.push("Hello");
   sl.push("World");
   sl.pop();
   assertEquals(sl.peek(), "Hello");
 }

 @Test //for Vector
 public void testAddS2() {
   sv.push("Hello");
   sv.push("World");
  assertEquals(sv.peek(), "World");
 }

 @Test
 public void testValidRemoveS2() {
   sv.push("Hello");
   sv.push("World");
   sv.pop();
   assertEquals(sv.peek(), "Hello");
 }

 }
