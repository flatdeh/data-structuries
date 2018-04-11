import java.util.Arrays;

public class ArrayList<T> implements List {
    private static final int INITIAL_CAPASITY = 10;
    private int size;
    private T[] arrayList;

    public ArrayList() {
        this(INITIAL_CAPASITY);
    }

    public ArrayList(int capasity) {
        this.arrayList = (T[]) new Object[capasity];
    }

    private void increaseArrayList() {
        T[] newArray = (T[]) new Object[(int) (arrayList.length * 1.5)];
        System.arraycopy(arrayList, 0, newArray, 0, size);
        arrayList = newArray;
    }

    private void reduceArrayList() {
        T[] newArray = (T[]) new Object[(int) (arrayList.length / 1.5)];
        System.arraycopy(arrayList, 0, newArray, 0, size);
        arrayList = newArray;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }

    public void add(Object value) {
        add((T) value, size);
    }

    public void add(Object value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
        if (size >= arrayList.length) {
            increaseArrayList();
        }
        T[] newArray = (T[]) new Object[size + 1];
        System.arraycopy(arrayList, 0, newArray, 0, index);
        newArray[index] = (T) value;
        System.arraycopy(arrayList, index, newArray, index + 1, size - index);
        arrayList = newArray;
        size++;
    }

    public T remove(int index) {
        validateIndex(index);

        T valueToRemove = arrayList[index];
        T[] newArray = (T[]) new Object[size - 1];
        System.arraycopy(arrayList, 0, newArray, 0, index);
        System.arraycopy(arrayList, index + 1, newArray, index, size - index - 1);
        arrayList = newArray;
        size--;

        if (size > 10 && (arrayList.length / size >= 1.5)) {
            reduceArrayList();
        }

        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);

        return arrayList[index];
    }

    public T set(Object value, int index) {
        validateIndex(index);

        T oldValue = arrayList[index];
        arrayList[index] = (T) value;
        return oldValue;
    }

    public void clear() {
        arrayList = (T[]) new Object[INITIAL_CAPASITY];
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size != 0;
    }

    public boolean contains(Object value) {
        return indexOf((T) value) != -1;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals((T) value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals((T) value)) {
                index = i;
            }
        }
        return index;
    }

    public String toString() {
        return Arrays.toString(arrayList);
    }
}
