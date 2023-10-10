public class Node<T extends Comparable<T>> implements Comparable <T> {
    T item;
    Integer numberOfNodes;
    Node<T> right;
    Node<T> left;
    public Node(T item, Integer numberOfNodes) {
        this.item = item;
        this.numberOfNodes = numberOfNodes;
        this.left = this.right = null;
    }
    @Override
    public int compareTo(T item) {
        return this.item.compareTo(item);
    }
}
