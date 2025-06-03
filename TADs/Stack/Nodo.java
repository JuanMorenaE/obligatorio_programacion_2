package TADs.Stack;

public class Nodo <T>{
    T data;
    Nodo<T> next;

    public Nodo(T data) {
        this.data = data;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
