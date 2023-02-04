public class Demo {
    public static void main(String[] args) {
        /* Create people. */
        Person p1 = new Person("Person", 
                            "One", 
                            "#001", 
                            "0123456789", 
                            "person1@person.com");
        Person p2 = new Person("Person", 
                            "Two", 
                            "#002", 
                            "1123456789", 
                            "person2@person.com");
        Person p3 = new Person("Person", 
                            "Three", 
                            "#003", 
                            "2123456789", 
                            "person3@person.com");

        /* Create books. */
        Book b1 = new Book("Book1", 
                        "#b01", 
                        1, 
                        'A');
        Book b2 = new Book("Book2", 
                        "#b02", 
                        2, 
                        'B');
        
        /* Create a library. */
        Library library = new Library("Library", 
                                    "#l001");

        /* Print people representation. */
        System.out.println("***PEOPLE***");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        /* Print books representation. */
        System.out.println("\n***BOOKS***");
        System.out.println(b1);
        System.out.println(b2);

        /* Print library representation. */
        System.out.println("\n***LIBRARY***");
        System.out.println(library);

        /* Add people to library. */
        library.addPerson(p1);
        library.addPerson(p2);

        /* Add books to library. */
        System.out.println("\n***ADDED 1 BOOK TO LIBRARY***");
        library.addBook(b1);
        System.out.println(library);

        System.out.println("\n***ADDED 1 BOOK TO LIBRARY***");
        library.addBook(b2);
        System.out.println(library);

        /* Test valid book borrowed by eligible person. */
        System.out.println("\n***BORROW VALID BOOK/ELIGIBLE PERSON***");
        library.borrowBook(b1.getTitle(), 
                           p1.getFirstName(), 
                           p1.getSurname(), 
                           p1.getId());
        System.out.println("\t" + p1);
        System.out.println("\t" + b1);
        System.out.println("\t" + library);

        /* Test valid book returned by eligible person. */
        System.out.println("\n***RETURN VALID BOOK/ELIGIBLE PERSON***");
        library.returnBook(b1.getTitle());
        System.out.println("\t" + p1);
        System.out.println("\t" + b1);
        System.out.println("\t" + library);

        /* Test invalid book borrowed by eligible person. */
        System.out.println("\n***BORROW INVALID BOOK/ELIGIBLE PERSON***");
        library.borrowBook("Book10", 
                           p2.getFirstName(), 
                           p2.getSurname(), 
                           p2.getId());
        System.out.println("\t" + p2);
        System.out.println("\t" + library);

        /* Test invalid book returned by eligible person. */
        System.out.println("\n***RETURN INVALID BOOK/ELIGIBLE PERSON***");
        library.returnBook("Book10");
        System.out.println("\t" + library);

        /* Test valid book borrowed by ineligible person. */
        System.out.println("\n***BORROW VALID BOOK/INELIGIBLE PERSON***");
        library.borrowBook(b2.getTitle(), 
                           p3.getFirstName(), 
                           p3.getSurname(), 
                           p3.getId());
        System.out.println("\t" + p3);
        System.out.println("\t" + b2);
        System.out.println("\t" + library);

        /* Test non-borrowed valid book returned. */
        System.out.println("\n***RETURN NON-BORROWED VALID BOOK***");
        library.returnBook(b2.getTitle());
        System.out.println("\t" + library);
    }
}
