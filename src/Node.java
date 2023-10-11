public class Node<T extends Comparable<T>> implements Comparable <T> {
    T item;
    Integer numberOfNodes;
    Node<T> right;
    Node<T> left;
    boolean leftOrRightDecision = true;
    public Node(T item, Integer numberOfNodes) {
        this.item = item;
        this.numberOfNodes = numberOfNodes;
        this.left = this.right = null;
    }
    public void addInNodeClass(T newItem) {
        if (this.item.equals(item)) {
            return;
        }
        if (leftOrRightDecision) {
            if (this.left == null) {
                this.left = new Node<>(newItem, this.numberOfNodes++);
                changeDirectionDecision();
            } else if (this.left.item.compareTo(item) > 0) {
                T newItemToAdd = swapItems(newItem);
                this.left.addInNodeClass(newItemToAdd);
            } else {
                this.left.addInNodeClass(newItem);
            }
        } else {
            if (this.right == null) {
                this.right = new Node<>(newItem, this.numberOfNodes++);
                changeDirectionDecision();
            } else if (this.right.item.compareTo(item) > 0) {
                T newItemToAdd = swapItems(newItem);
                this.right.addInNodeClass(newItemToAdd);
            } else {
                this.right.addInNodeClass(newItem);
            }
        }
    }
    private T swapItems(T newItem) {
        T savedItem = this.item;
        this.item = newItem;
        return savedItem;
    }
    private void changeDirectionDecision() {
        leftOrRightDecision = !leftOrRightDecision;
    }
    @Override
    public int compareTo(T item) {
        return this.item.compareTo(item);
    }
}
