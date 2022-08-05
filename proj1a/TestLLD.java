import static org.junit.Assert.*;

import org.junit.Test;

public class TestLLD {

    @Test
    public void testReverse() {
        LinkedListDeque<Integer> A = new LinkedListDeque();
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addFirst(2);
        A.addFirst(1);
        for (int i = 1; i < 6; i++) {
            int a = A.get(i);
            int b = A.getRecursive(i);
            assertEquals(a, b);
        }

    }

}
