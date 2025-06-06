package TADs.Hash;


import TADs.exceptions.ElementoYaExisteException;

public class HashCuadratic implements HashTable{
    final float LOAD_THRESHOLD = 0.75f;

    private HashItem[] hashmap;
    private int elements;

    public HashCuadratic(int size) {
        int hashSize = size;
        if(!isPrime(hashSize))
            hashSize = getNextPrimeNumber(hashSize);
        hashmap = new HashItem[hashSize];
    }

    @Override
    public void insertar(String clave, Object valor) throws ElementoYaExisteException {
        if(loadFactor() > LOAD_THRESHOLD)
            restructureHash();

        HashItem item = new HashItem(clave, valor);
        int hash = getHashCode(item.key);

        if(hashmap[hash] == null){
            hashmap[hash] = item;
            elements++;
            return;
        }

        if(hashmap[hash].key.equals(item.key))
            throw new ElementoYaExisteException();

        int j = 1;
        while((hash + j * j) % hashmap.length != hash && hashmap[(hash + j * j) % hashmap.length] != null){
            if(hashmap[(hash + j * j) % hashmap.length].key.equals(item.key))
                throw new ElementoYaExisteException();
            j++;
        }

        if((hash + j * j) % hashmap.length != hash){
            hashmap[(hash + j * j) % hashmap.length] = item;
            elements++;
        }
    }

    @Override
    public boolean pertenece(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return false;

        if(hashmap[hash].key.equals(clave))
            return true;

        int j = 1;
        while((hash + j * j) % hashmap.length != hash && hashmap[(hash + j * j) % hashmap.length] != null)
            if(hashmap[(hash + j * j) % hashmap.length].key.equals(clave))
                return true;

        return false;
    }

    @Override
    public void borrar(String clave) {
        int hash = getHashCode(clave);

        if(hashmap[hash] == null)
            return;

        if(hashmap[hash].key.equals(clave)){
            hashmap[hash] = null;
            return;
        }

        int j = 1;
        while((hash + j * j) % hashmap.length != hash && hashmap[(hash + j * j) % hashmap.length] != null){
            if(hashmap[(hash + j * j) % hashmap.length].key.equals(clave)){
                hashmap[(hash + j * j) % hashmap.length] = null;
                return;
            }
        }
    }

    public HashItem[] getHashmap() {
        return hashmap;
    }

    public void setHashmap(HashItem[] hashmap) {
        this.hashmap = hashmap;
    }

    private void restructureHash(){
        int newSize = getNextPrimeNumber(hashmap.length * 2);
        elements = 0;
        HashItem[] oldHash = getHashmap();
        setHashmap(new HashItem[newSize]);

        for (HashItem hash : oldHash) {
            insertar(hash.key, hash.value);
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
}
