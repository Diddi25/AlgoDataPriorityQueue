public class Heap<T extends Comparable<T>> {
    Node<T> root;
    public void add(T item) {
        if (this.root == null) {
            this.root = new Node<>(item, 0);
        } else {
            this.root.addInNodeClass(item);
        }
    }
    public void remove() {
        if (this.root == null) {
            return;
        } else {
            this.root.addInNodeClass(item);
        }
    }

}
