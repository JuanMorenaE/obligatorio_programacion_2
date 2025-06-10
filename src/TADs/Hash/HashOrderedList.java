package TADs.Hash;

import TADs.LinkedList.LinkedList;
import TADs.exceptions.ElementoYaExisteException;

public class HashOrderedList<K extends Comparable<K>, T extends Comparable<T>> implements HashTable<K, T> {
    private LinkedList<HashItem<K, T>>[] hashmap;

    public HashOrderedList(int size) {
        hashmap = new LinkedList[size];
    }

    @Override
    public void add(K clave, T valor) throws ElementoYaExisteException {
        HashItem<K, T> item = new HashItem<>(clave, valor);
        int hash = getHashCode(item.getKey());

        if(hashmap[hash] == null)
            hashmap[hash] = new LinkedList<>();

        if (hashmap[hash].contains(item))
            throw new ElementoYaExisteException();

        hashmap[hash].addInOrder(item);
    }

    @Override
    public boolean contains(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return false;

        for (int i = 0; i < hashmap[hash].getSize(); i++) {
            if(hashmap[hash].get(i).getKey().equals(key))
                return true;
        }

        return false;
    }

    public T get(K key){
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return null;

        for (int i = 0; i < hashmap[hash].getSize(); i++) {
            if(hashmap[hash].get(i).getKey().equals(key))
                return hashmap[hash].get(i).getValue();
        }

        return null;
    }

    @Override
    public void remove(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return;

        for (int i = 0; i < hashmap[hash].getSize(); i++) {
            if(hashmap[hash].get(i).getKey().equals(key)){
                hashmap[hash].remove(i);
                return;
            }
        }
    }

    public LinkedList<HashItem<K, T>>[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(LinkedList<HashItem<K, T>>[] hashmap) {
        this.hashmap = hashmap;
    }

    private int getHashCode(K key){
        return key.hashCode() % hashmap.length;
    }
}
