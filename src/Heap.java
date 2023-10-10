public class Heap<T extends Comparable<T>> {
    Node<T> root;
    public void add(T item) {
        if (this.root == null) {
            this.root = new Node<>(item, 0);
        } else {
            Node<T> traverseNode = this.root;
            if (traverseNode.compareTo(item) < 0) {

            }
        }
    }
    public void remove() {

    }

}
