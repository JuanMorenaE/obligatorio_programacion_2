package TADs.LinkedList;

public class LinkedList<T extends Comparable<T>> implements MyLinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public LinkedList() {
    }

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        ListNode<T> node = new ListNode<>(value);

        if (head == null)
            tail = node;
        else
            node.setNext(head);

        head = node;
        size++;
    }

    public void addLast(T value) {
        ListNode<T> node = new ListNode<>(value);

        if (head == null)
            head = tail = node;
        else{
            ListNode<T> last = tail;
            last.setNext(node);
            node.setPrevious(last);
            tail = node;
        }

        size++;
    }

    public void addInOrder(T value){
        ListNode<T> node = new ListNode<>(value);

        if(head == null){
            head = tail = node;
            size++;
            return;
        }

        ListNode<T> current = head;
        T currentValue = current.getValue();

        if(currentValue.compareTo(node.getValue()) > 0){
            node.setNext(head);
            head = node;
            size++;
            return;
        }

        while(current.getNext() != null){
            currentValue = current.getNext().getValue();

            if(currentValue.compareTo(node.getValue()) > 0){
                node.setNext(current.getNext());
                current.setNext(node);
                node.setPrevious(current);
                size++;
                return;
            }

            current = current.getNext();
        }

        current.setNext(node);
        node.setPrevious(current);
        tail = current;
        size++;

    }

    public void remove(int position) {
        if(head == null || position > size - 1)
            return;

        if(position == 0){
            ListNode<T> delete = head;
            head = delete.getNext();

            delete.setNext(null);
            delete.setPrevious(null);
            delete.setValue(null);
            tail = null;
        }else{
            ListNode<T> previous = head;
            for(int i = 0; i < position - 1; i++)
                previous = previous.getNext();

            ListNode<T> delete = previous.getNext();
            previous.setNext(delete.getNext());

            if(delete.getNext() != null)
                delete.getNext().setPrevious(previous);

            if(tail == delete)
                tail = previous;

            delete.setNext(null);
            delete.setValue(null);
            delete.setPrevious(null);
        }
        size--;
    }

    public LinkedList<T> intersect(LinkedList<T> P){
        LinkedList<T> newList = new LinkedList<>();
        ListNode<T> current = P.head;
        while(current != null){
            T value = current.getValue();
            if(contains(value))
                newList.addLast(value);

            current = current.getNext();
        }
        return newList;
    }

    public void union(LinkedList<T> P){
        ListNode<T> current = P.head;
        while(current != null){
            add(current.getValue());
            current = current.getNext();
        }
    }

    public LinkedList<T> simetricDifference(LinkedList<T> P){
        LinkedList<T> newList = new LinkedList<>();
        ListNode<T> current = head;
        while(current != null){
            T value = current.getValue();
            if(!P.contains(value))
                newList.add(value);

            current = current.getNext();
        }

        current = P.head;
        while(current != null){
            T value = current.getValue();
            if(!contains(value))
                newList.add(value);

            current = current.getNext();
        }

        return newList;
    }

    public T get(int position) {
        if(position > size - 1)
            return null;

        ListNode<T> current = head;
        for(int i = 0; i < position; i++)
            current = current.getNext();

        return current.getValue();
    }

    public ListNode<T> getNode(int position) {
        if(position > size - 1)
            return null;

        ListNode<T> current = head;
        for(int i = 0; i < position; i++)
            current = current.getNext();

        return current;
    }

    public boolean contains(T value) {
        ListNode<T> current = head;
        while(current != null){
            if(current.getValue().equals(value))
                return true;
            else
                current = current.getNext();
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    public void ShowAllNodes(){
        for(int i = 0; i < size; i++)
            System.out.println("[ " + i + " ] --> " + get(i));
    }

    public void BubbleSort(){
        if(getSize() == 0)
            return;

        boolean changes;
        do{
            changes = false;
            for(int i = 0; i < getSize() - 1; i++){
                ListNode<T> currentNode = getNode(i);
                ListNode<T> nextNode = getNode(i + 1);

                if(currentNode.getValue().compareTo(nextNode.getValue()) > 0){
                    changes = true;
                    T value = currentNode.getValue();
                    currentNode.setValue(nextNode.getValue());
                    nextNode.setValue(value);
                }
            }
        }while(changes);
    }

    public void TrasposicionParImparSort(){
        if(getSize() == 0)
            return;

        boolean changes;
        do{
            changes = false;
            for(int i = 0; i < getSize() - 1; i += 2){
                ListNode<T> currentNode = getNode(i);
                ListNode<T> nextNode = getNode(i + 1);

                if(currentNode.getValue().compareTo(nextNode.getValue()) > 0){
                    changes = true;
                    T value = currentNode.getValue();
                    currentNode.setValue(nextNode.getValue());
                    nextNode.setValue(value);
                }
            }

            for(int i = 1; i < getSize() - 1; i += 2){
                ListNode<T> currentNode = getNode(i);
                ListNode<T> nextNode = getNode(i + 1);

                if(currentNode.getValue().compareTo(nextNode.getValue()) > 0){
                    changes = true;
                    T value = currentNode.getValue();
                    currentNode.setValue(nextNode.getValue());
                    nextNode.setValue(value);
                }
            }
        }while(changes);
    }

    public void SeleccionSort(){
        if(getSize() == 0)
            return;

        boolean changes = false;
        int start = 0;
        do{
            if(start >= getSize() - 1)
                break;

            changes = false;
            T smallest = get(start);
            int smallestIndex = -1;
            for(int i = start; i < getSize(); i++){
                ListNode<T> currentNode = getNode(i);
                if(smallest == null || currentNode.getValue().compareTo(smallest) < 0){
                    changes = true;
                    smallest = currentNode.getValue();
                    smallestIndex = i;
                }
            }

            T firstNodeValue = get(start);
            getNode(start).setValue(smallest);
            getNode(smallestIndex).setValue(firstNodeValue);
            start++;
        }while(changes);
    }

    public void InsercionSort(){
        if(getSize() <= 1)
            return;

        for(int i = 1; i < getSize(); i++){
            ListNode<T> currentNode = getNode(i);
            ListNode<T> previousNode = getNode(i - 1);
            while(previousNode != null && currentNode.getValue().compareTo(previousNode.getValue()) < 0){
                T value = currentNode.getValue();
                currentNode.setValue(previousNode.getValue());
                previousNode.setValue(value);

                currentNode = currentNode.getPrevious();
                previousNode = currentNode.getPrevious();
            }
        }
    }
}
