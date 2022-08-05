public class LinkedListDeque<T> {

    private AList sentinelU;
    private AList sentinelL;
    private int size = 0;

    public LinkedListDeque() {
        sentinelU = new AList(null, null, null);
        sentinelL = new AList(null, null, null);
        sentinelL.end = sentinelU;
        sentinelU.first = sentinelL;
    }

    private class AList {
        AList first;
        T middle;
        AList end;

        public AList(AList f, T m, AList e) {
           first = f;
           middle = m;
           end = e;
        }

        private T getfront(int index) {
            if (index == 0) {
                return this.middle;
            }   return this.end.getfront(index - 1);
        }

        private T getnear(int index) {
            if (index == 0) {
                return this.middle;
            }   return this.first.getnear(index - 1);
        }
    }

    public void addFirst(T item) {
        if (sentinelU.first.equals(sentinelL) == true ) {
            AList T = new AList(sentinelL, item, sentinelU);
            sentinelL.end = T;
            sentinelU.first = T;
        } else {
            AList T = new AList(sentinelL, item, sentinelL.end);
            sentinelL.end.first = T;
            sentinelL.end = T;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (sentinelU.first.equals(sentinelL) == true ) {
            AList T = new AList(sentinelL, item, sentinelU);
            sentinelL.end = T;
            sentinelU.first = T;
        } else {
            AList T = new AList(sentinelU.first, item, sentinelU);
            sentinelU.first.end = T;
            sentinelU.first = T;
        }
        size += 1;
    }

    public boolean isEmpty() {
        if (sentinelU.first.equals(sentinelL) == true ) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        AList Q = this.sentinelL;
        while (Q.end != null) {
                System.out.print(Q.middle + " ");
                Q = Q.end;
            }
        System.out.println("");
    }

    public T removeFirst() {
        if (this.sentinelL.end != this.sentinelU) {
            T T = sentinelL.end.middle;
            sentinelL.end = sentinelL.end.end;
            sentinelL.end.first = sentinelL;
            size -= 1;
            return T;
        }
        return null;
    }

    public T removeLast() {
        if (this.sentinelL.end != this.sentinelU) {
            T T = sentinelU.first.middle;
            sentinelU.first = sentinelU.first.first;
            sentinelU.first.end = sentinelU;
            size -= 1;
            return T;
        }
        return null;
    }

    public T get(int index) {
        if (size == 0 || index > size) {
            return null; 
        } else if (index <= (size / 2)) {
            AList Q = sentinelL;
            while (index + 1 > 0) {
                Q = Q.end;
                index -= 1;
            }
            return Q.middle;
        } else {
            AList Q = sentinelU;
            while (size - index > 0) {
                Q = Q.first;
                index += 1;
            }
            return Q.middle;
        }
    }

    public T getRecursive(int index) {
        if (size == 0 || index > size) {
            return null;
        } else if (index <= (size / 2)) {
            AList T = this.sentinelL.end;
            return T.getfront(index);
        } else {
            AList T = this.sentinelU.first;
            return T.getnear(size - index - 1);
        }
    }


}
