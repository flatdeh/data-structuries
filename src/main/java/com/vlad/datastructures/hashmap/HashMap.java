package com.vlad.datastructures.hashmap;

import java.util.Iterator;

public class HashMap<K, V> implements Map<K, V>, Iterable<HashMap.Entry<K, V>> {
    private static final int INITIAL_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75;
    private Entry<K, V>[] buckets;
    ;
    private int size;

    public HashMap() {
        this(INITIAL_CAPACITY);

    }

    public HashMap(int bucketsCount) {
        if (bucketsCount <= 0) {
            throw new IllegalArgumentException("basketSize should be > 0 , bucketsCount =" + bucketsCount);
        }
        this.buckets = (Entry<K, V>[]) new Entry[bucketsCount];
    }

    public V put(K key, V value) {
        if (size >= buckets.length * LOAD_FACTOR) {
            growCapacity();
        }
        if (key == null) {
            return putNullKey(value);
        } else {
            int index = getBucketIndex(key, buckets.length);
            Entry<K, V> bucket = buckets[index];
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    V oldValue = bucket.value;
                    bucket.value = value;
                    return oldValue;
                }
                if (bucket.next == null) {
                    bucket.next = new Entry<>(key, value);
                    size++;
                    return null;
                }
                bucket = bucket.next;
            }
            buckets[index] = new Entry<>(key, value);
            size++;
            return null;
        }
    }

    public V get(K key) {
        if (key == null) {
            return getNullKey();
        } else {
            int index = getBucketIndex(key, buckets.length);
            Entry<K, V> bucket = buckets[index];
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    return bucket.value;
                }
                bucket = bucket.next;
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
        Entry<K, V> bucket;
        if (key == null) {
            bucket = buckets[0];
            while (bucket != null) {
                if (bucket.key == null) {
                    return true;
                }
                bucket = bucket.next;
            }
        } else {
            int index = getBucketIndex(key, buckets.length);
            bucket = buckets[index];
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    return true;
                }
                bucket = bucket.next;
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
        if (size >= buckets.length * LOAD_FACTOR) {
            growCapacity();
        }
        if (key == null) {
            return putNullIfAbsent(value);
        } else {
            int index = getBucketIndex(key, buckets.length);
            Entry<K, V> bucket = buckets[index];
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    return bucket.value;
                }
                if (bucket.next == null) {
                    bucket.next = new Entry<>(key, value);
                    size++;
                    return null;
                }
                bucket = bucket.next;
            }
            buckets[index] = new Entry<>(key, value);
            size++;
            return null;
        }
    }

    private V putNullIfAbsent(V value) {
        Entry<K, V> bucket = buckets[0];
        while (bucket != null) {
            if (bucket.key == null) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        buckets[0] = new Entry<>(null, value);
        size++;
        return null;
    }


    private void growCapacity() {
        int newCapacity = buckets.length * 2;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];

        transferEntries(newBuckets);
        buckets = newBuckets;
    }

    private void transferEntries(Entry<K, V>[] newEntryArray) {
        for (Entry<K, V> bucket : buckets) {
            while (bucket != null) {
                int bucketIndex = getBucketIndex(bucket.key, newEntryArray.length);
                if (newEntryArray[bucketIndex] == null) {
                    newEntryArray[bucketIndex] = new Entry<>(bucket.key, bucket.value);
                } else {
                    Entry<K, V> curEntry = newEntryArray[bucketIndex];
                    while (curEntry != null) {
                        if (curEntry.next == null) {
                            curEntry.next = new Entry<>(bucket.key, bucket.value);
                            break;
                        }
                        curEntry = curEntry.next;
                    }
                }
                bucket = bucket.next;
            }
        }
    }

    private int getBucketIndex(K key, int hashMapLength) {
        if (key == null) {
            return 0;
        }
        int keyHashCode = key.hashCode();
        return keyHashCode == Integer.MIN_VALUE ? 0 : Math.abs(keyHashCode) % hashMapLength;
    }

    private V getNullKey() {
        Entry<K, V> bucket = buckets[0];
        while (bucket != null) {
            if (bucket.key == null) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private V putNullKey(V value) {
        Entry<K, V> bucket = buckets[0];
        while (bucket != null) {
            if (bucket.key == null) {
                V oldValue = bucket.value;
                bucket.value = value;
                return oldValue;
            }
            bucket = bucket.next;
        }
        buckets[0] = new Entry<>(null, value);
        size++;
        return null;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashMapIterator();
    }

    public static class Entry<K, V> {
        private K key;
        private V value;
        private Entry next;

        private Entry() {

        }

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }


    private class HashMapIterator implements Iterator<Entry<K, V>> {
        private int passedElementsCount;
        private int bucketIndex = 0;
        private Entry<K, V> bucket = buckets[0];

        @Override
        public boolean hasNext() {
            return passedElementsCount < size;
        }

        @Override
        public Entry<K, V> next() {
            for (; bucketIndex < buckets.length; ) {
                while (bucket != null) {
                    Entry<K, V> prevEntry = bucket;
                    bucket = bucket.next;
                    passedElementsCount++;
                    return prevEntry;
                }
                bucketIndex++;

                bucket = buckets[bucketIndex];

            }
            return null;
        }

    }
}
