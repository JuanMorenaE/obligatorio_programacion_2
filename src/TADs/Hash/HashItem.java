package TADs.Hash;

public class HashItem<K extends Comparable<K>, T> implements Comparable<HashItem<K, T>> {
    private K key;
    private T value;

    public HashItem(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(HashItem<K, T> o) {
        return getKey().compareTo(o.getKey());
    }
}
