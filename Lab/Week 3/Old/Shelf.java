public class Shelf {

    public int capacity = 0;
    public int books = 0;

    public void showDetails() {
        System.out.println("Shelf capacity: " + this.capacity);
        System.out.println("Number of books: " + this.books);
    }

    public void addBooks(int numberOfBooks) {
        if (this.capacity == 0) {
            System.out.println("Zero capacity. Cannot add books.");
        } else if (this.books + numberOfBooks > this.capacity) {
            System.out.println("Exceeds capacity");
        } else {
            this.books += numberOfBooks;
            System.out.println(numberOfBooks + " books added to shelf");
        }
    }

}
