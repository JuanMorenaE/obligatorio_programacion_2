package TADs.Hash;

import TADs.exceptions.ElementoYaExisteException;

public interface HashTable<K extends Comparable<K>, T extends Comparable<T>> {
    public void add (K clave, T valor) throws ElementoYaExisteException;
    public boolean contains (K clave);
    public void remove (K clave);
}
