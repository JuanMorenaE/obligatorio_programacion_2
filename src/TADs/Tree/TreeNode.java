package TADs.Tree;

public class TreeNode<K , T> {
    K key;
    T data;
    TreeNode<K, T> parent;
    TreeNode<K, T> leftChild;
    TreeNode<K, T> rightChild;

    public TreeNode(K key, T data, TreeNode<K, T> parent){
        this.key = key;
        this.data = data;
        this.parent = parent;
    }
}
