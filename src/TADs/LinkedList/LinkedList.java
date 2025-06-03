package TADs.LinkedList;
import uy.edu.um.practico1.tad.Lista;

public class LinkedList<T> implements Lista<T>{
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public LinkedList() {
    }

    public void add(T value) {
        addFirst(value);
    }

    public void addFirst(T value) {
        Nodo<T> node = new Nodo<>(value);

        if (head == null)
            tail = node;
        else
            node.setNext(head);

        head = node;
        size++;
    }

    public void addLast(T value) {
        Nodo<T> node = new Nodo<>(value);

        if (head == null)
            head = tail = node;
        else{
            Nodo<T> last = tail;
            last.setNext(node);
            tail = node;
        }

        size++;
    }

    public void addInOrder(T value){
        Nodo<T> node = new Nodo<>(value);

        if(head == null){
            head = tail = node;
            size++;
            return;
        }

        Nodo<T> current = head;
        Comparable currentValue = (Comparable) current.getValue();

        if(currentValue.compareTo(node.getValue()) > 0){
            node.setNext(head);
            head = node;
            size++;
            return;
        }

        while(current.getNext() != null){
            currentValue = (Comparable) current.getNext().getValue();

            if(currentValue.compareTo(node.getValue()) > 0){
                node.setNext(current.getNext());
                current.setNext(node);
                size++;
                return;
            }

            current = current.getNext();
        }

        current.setNext(node);
        tail = current;
        size++;

    }

    public void remove(int position) {
        if(head == null || position > size - 1)
            return;

        if(position == 0){
            Nodo delete = head;
            head = delete.getNext();

            delete.setNext(null);
            delete.setValue(null);
        }else{
            Nodo previous = head;
            for(int i = 0; i < position - 1; i++)
                previous = previous.getNext();

            Nodo delete = previous.getNext();
            previous.setNext(delete.getNext());

            if(tail == delete)
                tail = previous;

            delete.setNext(null);
            delete.setValue(null);
        }
        size--;
    }

    public void visualizar(LinkedList P){
        Nodo current = P.head;
        while(current != null){
            int position = (int)current.getValue();
            if(position >= 0 && position < getSize()){
                Nodo node = (Nodo)get(position);
                System.out.println("[ " + position + " ] --> " + node.getValue());
            }
            current = current.getNext();
        }
    }

    public LinkedList intersect(LinkedList P){
        LinkedList newList = new LinkedList();
        Nodo<T> current = P.head;
        while(current != null){
            T value = current.getValue();
            if(contains(value)){
                Nodo newNodo = new Nodo(value);
                newList.addLast(newNodo);
            }

            current = current.getNext();
        }
        return newList;
    }

    public void union(LinkedList P){
        Nodo<T> current = P.head;
        while(current != null){
            addLast(current.getValue());
            current = current.getNext();
        }
    }

    public LinkedList simetricDifference(LinkedList P){
        LinkedList newList = new LinkedList();
        Nodo<T> current = head;
        while(current != null){
            Object value = current.getValue();
            if(!P.contains(value)){
                Nodo newNodo = new Nodo(value);
                newList.addLast(newNodo);
            }
            current = current.getNext();
        }

        current = P.head;
        while(current != null){
            T value = current.getValue();
            if(!contains(value)){
                Nodo newNodo = new Nodo(value);
                newList.addLast(newNodo);
            }
            current = current.getNext();
        }

        return newList;
    }

    public T get(int position) {
        if(position > size - 1)
            return null;

        Nodo<T> current = head;
        for(int i = 0; i < position; i++)
            current = current.getNext();

        return current.getValue();
    }

    public boolean contains(T value) {
        Nodo<T> current = head;
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
}
