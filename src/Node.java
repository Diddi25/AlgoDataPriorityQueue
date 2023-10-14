public class Node<T extends Comparable<T>> implements Comparable <T> {
    T item;
    Integer numberOfNodes;
    Node<T> right;
    Node<T> left;
    boolean leftOrRightDecision = true;
    boolean rootIsNotChanged = true;
    public Node(T item, Integer numberOfNodes) {
        this.item = item;
        this.numberOfNodes = numberOfNodes;
        this.left = this.right = null;
    }
    public void addInNodeClass(T newItem) {
        if (this.item.equals(newItem)) {
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
    public Node<T> returnNewRootAndRestructureHeap() {
        Node<T> saveBeforeReturningNewRoot = null;
        if (rootIsNotChanged) {
            if (leftOrRightDecision) {
                saveBeforeReturningNewRoot = this.left;
            } else {
                saveBeforeReturningNewRoot = this.right;
            }
            rootIsNotChanged = false;
        }
        if (leftOrRightDecision) {
            if (this.left.right == null) {
                this.left.right = this.right;
                changeDirectionDecision();
            } else {
                this.numberOfNodes--; //kommer alltid finnas en prioritets element
                this.left.returnNewRootAndRestructureHeap();
            }
        } else {
            if (this.right.left == null) {
                this.right.left = this.left;
                changeDirectionDecision();
            } else {
                this.numberOfNodes--;
                this.right.returnNewRootAndRestructureHeap();
            }
        }
        return saveBeforeReturningNewRoot;
    }
    public void pushDown(T newItem) {

    }
    private T swapItems(T newItem) {
        T savedItem = this.item;
        this.item = newItem;
        return savedItem;
    }
    private void changeDirectionDecision() {
        this.leftOrRightDecision = !leftOrRightDecision;
    }
    @Override
    public int compareTo(T item) {
        return this.item.compareTo(item);
    }
}
