public class Reader {

    public String name;
    public int capacity;
    public String[] books;
    public int index;

    public Reader() {
        this.name = "New user";
        this.capacity = 0;
        this.books = new String[0];
        this.index = 0;
    }

    public String createReader(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.books = new String[capacity];
        this.index = 0;
        return "A new reader is created!";
    }

    public void readerInfo() {
        System.out.println("Name: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Books:");
        if (index == 0) {
            System.out.println("No books added yet");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println("Book " + (i + 1) + ": " + books[i]);
            }
        }
    }

    public void addBook(String bookName) {
        if (index < capacity) {
            books[index] = bookName;
            index++;
        } else {
            System.out.println("No more capacity");
        }
    }

}
