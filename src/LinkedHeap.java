public class LinkedHeap<T extends Comparable<T>> {
    Node<T> root;
    public void add(T item) {
        if (this.root == null) {
            this.root = new Node<>(item, 0);
        } else {
            this.root.addInNodeClass(item);
        }
    }
    public Node<T> remove() {
        if (this.root == null) {
            return null;
        } else {
            Node<T> saveBeforeReturning = this.root;
            this.root = this.root.returnNewRootAndRestructureHeap();
            return saveBeforeReturning;
        }
    }

    public void push(T numberOfPushes) {
        if(this.root == null) {
            return;
        } else {
            this.root.item = numberOfPushes;
            this.root.pushDown(numberOfPushes);
        }
    }

}
