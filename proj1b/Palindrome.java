public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> K = new LinkedListDeque<>();
        for (char i: word.toCharArray()) {
            K.addLast(i);
        }
        return K;
    }

    private boolean isPalindromeHelp(Deque<Character> K) {
        Character i = K.removeFirst();
        Character j = K.removeLast();
        if (i == null || j == null) {
            return true;
        } else if (i != j) {
            return false;
        }
        return isPalindromeHelp(K);
    }

    public boolean isPalindrome(String word) {
        Deque<Character> K = wordToDeque(word);
        return isPalindromeHelp(K);
    }

    private boolean isPalindromeOffByOneHelp(Deque<Character> K, CharacterComparator cc) {
        Character i = K.removeFirst();
        Character j = K.removeLast();
        if (i == null || j == null) {
            return true;
        } else if (!cc.equalChars(i, j)) {
            return false;
        }
        return isPalindromeOffByOneHelp(K, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> K = wordToDeque(word);
        return isPalindromeOffByOneHelp(K, cc);
    }

    /*
    private boolean isPalindromeOffByNHelp(Deque<Character> K, OffByN N) {
        Character i = K.removeFirst();
        Character j = K.removeLast();
        if (i == null || j == null) {
            return true;
        } else if (!N.equalChars(i, j)) {
            return false;
        }
        return isPalindromeOffByNHelp(K, N);
    }

    public boolean isPalindrome(String word, OffByN N) {
        Deque<Character> K = wordToDeque(word);
        return isPalindromeOffByNHelp(K, N);
    }

    */
}
