package TADs.Hash;

import TADs.exceptions.ElementoYaExisteException;

public interface HashTable {
    public void insertar (String clave, Object valor) throws ElementoYaExisteException;
    public boolean pertenece (String clave);
    public void borrar (String clave);
}
