
public class ArrayList<T> implements List {
    private int size = 10;
    private int capasity = 0;
    private T[] arrayList;

    public ArrayList() {
        this.arrayList = (T[]) new Object[size];
    }

    private void increase() {
        size = size + 5;
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(arrayList, 0, newArray, 0, capasity);
        arrayList = newArray;
    }

    private void reduce() {
        size = size - 5;
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(arrayList, 0, newArray, 0, capasity);
        arrayList = newArray;
    }

    public void add(Object value) {
        if (capasity + 1 >= size) {
            increase();
        }
        arrayList[capasity] = (T) value;
        capasity++;
    }

    public void add(Object value, int index) {
        if (index < size) {
            if (capasity + 1 >= size) {
                increase();
            }
            T[] newArray = (T[]) new Object[size];
            System.arraycopy(arrayList, 0, newArray, 0, index);
            newArray[index] = (T) value;
            System.arraycopy(arrayList, index, newArray, index + 1, size - index - 1);
            arrayList = newArray;
            capasity++;
        } else {
            throw new IndexOutOfBoundsException("\"index\" is larger than ArrayList size");
        }
    }

    public T remove(int index) {
        if (index < size) {
            T obj = arrayList[index];
            T[] newArray = (T[]) new Object[size];
            System.arraycopy(arrayList, 0, newArray, 0, index);
            System.arraycopy(arrayList, index + 1, newArray, index, size - index - 1);
            arrayList = newArray;
            capasity--;

            if (size > 10 && (size - capasity >= 5)) {
                reduce();
            }
            return obj;

        } else {
            throw new IndexOutOfBoundsException("\"index\" is larger than ArrayList size");
        }
    }

    public T get(int index) {
        if (index < size) {
            return arrayList[index];
        } else {
            throw new IndexOutOfBoundsException("\"index\" is larger than ArrayList size");
        }
    }

    public T set(Object value, int index) {
        if (index < size) {
            T obj = arrayList[index];
            arrayList[index] = (T) value;
            return obj;
        } else {
            throw new IndexOutOfBoundsException("\"index\" is larger than ArrayList size");
        }
    }

    public void clear() {
        arrayList = (T[]) new Object[size];
        capasity = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return capasity == 0 ? true : false;
    }

    public boolean contains(Object value) {
        for (T v : arrayList) {
            if (v == (T) value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value) {
        for (int i = 0; i <= capasity; i++) {
            if (arrayList[i] == (T) value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = 0; i <= capasity; i++) {
            if (arrayList[i] == (T) value) {
                index = i;
            }
        }
        return index;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= capasity - 1; i++) {
            stringBuilder.append("[" + (T) arrayList[i] + "] ");
        }
        return stringBuilder.toString();
    }
}
