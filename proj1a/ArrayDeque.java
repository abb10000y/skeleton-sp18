public class ArrayDeque<T> {

    /*
    private Object[] AD;
    private int first;
    private int end;
    private int capacity;
    private int size;
    */
    ///*
    public Object[] AD;
    public int first;
    public int end;
    public int capacity;
    public int size;
    //*/
    public ArrayDeque() {
        AD = (T[]) new Object[2];
        first = 0;
        capacity = 1;
        end = 0;
        size = 0;
    }

    private void resize() {
        if (size > 0) {
            T[] K = (T[]) new Object[this.size * 4];
            if (end <= first) {
                System.arraycopy(AD, first, K, 0, capacity - first + 1);
                System.arraycopy(AD, 0, K, capacity - first + 1, size - (capacity - first + 1));
            } else {
                System.arraycopy(AD, first, K, 0, end - first + 1);
            }
            AD = K;
            first = 0;
            end = size;
            capacity = size * 4 - 1;
        }
    }

    public void addFirst(T item) {
        if (item != null) {
            if (size == capacity + 1) {
                resize();
            }
            if (first == 0) {
                first = capacity;
            } else {
                first -= 1;
            }
            AD[first] = item;
            size += 1;
        }
    }

    public void addLast(T item) {
        if (item != null) {
            if (size == capacity + 1) {
                resize();
            }
            if (end == capacity) {
                end = 0;
            }
            AD[end] = item;
            end += 1;
            size += 1;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size > 0) {
            if (first < end) {
                for (int i = first; i < end; i++) {
                    System.out.print(AD[i] + " ");
                }
            } else {
                for (int i = first; i < capacity; i++) {
                    System.out.print(AD[i] + " ");
                }
                for (int i = 0; i < (size - capacity + first); i++) {
                    System.out.print(AD[i] + " ");
                }
            }
            System.out.println("");
        }
    }

    public T removeFirst() {
        if (size != 0) {
            Object x = AD[first];
            if (first == capacity - 1) {
                first = 0;
            }
            first += 1;
            size -= 1;
            return (T) x;
        }
        return null;
    }

    public T removeLast() {
        if (size != 0) {
            if (end == 0) {
                end = capacity;
                Object x = AD[0];
            }
            end -= 1;
            size -= 1;
            Object x = AD[end];
            return (T) x;
        }
        return null;
    }

    public T get(int index) {
        if (size != 0) {
            if (first + index > capacity) {
                index = first + index - capacity - 1;
            } else {
                index = first + index;
            }

            if (AD[index] == null) {
                return null;
            }
            return (T) AD[index];
        }
        return null;
    }
}
