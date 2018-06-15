package com.vlad.datastructures.hashmap;

public interface Map<K, V> {
    Object put(K key, V value);

    Object get(K key);

    int size();

    boolean isEmpty();

    boolean containsKey(K key);
}
