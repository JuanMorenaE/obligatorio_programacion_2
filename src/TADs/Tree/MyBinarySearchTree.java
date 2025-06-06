package TADs.Tree;

import TADs.LinkedList.LinkedList;

public interface MyBinarySearchTree <K extends Comparable<K>, T>
{
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    LinkedList<K> inOrder();
    LinkedList<K> preOrder();
    LinkedList<K> postOrder();
}
