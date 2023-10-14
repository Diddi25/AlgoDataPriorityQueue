public class ArrayHeap<T extends Comparable <T>> {
    Node<T>[] heap = new Node[40];
    int freeSlotPointer = 0;
    boolean leftOrRightDecision = true;

    public void add(T item) {
        heap[freeSlotPointer] = new Node<>(item, freeSlotPointer);
        bubble(freeSlotPointer);
        freeSlotPointer++;
    }
    private void bubble(int currentPosition) {
        int currentIndex = currentPosition;
        int parentIndex = (currentPosition - 1) / 2;
        while(heap[currentIndex].item.compareTo(heap[parentIndex].item ) < 0) {
            Node<T> temp = heap[currentIndex];
            heap[currentIndex] = heap[parentIndex];
            heap[parentIndex] = temp;
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }
    public Node<T> remove() {
        if (freeSlotPointer == 0) {
            return null;
        }
        Node<T> spared = heap[0];
        freeSlotPointer-=1;
        sink();
        return spared;
    }
    private void sink() {
        int index = 0;
        int leftChildIndex, rightChildIndex;
        while (index < heap.length) {
            leftChildIndex = 2*index + 1;
            rightChildIndex = 2*index + 2;
            int smallestChildIndex = index;
            if (leftChildIndex < heap.length && heap[leftChildIndex].item.compareTo(heap[rightChildIndex].item) < 0) {
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.length && heap[rightChildIndex].item.compareTo(heap[leftChildIndex].item) < 0) {
                smallestChildIndex = rightChildIndex;
            }
            if (smallestChildIndex != index) {
                swap(index, smallestChildIndex);
                index = smallestChildIndex;
            } else {
                break;
            }
        }
    }
    private void swap(int current, int smallestIndex) {
        Node<T> temporary = heap[current];
        heap[current] = heap[smallestIndex];
        heap[smallestIndex] = temporary;
    }
    private boolean isEmpty() {
        return freeSlotPointer == 0;
    }

}
