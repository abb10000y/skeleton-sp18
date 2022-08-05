import static org.junit.Assert.*;
import org.junit.Test;

public class TestAD {

    @Test
    public void TestCreateAD() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        assertTrue(K.size == 0);
        assertTrue(K.capacity == 1);
        assertTrue(K.first == 0);
        assertTrue(K.end == 0);

    }

    @Test
    public void TestAddFirst() {
        ArrayDeque<String> K = new ArrayDeque<>();
        K.addFirst("a");
        assertTrue(K.size == 1);
        assertTrue(K.capacity == 1);
        assertTrue(K.first == K.capacity);
        assertTrue(K.end == 0);
        assertTrue(K.AD[K.first] == "a");
        assertTrue(K.AD[K.end] == null);
        K.addFirst("b");
        assertTrue(K.size == 2);
        assertTrue(K.capacity == 1);
        assertTrue(K.first == 0);
        assertTrue(K.end == 0);
        assertTrue(K.AD[K.first] == "b");
        assertTrue(K.AD[1] == "a");
        K.addFirst("c");
        assertTrue(K.size == 3);
        assertTrue(K.capacity == 7);
        assertTrue(K.first == 7);
        assertTrue(K.end == 2);
        assertTrue(K.AD[K.first] == "c");
        assertTrue(K.AD[7] == "c");
        assertTrue(K.AD[0] == "b");
        assertTrue(K.AD[1] == "a");
    }

    @Test
    public void TestAddLast() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        K.addLast(1);
        if (K.AD[0] == null) {
            System.out.println("AddLast NG, should be: 1, real be: null");
        } else if (K.AD[0].equals(1)) {
            System.out.println("AddLast OK");
        } else {
            System.out.println("AddLast NG, should be: 1, real be: " + K.AD[0]);
        }
    }

    @Test
    public void TestIsEmpty() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        if (K.isEmpty() == true) {
            System.out.println("IsEmpty_1 OK");
        } else {
            System.out.println("IsEmpty_1 NG");
        }
        K.addFirst(1);
        if (K.isEmpty() != true) {
            System.out.println("IsEmpty_2 OK");
        } else {
            System.out.println("IsEmpty_2 NG");
        }
    }

    @Test
    public void TestSize() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        if (K.size() == 0) {
            System.out.println("Size_1 OK");
        } else {
            System.out.println("Size_1 NG");
        }
        K.addFirst(1);
        if (K.size() == 1) {
            System.out.println("Size_2 OK");
        } else {
            System.out.println("Size_2 NG");
        }
    }

    @Test
    public void TestPrintDeque() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        K.addFirst(1);
        K.addLast(2);
        K.addLast(3);
        System.out.print("PrintoutTest: should be: 1 2 3; real be: ");
        K.printDeque();
    }

    @Test
    public void TestRemove() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        K.addFirst(1);
        K.addLast(2);
        K.addLast(3);
        int x = K.removeFirst();
        assertTrue(x == 1);
        assertTrue(K.size == 2);
        assertTrue(K.capacity == 7);
        assertTrue(K.first == 1);
        assertTrue(K.end == 3);
        assertTrue(K.AD[K.first].equals(2));
        int a = K.removeLast();
        assertTrue(a == 3);
        assertTrue(K.size == 1);
        assertTrue(K.capacity == 7);
        assertTrue(K.first == 1);
        assertTrue(K.end == 2);
        assertTrue(K.AD[K.first].equals(2));
    }

    @Test
    public void TestGet() {
        ArrayDeque<String> K = new ArrayDeque<>();
        K.addFirst("c");
        K.addFirst("b");
        K.addFirst("a");
        assertTrue(K.get(0) == "a");
        assertTrue(K.get(1) == "b");
        assertTrue(K.get(2) == "c");
    }
}
