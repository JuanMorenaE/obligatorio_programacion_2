package TADs.Stack;
import java.util.EmptyStackException;

public class Stack<T> implements MyStack<T> {
    StackNode<T> top;
    int size;

    public void pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();

        StackNode<T> next = top.getNext();
        top.setData(null);
        top = next;
        size--;
    }

    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();

        return top.getData();
    }

    public void push(T element) {
        StackNode<T> node = new StackNode<>(element);
        node.setNext(top);
        top = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        while(top != null){
            StackNode<T> nextNode = top.getNext();
            top.setData(null);
            top = nextNode;
            size--;
        }
    }
}
