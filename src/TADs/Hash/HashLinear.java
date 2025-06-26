package TADs.Hash;

import TADs.LinkedList.LinkedList;
import TADs.LinkedList.MyLinkedList;
import TADs.exceptions.ElementoYaExisteException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashLinear<K extends Comparable<K>,  T> implements HashTable<K, T>{
    final float LOAD_THRESHOLD = 0.75f;

    private HashItem<K, T>[] hashmap;
    private int elements;

    public HashLinear(int size) {
        int hashSize = size;
        if(!isPrime(hashSize))
            hashSize = getNextPrimeNumber(hashSize);
        hashmap = new HashItem[hashSize];
    }

    @Override
    public void add(K key, T value) throws ElementoYaExisteException {
        if(loadFactor() > LOAD_THRESHOLD)
            restructureHash();

        HashItem<K, T> item = new HashItem<>(key, value);
        int hash = getHashCode(item.getKey());

        if(hashmap[hash] == null){
            hashmap[hash] = item;
            elements++;
            return;
        }

        if(hashmap[hash].getKey().equals(item.getKey()))
            throw new ElementoYaExisteException();

        int j = 1;
        while((hash + j) % hashmap.length != hash && hashmap[(hash + j) % hashmap.length] != null){
            if(hashmap[(hash + j) % hashmap.length].getKey().equals(item.getKey()))
                throw new ElementoYaExisteException();
            j++;
        }

        if((hash + j) % hashmap.length != hash){
            hashmap[(hash + j) % hashmap.length] = item;
            elements++;
        }
    }

    @Override
    public boolean contains(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return false;

        if(hashmap[hash].getKey().equals(key))
            return true;

        int j = 1;
        while((hash + j) % hashmap.length != hash && hashmap[(hash + j) % hashmap.length] != null){
            if(hashmap[(hash + j) % hashmap.length].getKey().equals(key))
                return true;
            j++;
        }

        return false;
    }

    public T get(K key){
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return null;

        if(hashmap[hash].getKey().equals(key))
            return hashmap[hash].getValue();

        int j = 1;
        while((hash + j) % hashmap.length != hash && hashmap[(hash + j) % hashmap.length] != null){
            if(hashmap[(hash + j) % hashmap.length].getKey().equals(key))
                return hashmap[(hash + j) % hashmap.length].getValue();
            j++;
        }

        return null;
    }


    public void replace(K key, T newValue){
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return;

        if(hashmap[hash].getKey().equals(key))
            hashmap[hash].setValue(newValue);

        int j = 1;
        while((hash + j) % hashmap.length != hash && hashmap[(hash + j) % hashmap.length] != null){
            if(hashmap[(hash + j) % hashmap.length].getKey().equals(key))
                hashmap[(hash + j) % hashmap.length].setValue(newValue);
            j++;
        }
    }

    @Override
    public void remove(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return;

        if(hashmap[hash].getKey().equals(key)){
            hashmap[hash] = null;
            return;
        }

        int j = 1;
        while((hash + j) % hashmap.length != hash && hashmap[(hash + j) % hashmap.length] != null){
            if(hashmap[(hash + j) % hashmap.length].getKey().equals(key)){
                hashmap[hash] = null;
                return;
            }
            j++;
        }
    }

    public HashItem<K, T>[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(HashItem<K, T>[] hashmap) {
        this.hashmap = hashmap;
    }

    public List<HashItem<K, T>> getValueKeys() {
        List<HashItem<K, T>> values = new ArrayList<>();

        for(HashItem<K, T> item : hashmap){
            if(item != null)
                values.add(item);
        }
        return values;
    }

    public List<T> getValues() {
        List<T> values = new ArrayList<>();

        for (HashItem<K, T> item : hashmap)
            if (item != null)
                values.add(item.getValue());

        return values;
    }

    private void restructureHash(){
        int newSize = getNextPrimeNumber(hashmap.length * 2);
        elements = 0;
        HashItem<K, T>[] oldHash = getHashmap();
        setHashmap(new HashItem[newSize]);

        for (HashItem<K, T> hash : oldHash) {
            if(hash == null)
                continue;
            add(hash.getKey(), hash.getValue());
        }
    }

    private int getNextPrimeNumber(int start){
        int number = start + 1;
        while(!isPrime(number))
            number++;
        return number;
    }

    private boolean isPrime(int number){
        if(number == 1)
            return false;

        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    private int getHashCode(String key){
        return key.hashCode() % hashmap.length;
    }

    private float loadFactor(){
        return (float) elements / hashmap.length;
    }

    private int getHashCode(K key){
        return key.hashCode() % hashmap.length;
    }
}
