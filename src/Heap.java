public class Heap<T extends Comparable<T>> {
    Node<T> root;
    public void add(T item) {
        if (this.root == null) {
            this.root = new Node<>(item, 0);
        } else {
            addInAnother(item);
        }
        Node<T> traverseNode = this.root;
        //om variabel = true => left bransch, sedan ska vi kolla om det har en equals, sedan
        //om variabel = false => right branch
    }
    public void addInAnother(T item) {

    }
    public void remove() {

    }

}
