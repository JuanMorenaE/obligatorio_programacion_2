package uy.edu.um.practico4.TADs.List;

public class List<T>  {
    ListNode<T> head;

    public List() {
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    public void add(ListNode<T> node) {
        if (head != null)
            node.next = head;
        head = node;
    }

    public ListNode<T> get(int position) {
        if(position < 0)
            return null;

        ListNode<T> currentNode = head;
        int currentPosition = 0;
        while(currentNode != null && currentPosition < position){
            currentNode = currentNode.next;
            currentPosition++;
        }
        return currentNode;
    }

    public void remove(int position) {
        if(position < 0)
            return;

        if(position == 0)
            head = null;
        else{
            ListNode<T> currentNode = head;
            int currentPosition = 0;
            while(currentNode.next != null && currentPosition < position - 1){
                currentNode = currentNode.next;
                currentPosition++;
            }

            if(currentNode.next != null)
                currentNode.next = currentNode.next.next;
        }
    }

    public List<T> crearNuevaLista(){
        List<T> newList = new List<>();
        ListNode<T> currentNode = head;
        while(currentNode != null){
            Comparable nodeItem = (Comparable) currentNode.item;
            if(nodeItem.compareTo(0) >= 0){
                ListNode<T> newNode = new ListNode<>(currentNode.item);
                newList.add(newNode);
            }

            currentNode = currentNode.next;
        }
        return newList;
    }

    public void eliminarNodosPositivos(){
        if(head == null)
            return;

        ListNode<T> currentNode = head;
        Comparable nodeItem = (Comparable) currentNode.item;
        while(currentNode != null && nodeItem.compareTo(0) >= 0) {
            head = currentNode.next;
            currentNode = head;
            nodeItem = (Comparable) currentNode.item;
        }

        if(currentNode != null){
            while(currentNode.next != null){
                nodeItem = (Comparable) currentNode.next.item;
                if(nodeItem.compareTo(0) >= 0)
                    currentNode.next = currentNode.next.next;
                else
                    currentNode = currentNode.next;
            }
        }

    }

    public void ShowAllNodes(){
        ListNode currentNode = head;
        int currentPosition = 0;
        while(currentNode != null){
            System.out.println("[ " + currentPosition + " ] --> " + currentNode.item);
            currentNode = currentNode.next;
            currentPosition++;
        }
    }
}
