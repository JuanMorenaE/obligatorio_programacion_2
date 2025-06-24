package TADs.Queue;

public interface MyPriorityQueue<T> extends MyQueue<T>{
    public void enqueueWithPriority(T element, double prioridad);
}
