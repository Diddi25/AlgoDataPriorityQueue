public class Cell<T extends Comparable<T>> {
    T item;
    Cell<T> nextCell;
    public Cell(T item, Cell<T> nextCell) {
        this.item = item;
        this.nextCell = nextCell;
    }


}
