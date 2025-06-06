package TADs.Hash;

import TADs.Tree.BinarySearchTree;
import TADs.exceptions.ElementoYaExisteException;
import TADs.exceptions.NodeNotExistsException;

public class HashTree implements HashTable {
    private BinarySearchTree<String, Object>[] hashmap;

    public HashTree(int size) {
        hashmap = new BinarySearchTree[size];
    }

    @Override
    public void insertar(String clave, Object valor) throws ElementoYaExisteException {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            hashmap[hash] = new BinarySearchTree<>();

        try{
            Object find = hashmap[hash].find(clave);
        }catch(NodeNotExistsException e){
            hashmap[hash].insert(clave, valor);
            return;
        }

        throw new ElementoYaExisteException("");
    }

    @Override
    public boolean pertenece(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return false;

        try{
            Object find = hashmap[hash].find(clave); // Si el elemento existe no tira exception por lo tanto hacemos return true en la siguiente linea.
            return true;
        }catch(NodeNotExistsException e){
            return false;
        }
    }

    @Override
    public void borrar(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return;

        hashmap[hash].delete(clave);
    }

    public BinarySearchTree<String, Object>[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(BinarySearchTree<String, Object>[] hashmap) {
        this.hashmap = hashmap;
    }

    private int getHashCode(String key){
        return key.hashCode() % hashmap.length;
    }
}
