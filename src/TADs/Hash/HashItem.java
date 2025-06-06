package TADs.Hash;

public class HashItem implements Comparable<HashItem> {
    String key;
    Object value;

    public HashItem(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(HashItem o) {
        return this.key.compareTo(o.key);
    }
}
