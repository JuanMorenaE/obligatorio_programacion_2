package TADs.Hash;

import TADs.LinkedList.LinkedList;
import TADs.exceptions.ElementoYaExisteException;

public class HashOrderedList implements HashTable {
    private LinkedList<HashItem>[] hashmap;

    public HashOrderedList(int size) {
        hashmap = new LinkedList[size];
    }

    @Override
    public void insertar(String clave, Object valor) throws ElementoYaExisteException {
        HashItem item = new HashItem(clave, valor);
        int hash = getHashCode(item.key);

        if(hashmap[hash] == null)
            hashmap[hash] = new LinkedList<>();

        if (hashmap[hash].contains(item))
            throw new ElementoYaExisteException();

        hashmap[hash].addInOrder(item);
    }

    @Override
    public boolean pertenece(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return false;

        for (int i = 0; i < hashmap[hash].getSize(); i++) {
            if(hashmap[hash].get(i).key.equals(clave))
                return true;
        }

        return false;
    }

    @Override
    public void borrar(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return;

        for (int i = 0; i < hashmap[hash].getSize(); i++) {
            if(hashmap[hash].get(i).key.equals(clave)){
                hashmap[hash].remove(i);
                return;
            }
        }
    }

    public LinkedList<HashItem>[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(LinkedList<HashItem>[] hashmap) {
        this.hashmap = hashmap;
    }

    private int getHashCode(String key){
        return key.hashCode() % hashmap.length;
    }
}
