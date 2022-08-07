public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int c = x - y;
        if (Math.abs(c) == 1) {
            return true;
        }
        return false;
    }
}
