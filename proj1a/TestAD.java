import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Type;

public class TestAD {

    @Test
    public void TestCreateAD() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
    }

    @Test
    public void TestAddFirst() {
        ArrayDeque<String> K = new ArrayDeque<>();
        K.addFirst("a");
        if (K.AD[1] == "a") {
            System.out.println("AddFirst OK");
        } else {
            System.out.println("AddFirst NG, should be: 1, real be: " + K.AD[1]);
        }
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
    public void TestRemoveFirst() {
        ArrayDeque<Integer> K = new ArrayDeque<>();
        K.addFirst(1);
        System.out.println("RemoveFirst, should be: 1, real be: " + K.removeFirst());
    }

    @Test
    public void TestGet() {
        ArrayDeque<String> K = new ArrayDeque<>();
        assertEquals(null, K.get(5));
        K.addFirst("A");
        assertTrue(K.get(0).equals("A"));
    }
}
