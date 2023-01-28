public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String name, 
                    String phoneNumber, 
                    String email, 
                    String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    /* Return the name of this contact. */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /* Display name, name cannot be blank. */
        sb.append(name);
        sb.append('\n');
        
        /* Display phone number only if it is not blank. */
        if (!phoneNumber.equals("")) {
            sb.append('\t');
            sb.append(phoneNumber);
            sb.append('\n');
        }

        /* Display email address only if it is not blank. */
        if (!email.equals("")) {
            sb.append('\t');
            sb.append(email);
            sb.append('\n');
        }

        /* Display address only if it is not blank. */
        if (!address.equals("")) {
            sb.append('\t');
            sb.append(address);
        }
        
        /* Return contact's information in displayable format. */
        return sb.toString();
    }
}
