import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    @Test
    public void SameNumberTest() {
        assertTrue(Flik.isSameNumber(0,0));
        assertTrue(Flik.isSameNumber(127,127));
    }
}
