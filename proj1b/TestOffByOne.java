import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void testEqualCharsOffByOne() {
        OffByOne K = new OffByOne();
        assertTrue(K.equalChars('a', 'b'));
        assertTrue(K.equalChars('d', 'c'));
        assertFalse(K.equalChars('E', 'E'));
        assertFalse(K.equalChars('a', 'B'));
    }

}
