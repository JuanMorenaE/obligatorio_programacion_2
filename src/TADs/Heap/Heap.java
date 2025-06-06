package TADs.Heap;

import TADs.LinkedList.LinkedList;
import TADs.LinkedList.ListNode;

public class Heap<T extends Comparable<T>> {
    private int size;
    boolean useMaxHeap;

    private LinkedList<T> list = new LinkedList<>();

    public Heap(boolean useMaxHeap) {
        this.useMaxHeap = useMaxHeap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedList<T> getList() {
        return list;
    }

    public void setList(LinkedList<T> list) {
        this.list = list;
    }

    public void insert(T value){
        list.addLast(value);

        if(list.getSize() == 1)
            return;

        int currentIndex = list.getSize() - 1;
        ListNode<T> currentNode = list.getNode(currentIndex);

        while(currentIndex > 0){

            int parentIndex = (currentIndex - 1) / 2;
            ListNode<T> parentNode = list.getNode(parentIndex);

            if(useMaxHeap){
                if(parentNode != null && parentNode.getValue().compareTo(currentNode.getValue()) >= 0)
                    break;
            }else{
                if(parentNode != null && parentNode.getValue().compareTo(currentNode.getValue()) <= 0)
                    break;
            }

            T parentOldValue = parentNode.getValue();
            parentNode.setValue(value);
            currentNode.setValue(parentOldValue);

            currentIndex = parentIndex;
            currentNode = parentNode;
        }
    }

    public T remove(int position){
        if(position >= list.getSize())
            return null;

        T removedNode = list.get(position);


        if(list.getSize() == 1){
            list.remove(0);
            return removedNode;
        }

        ListNode<T> lastNode = list.getNode(list.getSize() - 1);
        list.getNode(position).setValue(lastNode.getValue());
        list.remove(list.getSize() - 1);

        int current = position;
        do{
            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int swap = current;

            T currentValue = list.get(current);
            T leftValue = (left < list.getSize()) ? list.get(left) : null;
            T rightValue = (right < list.getSize()) ? list.get(right) : null;

            if(useMaxHeap){
                if(leftValue != null && rightValue != null){
                    if (leftValue.compareTo(rightValue) > 0 && leftValue.compareTo(currentValue) > 0)
                        swap = left;
                    else if (rightValue.compareTo(currentValue) > 0)
                        swap = right;
                }

                else if (leftValue != null && leftValue.compareTo(currentValue) > 0)
                    swap = left;

                else if (rightValue != null && rightValue.compareTo(currentValue) > 0)
                    swap = right;
            }else{
                if(leftValue != null && rightValue != null){
                    if (leftValue.compareTo(rightValue) < 0 && leftValue.compareTo(currentValue) < 0)
                        swap = left;
                    else if (rightValue.compareTo(currentValue) < 0)
                        swap = right;
                }

                else if (leftValue != null && leftValue.compareTo(currentValue) < 0)
                    swap = left;

                else if (rightValue != null && rightValue.compareTo(currentValue) < 0)
                    swap = right;
            }

            if(current == swap)
                break;

            swap(list.getNode(current), list.getNode(swap));
            current = swap;
        }while(true);

        return removedNode;
    }

    private void swap(ListNode<T> node1, ListNode<T> node2){
        T aux = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(aux);
    }
}
