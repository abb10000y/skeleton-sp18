import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void testEqualChars_OffByOne() {
        OffByOne K = new OffByOne();
        assertTrue(K.equalChars('a','b'));
        assertTrue(K.equalChars('d','c'));
        assertFalse(K.equalChars('E','E'));
        assertFalse(K.equalChars('a','B'));
    }

    @Test
    public void testEqualChars_OffByN() {
        OffByN K = new OffByN(4);
        assertTrue(K.equalChars('a','e'));
        assertTrue(K.equalChars('d','h'));
        assertFalse(K.equalChars('E','E'));
        assertFalse(K.equalChars('a','E'));
    }

}
