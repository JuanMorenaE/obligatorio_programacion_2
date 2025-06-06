package TADs.Tree;

import TADs.LinkedList.LinkedList;
import TADs.exceptions.NodeNotExistsException;

public class BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

    TreeNode<K, T> head;
    int size = 0;

    public BinarySearchTree(){}

    public T find(K key) {
        if(head == null)
            throw new NodeNotExistsException("El nodo con key: " + key + " no existe.");

        T find = findRecursive(key, head);
        if(find == null)
            throw new NodeNotExistsException("El nodo con key: " + key + " no existe.");
        return find;
    }

    private T findRecursive(K key, TreeNode<K, T> head){
        if(head == null)
            return null;

        if(head.key.equals(key))
            return head.data;

        // Lo pongo en una variable aparte para no hacer dos veces la busqueda.
        T findLeft = findRecursive(key, head.leftChild);
        return findLeft != null ? findLeft : findRecursive(key, head.rightChild);
    }

    public void insert(K key, T data) {
        if(head == null)
            head = new TreeNode<>(key, data, null);
        else{
            if(!insertRecursive(key, data, head))
                throw new NodeNotExistsException("El nodo con key: " + key + " no existe.");
        }
        size++;
    }

    private boolean insertRecursive(K key, T data, TreeNode<K, T> head){
        if(head == null)
            return false;

        Comparable<K> headKey = (Comparable<K>) head.key;

        if(headKey.compareTo(key) == 0) {
            return false;
        }

        if(headKey.compareTo(key) > 0){
            if(head.leftChild == null){
                head.leftChild = new TreeNode<>(key, data, head);
                return true;
            }

            return insertRecursive(key, data, head.leftChild);
        }

        if(head.rightChild == null){
            head.rightChild = new TreeNode<>(key, data, head);
            return true;
        }

        return insertRecursive(key, data, head.rightChild);
    }

    public void delete(K key) {
        if(!deleteRecursive(key, head))
            throw new NodeNotExistsException("El nodo con key: " + key + " no existe.");
        size--;
    }

    private boolean deleteRecursive(K key, TreeNode<K, T> head){
        if(head == null)
            return false;

        if(head.key == key){
            head.data = null;

            // Tiene dos nodos hijos.
            if(head.leftChild != null && head.rightChild != null){
                LinkedList<K> inOrderList = inOrder();

                int i = 0;
                while(inOrderList.get(i) != head.key)
                    i++;
                K nextKey = inOrderList.get(++i);
                T nextNode = find(nextKey);

                if(!deleteRecursive(nextKey, head))
                    throw new NodeNotExistsException("El nodo con key: " + nextKey + " no existe."); // No debería ocurrir pero lo ponemos por las dudas.

                head.key = nextKey;
                head.data = nextNode;

                return true;
            }

            // Solo tiene un nodo hijo a la izquierda.
            if(head.leftChild != null){
                head.leftChild.parent = head.parent;
                if(head.parent == null)
                    this.head = head.leftChild;
                else if(head.parent.leftChild == head)
                    head.parent.leftChild = head.leftChild;
                else
                    head.parent.rightChild = head.leftChild;
                return true;
            }

            // Solo tiene un nodo hijo a la derecha.
            if(head.rightChild != null){
                head.rightChild.parent = head.parent;
                if(head.parent == null)
                    this.head = head.rightChild;
                else if(head.parent.leftChild == head)
                    head.parent.leftChild = head.rightChild;
                else
                    head.parent.rightChild = head.rightChild;
                return true;
            }

            // No tiene ningun nodo hijo.
            if(head.parent == null)
                this.head = null;
            else if(head.parent.leftChild == head)
                head.parent.leftChild = null;
            else
                head.parent.rightChild = null;

            return true;
        }
        return deleteRecursive(key, head.leftChild) ||
                deleteRecursive(key, head.rightChild);
    }

    public int size() {
        return size;
    }

    public LinkedList<K> inOrder() {
        return inOrderRecursive(head);
    }

    private LinkedList<K> inOrderRecursive(TreeNode<K, T> head){
        LinkedList<K> list = new LinkedList<>();
        if(head == null)
            return list;

        list.union(inOrderRecursive(head.leftChild));
        list.addLast(head.key);
        list.union(inOrderRecursive(head.rightChild));

        return list;
    }

    public LinkedList<K> preOrder() {
        return preOrderRecursive(head);
    }

    private LinkedList<K> preOrderRecursive(TreeNode<K, T> head){
        LinkedList<K> list = new LinkedList<>();
        if(head == null)
            return list;

        list.addLast(head.key);
        list.union(preOrderRecursive(head.leftChild));
        list.union(preOrderRecursive(head.rightChild));

        return list;
    }

    public LinkedList<K> postOrder() {
        return postOrderRecursive(head);
    }

    private LinkedList<K> postOrderRecursive(TreeNode<K, T> head){
        LinkedList<K> list = new LinkedList<>();
        if(head == null)
            return list;

        list.union(postOrderRecursive(head.leftChild));
        list.union(postOrderRecursive(head.rightChild));
        list.addLast(head.key);

        return list;
    }


}
