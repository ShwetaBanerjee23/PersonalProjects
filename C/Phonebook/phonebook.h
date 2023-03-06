#ifndef PHONEBOOK
#define PHONEBOOK

struct contact {
    char name[128];
    char address[256];
    char phone_number[128];
    char email_address[256];
};

void home();
void add_contact();
void show_contacts();

void take_input(char *input_name);

#endif /* PHONEBOOK */
