import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testEqualCharsOffByN() {
        OffByN K = new OffByN(4);
        assertTrue(K.equalChars('a', 'e'));
        assertTrue(K.equalChars('d', 'h'));
        assertFalse(K.equalChars('E', 'E'));
        assertFalse(K.equalChars('a', 'E'));
    }

}
