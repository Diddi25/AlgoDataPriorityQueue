public class ArrayHeap<T extends Comparable <T>> {
    Node<T>[] heap = new Node[40];
    int freeSlotPointer = 0;
    boolean leftOrRightDecision = true;

    public void add(T item) {
        if (isEmpty()) {
            heap[freeSlotPointer] = new Node<>(item, 0);
        }
        if (leftOrRightDecision) {

        } else {

        }
    }
    public Node<T> remove() {
        return null;
    }

    private void changeDirectionDecision() {
        leftOrRightDecision = !leftOrRightDecision;
    }

    private boolean isEmpty() {
        return freeSlotPointer == 0;
    }

}
