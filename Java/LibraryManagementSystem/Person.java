import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String surname;
    private String id;
    private String phoneNumber;
    private String emailId;

    public Person(String firstName, 
                    String surname, 
                    String id, 
                    String phoneNumber, 
                    String emailId) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    /* Return the person's first name. */
    public String getFirstName() {
        return firstName;
    }
    
    /* Return the person's surname. */
    public String getSurname() {
        return surname;
    }

    /* Return the person's id. */
    public String getId() {
        return id;
    }

    /* Return a string representation of the person. */
    @Override
    public String toString() {
        return firstName 
                + " " 
                + surname 
                + " [" 
                + id 
                + "]: " 
                + "\n\tPhone number: " 
                + phoneNumber 
                + "\n\tEmail ID: " 
                + emailId;
    }
}
