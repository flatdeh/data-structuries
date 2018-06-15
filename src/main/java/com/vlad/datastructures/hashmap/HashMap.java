package com.vlad.datastructures.hashmap;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMap<K, V> implements Map<K, V>, Iterable<HashMap.Entry<K, V>> {
    private static final int INITIAL_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75;
    private ArrayList<Entry<K, V>>[] buskets;
    ;
    private int size;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int basketsCount) {
        if (basketsCount <= 0) {
            throw new IllegalArgumentException("basketSize should be > 0 , basketsCount =" + basketsCount);
        }
        this.buskets = new ArrayList[basketsCount];
        for (int i = 0; i < basketsCount; i++) {
            buskets[i] = new ArrayList<>();
        }
    }

    public V put(K key, V value) {
        if (size >= buskets.length * LOAD_FACTOR) {
            growCapacity();
        }
        if (key == null) {
            return putNullKey(value);
        } else {
            int index = getBusketIndex(key, buskets.length);
            ArrayList<Entry<K, V>> busket = buskets[index];
            for (Entry<K, V> entry : busket) {
                if (key.equals(entry.key)) {
                    V oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
            busket.add(new Entry<>(key, value));
            size++;
        }
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return getNullKey();
        } else {
            int index = getBusketIndex(key, buskets.length);
            for (Entry<K, V> entry : buskets[index]) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
            }
            return null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            for (Entry entry : buskets[0]) {
                if (entry.key == null) {
                    return true;
                }
            }
        } else {
            int index = getBusketIndex(key, buskets.length);
            for (Entry<K, V> entry : buskets[index]) {
                if (key.equals(entry.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void putAll(HashMap<K, V> hashMap) {
        for (Entry<K, V> entry : hashMap) {
            put(entry.key, entry.value);
        }
    }

    public void putAllIfAbsent(HashMap<K, V> hashMap) {
        for (Entry<K, V> entry : hashMap) {
            putIfAbsent(entry.key, entry.value);
        }
    }

    public V putIfAbsent(K key, V value) {
        if (size >= buskets.length * LOAD_FACTOR) {
            growCapacity();
        }
        if (key == null) {
            return putNullIfAbsent(value);
        } else {
            int index = getBusketIndex(key, buskets.length);
            ArrayList<Entry<K, V>> busket = buskets[index];
            for (Entry<K, V> entry : busket) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
            }
            busket.add(new Entry<>(key, value));
            size++;
        }
        return null;
    }

    private V putNullIfAbsent(V value) {
        for (Entry<K, V> entry : buskets[0]) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        buskets[0].add(new Entry<K, V>(null, value));
        size++;
        return null;
    }


    private void growCapacity() {
        int newCapacity = buskets.length * 2;
        ArrayList<Entry<K, V>>[] newBuskets = new ArrayList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuskets[i] = new ArrayList<>();
        }
        transferEntries(newBuskets);
        buskets = newBuskets;
    }

    private void transferEntries(ArrayList<Entry<K, V>>[] newHashMap) {
        for (ArrayList<Entry<K, V>> busket : buskets) {
            for (Entry<K, V> entry : busket) {
                if (entry.key == null) {
                    newHashMap[0].add(entry);
                } else {
                    int index = getBusketIndex(entry.key, newHashMap.length);
                    newHashMap[index].add(entry);
                }
            }
        }
    }

    private int getBusketIndex(K key, int hashMapLength) {
        if (key == null) {
            return 0;
        }
        int keyHashCode = key.hashCode();
        return keyHashCode == Integer.MIN_VALUE ? 0 : Math.abs(keyHashCode) % hashMapLength;
    }

    private V getNullKey() {
        for (Entry<K, V> entry : buskets[0]) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    private V putNullKey(V value) {
        for (Entry<K, V> entry : buskets[0]) {
            if (entry.key == null) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        buskets[0].add((Entry<K, V>) new Entry<>(null, value));
        size++;
        return null;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashMapIterator();
    }

    static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private class HashMapIterator implements Iterator<Entry<K, V>> {
        private int index;
        private int row = 0;
        private int column = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Entry<K, V> next() {
            for (; row < buskets.length; ) {
                for (; column < buskets[row].size(); ) {
                    index++;
                    return buskets[row].get(column++);
                }
                row++;
                column = 0;
            }
            index++;
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
