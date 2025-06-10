package TADs.Hash;

import TADs.Tree.BinarySearchTree;
import TADs.exceptions.ElementoYaExisteException;
import TADs.exceptions.NodeNotExistsException;

public class HashTree<K extends Comparable<K>, T extends Comparable<T>> implements HashTable<K, T> {
    private BinarySearchTree<K, T>[] hashmap;

    public HashTree(int size) {
        hashmap = new BinarySearchTree[size];
    }

    @Override
    public void add(K key, T value) throws ElementoYaExisteException {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            hashmap[hash] = new BinarySearchTree<>();

        try{
            Object find = hashmap[hash].find(key);
        }catch(NodeNotExistsException e){
            hashmap[hash].insert(key, value);
            return;
        }

        throw new ElementoYaExisteException("");
    }

    @Override
    public boolean contains(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return false;

        try{
            Object find = hashmap[hash].find(key); // Si el elemento existe no tira exception por lo tanto hacemos return true en la siguiente linea.
            return true;
        }catch(NodeNotExistsException e){
            return false;
        }
    }

    @Override
    public void remove(K key) {
        int hash = getHashCode(key);

        if(hashmap[hash] == null)
            return;

        hashmap[hash].delete(key);
    }

    public BinarySearchTree<K, T>[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(BinarySearchTree<K, T>[] hashmap) {
        this.hashmap = hashmap;
    }

    private int getHashCode(K key){
        return key.hashCode() % hashmap.length;
    }
}
