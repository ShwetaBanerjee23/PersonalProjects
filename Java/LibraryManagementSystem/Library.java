import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String id;
    private List<Book> currentBooks;
    private List<Person> eligiblePeople;

    public Library(String name, 
                    String id) {
        this.name = name;
        this.id = id;
        this.currentBooks = new ArrayList<>();
        this.eligiblePeople = new ArrayList<>();
    }

    /* Find all the number of books available in the library. */
    public int getAvailableBooks() {
        int available = 0;

        for (Book book : currentBooks) {
            if (book.isAvailable())
                available++;
        }

        return available;
    }

    /* Find book in list of current books. */
    public Book findBook(String title) {
        for (Book b : currentBooks) {
            if (b.getTitle() == title) {
                return b;
            }
        }

        return null;
    }

    /* Add a book to the list of current books. */
    public void addBook(Book book) {
        currentBooks.add(book);
    }

    /* Add a person to the list of eligible people. */
    public void addPerson(Person person) {
        eligiblePeople.add(person);
    }

    /* Lend a book to an eligible person. */
    public void borrowBook(String title, 
                            String personFirstName, 
                            String personSurname,
                            String personId) {
        /* Identify the book. */
        Book book = findBook(title);

        /* Book not found. */
        if (book == null) {
            System.out.println("Sorry, this book is not " +
                                "currently owned by the library.");
            return;
        }

        /* Book lent to someone already. */
        if (!book.isAvailable()) {
            System.out.println("Sorry, this book is " + 
                                "currently on loan.");
            return;
        }

        /* Identify the person. */
        Person person = null;

        /* Search through list of eligible people. */
        for (Person p : eligiblePeople) {
            if (p.getFirstName().equalsIgnoreCase(personFirstName) 
                && p.getSurname().equalsIgnoreCase(personSurname) 
                && p.getId().equalsIgnoreCase(personId)) 
                    person = p;
        }

        /* Person not eligible. */
        if (person == null) {
            System.out.println("Sorry, you are not eligible " + 
                                "to borrow this book.");
            return;
        }

        /* Lend the book to the person. */
        book.lendBook(person);
    }

    /* Return the book. */
    public void returnBook(String title) {
        /* Identify the book. */
        Book book = findBook(title);

        /* Book does not belong to library. */
        if (book == null) {
            System.out.println("Sorry, the book was not found.");
            return;
        }

        /* Book is already present in library - was not lent. */
        if (book.isAvailable()) {
            System.out.println("Sorry, this book is already in the library.");
            return;
        }

        /* Return book. */
        book.returnBook();
    }

    /* Return a string representation of the library. */
    @Override
    public String toString() {
        return name 
                + " [" 
                + id 
                + "]" 
                + "\n\tThere are "
                + String.valueOf(getAvailableBooks())
                + " books currently available out of "
                + String.valueOf(currentBooks.size())
                + " books.";
    }
}
