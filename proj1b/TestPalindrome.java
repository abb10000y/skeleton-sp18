import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertTrue(palindrome.isPalindrome("c"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        OffByOne K = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat", K));
        assertTrue(palindrome.isPalindrome("flake", K));
    }

    /* 84
    @Test
    public void testIsPalindromeOffByN() {
        OffByN K = new OffByN(5);
        assertFalse(palindrome.isPalindrome("tottwewe", K));
        assertTrue(palindrome.isPalindrome("mouth", K));
    }
    */
}
