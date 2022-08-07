public class LinkedListDeque<T> implements Deque<T> {

    private LinkedListDeque sentinelU;
    private LinkedListDeque sentinelL;
    private int size = 0;
    private LinkedListDeque first;
    private T middle;
    private LinkedListDeque end;

    private LinkedListDeque(LinkedListDeque f, T m, LinkedListDeque e) {
        first = f;
        middle = m;
        end = e;
    }

    public LinkedListDeque() {
        sentinelU = new LinkedListDeque(null, null, null);
        sentinelL = new LinkedListDeque(null, null, null);
        sentinelL.end = sentinelU;
        sentinelU.first = sentinelL;
        first = sentinelL;
        end = sentinelU;
        size = 0;
    }
/*
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
*/

    @Override
    public void addFirst(T item) {
        if (sentinelU.first.equals(sentinelL)) {
            LinkedListDeque T = new LinkedListDeque(sentinelL, item, sentinelU);
            sentinelL.end = T;
            sentinelU.first = T;
        } else {
            LinkedListDeque T = new LinkedListDeque(sentinelL, item, sentinelL.end);
            sentinelL.end.first = T;
            sentinelL.end = T;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (sentinelU.first.equals(sentinelL)) {
            LinkedListDeque T = new LinkedListDeque(sentinelL, item, sentinelU);
            sentinelL.end = T;
            sentinelU.first = T;
        } else {
            LinkedListDeque T = new LinkedListDeque(sentinelU.first, item, sentinelU);
            sentinelU.first.end = T;
            sentinelU.first = T;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return (sentinelU.first.equals(sentinelL));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkedListDeque Q = this.sentinelL;
        while (Q.end != null) {
            System.out.print(Q.middle + " ");
            Q = Q.end;
        }
        System.out.println("");
    }

    @Override
    public T removeFirst() {
        if (this.sentinelL.end != this.sentinelU) {
            T T = (T) sentinelL.end.middle;
            sentinelL.end = sentinelL.end.end;
            sentinelL.end.first = sentinelL;
            size -= 1;
            return T;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (this.sentinelL.end != this.sentinelU) {
            T T = (T) sentinelU.first.middle;
            sentinelU.first = sentinelU.first.first;
            sentinelU.first.end = sentinelU;
            size -= 1;
            return T;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (size == 0 || index > size) {
            return null;
        } else if (index <= (size / 2)) {
            LinkedListDeque Q = sentinelL;
            while (index + 1 > 0) {
                Q = Q.end;
                index -= 1;
            }
            return (T) Q.middle;
        } else {
            LinkedListDeque Q = sentinelU;
            while (size - index > 0) {
                Q = Q.first;
                index += 1;
            }
            return (T) Q.middle;
        }
    }

    public T getRecursive(int index) {
        if (size == 0 || index > size) {
            return null;
        } else if (index <= (size / 2)) {
            LinkedListDeque T = this.sentinelL.end;
            return (T) T.getfront(index);
        } else {
            LinkedListDeque T = this.sentinelU.first;
            return (T) T.getnear(size - index - 1);
        }
    }

    private T getfront(int index) {
        if (index == 0) {
            return this.middle;
        }
        return (T) this.end.getfront(index - 1);
    }

    private T getnear(int index) {
        if (index == 0) {
            return this.middle;
        }
        return (T) this.first.getnear(index - 1);
    }

}
