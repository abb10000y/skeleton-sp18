public class OffByN implements CharacterComparator{

    int n;

    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int c = x - y;
        if (Math.abs(c) == n) {
            return true;
        }
        return false;
    }
}