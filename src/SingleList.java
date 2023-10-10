public class SingleList<T extends Comparable<T>> {
    Cell<T> firstInFirstImplementation;
    Cell<T> firstInSecondImplementation;
    Cell<T> lastInSecondImplementation;

    public void addInConstantTime(T item) {
        if (this.firstInFirstImplementation == null) {
            firstInFirstImplementation = new Cell<>(item, null);
        } else {
            // går inte utan att springa igenom + sortering
        }
    }
    
    public void removeNTime(T item) {
        Cell<T> temporary = this.firstInFirstImplementation;
        while(temporary != null) {
            if (temporary.nextCell.item.equals(item)) {
                temporary.nextCell = temporary.nextCell.nextCell;
                break;
            }
            temporary = temporary.nextCell;
        }
    }
    
    public void addNTime(T item) {
        if (this.firstInSecondImplementation != null) {
            this.firstInSecondImplementation = new Cell<>(item, null);
        } else {
            Cell<T> temporary = this.lastInSecondImplementation;
            while (temporary.nextCell != null) {
                temporary = temporary.nextCell;
            }
            temporary.nextCell = new Cell<>(item, null);
        }
    }

    public void removeInConstantTime(T item) {

    }

}
