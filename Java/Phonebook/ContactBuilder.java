public class ContactBuilder {
    private String name = "";
    private String phoneNumber = "";
    private String email = "";
    private String address = "";

    private ContactBuilder() {}

    public static ContactBuilder aContact() {
        return new ContactBuilder();
    }

    /* Create a contact. */
    public Contact build() {
        return new Contact(name, 
                            phoneNumber, 
                            email, 
                            address);
    }

    /* Create contact with name NAME. */
    public ContactBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /* Create contact with phone number PHONE NUMBER. */
    public ContactBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /* Create contact with email EMAIL. */
    public ContactBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    /* Create contact with address ADDRESS. */
    public ContactBuilder withAddress(String address) {
        this.address = address;
        return this;
    }
}
