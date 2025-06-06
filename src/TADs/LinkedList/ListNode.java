package TADs.LinkedList;

public class ListNode<T> {
    private T value;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getCopy(){
        ListNode<T> copy = new ListNode<>(this.value);
        copy.setNext(this.getNext());
        copy.setNext(this.getPrevious());

        return copy;
    }
}