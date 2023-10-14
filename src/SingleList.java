public class SingleList<T extends Comparable<T>> {
    Cell<T> firstInFirstImplementation;
    Cell<T> lastInFirstImplementation;
    Cell<T> firstInSecondImplementation;
    public void addInConstantTime(T item) {
        if (this.firstInFirstImplementation == null) {
            firstInFirstImplementation = new Cell<>(item, null);
            lastInFirstImplementation = firstInFirstImplementation;
        } else {
            lastInFirstImplementation.nextCell = new Cell<>(item, null);
            lastInFirstImplementation = lastInFirstImplementation.nextCell;
        }
    }
    public Cell<T> removeNTime() {
        Cell<T> temporary = this.firstInFirstImplementation;
        Cell<T> smallestItem = temporary;
        while(temporary != null) {
            if (temporary.item.compareTo(temporary.nextCell.item) < 0) {
                smallestItem = temporary;
            }
            temporary = temporary.nextCell;
        }
        return smallestItem;
    }
    
    public void addNTime(T item) {
        if (this.firstInSecondImplementation == null) {
            this.firstInSecondImplementation = new Cell<>(item, null);
        } else {
            Cell<T> temporary = this.firstInSecondImplementation;
            while (temporary.nextCell != null && (temporary.item.compareTo(item) < 0)) {
                temporary = temporary.nextCell;
            }
            Cell<T> sparedNode = temporary.nextCell;
            temporary.nextCell = new Cell<>(item, sparedNode);
        }
    }
    public Cell<T> removeInConstantTime() {
        Cell<T> saveBeforeReturn = this.firstInSecondImplementation;
        this.firstInSecondImplementation.nextCell = this.firstInSecondImplementation;
        return saveBeforeReturn;
    }

}
