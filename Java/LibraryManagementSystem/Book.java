import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String bookId;
    private int locationFloor;
    private char locationRow;
    private List<Person> previousBorrowers;
    private boolean isBorrowed;

    public Book(String title,
                String bookId, 
                int locationFloor, 
                char locationRow) {
        this.title = title;
        this.bookId = bookId;
        this.locationFloor = locationFloor;
        this.locationRow = locationRow;
        this.previousBorrowers = new ArrayList<>();
        this.isBorrowed = false;
    }

    /* Get the book's title. */
    public String getTitle() {
        return title;
    }

    /* Check if the book is available. */
    public boolean isAvailable() {
        return !isBorrowed;
    }

    /* Lend the book to PERSON. */
    public void lendBook(Person person) {
        previousBorrowers.add(person);
        isBorrowed = true;
        // person.getBorrowedBooks().add(this);
    }

    /* Book returned, reset status and update borrower's record. */
    public void returnBook() {
        isBorrowed = false;
    }

    /* Return a string representation of the book. */
    @Override
    public String toString() {
        String borrowers = 
            previousBorrowers.isEmpty() 
                ? "No previous borrowers yet." 
                : previousBorrowers.toString();
        String currentlyBorrowed = 
            isBorrowed 
                ? "On loan" 
                : "Available";

        return title 
                + " ["
                + bookId
                + "] - "
                + currentlyBorrowed
                + "\n\t"
                + String.valueOf(locationFloor)
                + String.valueOf(locationRow)
                + ": "
                + borrowers;
    }
}
