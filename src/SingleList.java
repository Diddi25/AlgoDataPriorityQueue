public class SingleList<T extends Comparable<T>> {
    Cell<T> firstInFirstImplementation;
    Cell<T> firstInSecondImplementation;

    public void addInConstantTime(T item) {
        if (this.firstInFirstImplementation == null) {
            firstInFirstImplementation = new Cell<>(item, null);
        } else {
            // går inte utan att springa igenom + sortering, dessutom måste ha lastpekare
        }
    }
    public Cell<T> removeNTime() {
        Cell<T> temporary = this.firstInFirstImplementation;
        while(temporary != null) {
            if (temporary.nextCell.nextCell != null) {
                Cell<T> saveBeforeReturn = temporary.nextCell;
                temporary.nextCell = null;
                return saveBeforeReturn;
            }
            temporary = temporary.nextCell;
        }
        return null;
    }
    
    public void addNTime(T item) {
        if (this.firstInSecondImplementation == null) {
            this.firstInSecondImplementation = new Cell<>(item, null);
        } else {
            Cell<T> temporary = this.firstInSecondImplementation;
            while (temporary.nextCell != null) {
                temporary = temporary.nextCell;
            }
            temporary.nextCell = new Cell<>(item,null); //fortfarande inte sorterad
        }
    }
    public Cell<T> removeInConstantTime() {
        Cell<T> saveBeforeReturn = this.firstInSecondImplementation;
        this.firstInSecondImplementation.nextCell = this.firstInSecondImplementation;
        return saveBeforeReturn;
    }

}
