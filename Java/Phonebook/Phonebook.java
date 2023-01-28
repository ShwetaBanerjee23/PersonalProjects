import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    private List<Contact> contacts;

    public Phonebook() {
        this.contacts = new ArrayList<>();
    }

    /* Display main screen. */
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        /* Show all options. */
        System.out.println("Welcome to Phonebook!");
        System.out.println("What would you like to do today? " + 
                            "Choose an option from 1 - 6.");
        System.out.println("\t[1] Create a new contact");
        System.out.println("\t[2] Delete an existing contact");
        System.out.println("\t[3] Display all contacts");
        System.out.println("\t[4] Search for an existing contact");
        System.out.println("\t[5] Modify information for an existing contact");
        System.out.println("\t[6] Exit the application");

        /* Store user option. */
        int option = Integer.parseInt(scanner.nextLine());

        /* Carry out operation based on option. */
        switch (option) {
            
            /* Create a contact. */
            case 1:
                createContact(false);
                break;
            
            /* Delete a contact. */
            case 2:
                System.out.println("Please enter the name of the " + 
                                    "contact you wish to delete: ");
                String deleteName = scanner.nextLine();
                
                deleteContact(deleteName);
                break;

            /* Display all contacts. */
            case 3:
                displayAllContacts();
                break;

            /* Find a contact. */
            case 4:
                System.out.println("Please enter the name of the " + 
                                    "contact you wish to find: ");
                String findName = scanner.nextLine();
                findContact(findName);

                /* Return to main menu after user presses a key. */
                System.out.println("Press any key to continue.");

                scanner.nextLine();
                
                showMenu();
            
            /* Modify a contact. */
            case 5:
                System.out.println("Please enter the name of the " + 
                                    "contact you wish to modify: ");
                String modifyName = scanner.nextLine();
                
                modifyContact(modifyName);
                break;

            /* Exit Phonebook. */
            case 6:
                System.out.println("Thank you for using Phonebook!");
                System.exit(0);

            /* Unknown option, ask user to choose from existing options. */
            default:
                System.out.println("OptionError: Option not recognized." + 
                                    " Please enter a value between 1 and 6.");
                showMenu();
        }
    }

    /* Create a new contact, MODIFICATION FLAG is used to 
        print the relevant output message. */
    private void createContact(boolean modificationFlag) {
        String name;
        String phoneNumber;
        String email;
        String address = "";
        
        Scanner scanner = new Scanner(System.in);

        /* Display instructions. */
        System.out.println("Enter contact information.\nJust " +
        "press enter to skip adding any information.");

        /* Store name. */
        System.out.println("First name: ");
        name = scanner.nextLine();

        /* Do not allow first name to be blank. */
        while (name.equals("")) {
            System.out.println("InputError: First name cannot be blank.");
            System.out.println("First name: ");
            name = scanner.nextLine();
        }
        System.out.println("Last name: ");
        name += " " + scanner.nextLine();

        /* Store phone number. */
        System.out.println("Phone number: ");
        phoneNumber = scanner.nextLine();

        /* Store email address. */
        System.out.println("Email address: ");
        email = scanner.nextLine();

        /* Store address. */
        System.out.println("First line of address: ");
        String firstLine = scanner.nextLine();
        if (firstLine != null) {
            address += ", " + firstLine;
        }
        System.out.println("Second line of address: ");
        String secondLine = scanner.nextLine();
        if (secondLine != null) {
            address += ", " + secondLine;
        }
        System.out.println("City: ");
        String city = scanner.nextLine();
        if (city != null) {
            address += ", " + city;
        }
        System.out.println("Country: ");
        String country = scanner.nextLine();
        if (country != null) {
            address += ", " + country;
        }
        System.out.println("Postcode: ");
        String postcode = scanner.nextLine();
        if (postcode != null) {
            address += ", " + postcode;
        }

        /* Create contact. */
        Contact contact = ContactBuilder
                            .aContact()
                            .withName(name)
                            .withPhoneNumber(phoneNumber)
                            .withEmail(email)
                            .withAddress(address)
                            .build();

        /* Store contact. */
        contacts.add(contact);

        /* Print appropriate message depending on modificationFlag. */
        if (modificationFlag) {
            System.out.println("Contact successfully modified.");
        } else {
            System.out.println("Contact successfully created.");
        }

        /* Return to main menu after user presses a key. */
        System.out.println("Press any key to continue.");

        scanner.nextLine();

        showMenu();

    }

    /* Delete a contact. */
    private void deleteContact(String name) {
        /* Find the contact to delete. */
        Contact contact = findContact(name);

        /* Contact not found. */
        if (contact == null) {
            System.out.println("DeleteError: Could not delete contact, " + 
                                "because contact does not exist.");
            return;
        }

        /* Remove the contact. */
        contacts.remove(contact);
        System.out.println("Contact successfully deleted.");

        /* Return to main menu after user presses a key. */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press any key to continue.");

        scanner.nextLine();
        
        showMenu();
    }

    /* Display all contacts. */
    private void displayAllContacts() {
        /* Print information of all contacts in contacts list. */
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }

        /* Let user know all contacts have been displayed. */
        System.out.println("Displayed all contacts.");

        /* Return to main menu after user presses a key. */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press any key to continue.");

        scanner.nextLine();
        
        showMenu();
    }

    /* Find a contact. */
    private Contact findContact(String name) {
        /* Initialize contact variable. */
        Contact res = null;

        /* Search for contact in contacts list. */
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println("Found contact successfully.");
                System.out.println(contact);
                res = contact;
                break;
            }
        }

        /* Contact not found. */
        if (res == null) {
            System.out.println("Contact not found.");
        }

        /* Return contact. */
        return res;
    }

    /* Modify contact information. */
    private void modifyContact(String name) {
        /* Find contact. */
        Contact contact = findContact(name);

        /* Contact not found. */
        if (contact == null) {
            System.out.println("Cannot modify contact " + 
                                "because contact not found.");
            return;
        }

        /* Remove contact. */
        contacts.remove(contact);

        /* Create new contact, with modification flag. */
        createContact(true);

        /* Return to main menu after user presses a key. */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press any key to continue.");

        scanner.nextLine();
        
        showMenu();
    }
}
