#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "phonebook.h"

void home() 
{
    system("clear");

    printf("PhoneBook.\n");
    printf("Please select an option:\n");
    printf("\t[1] Add new contact.\n");
    printf("\t[2] Show contacts.\n");
    printf("\t[3] Exit PhoneBook.\n");

    char option = getchar();

    switch (option)
    {
        case '1':
            add_contact();
            break;
        
        case '2':
            show_contacts();
            break;
        
        case '3':
            system("clear");
            printf("Thank you for using Phonebook!\n");
            exit(0);
            break;
        
        default:
            printf("OptionError: Did not recognize option.\n"
                    "Please enter a value between 1-3 only.");
            system("clear");
            home();
    }
}

void add_contact()
{    
    struct contact contact;
    FILE *store;
    store = fopen("phonebook_store.txt", "ab+");

    if (!store)
    {
        perror("FileError: Could not open file.");
    }

    printf("Enter the following details: ");
    take_input(contact.name);

    printf("Name: ");
    take_input(contact.name);

    printf("Address: ");
    take_input(contact.address);

    printf("Phone number: ");
    take_input((char *) contact.phone_number);

    printf("Email address: ");
    take_input(contact.email_address);

    fflush(stdin);
    fwrite(&contact, sizeof(struct contact), 1, store);
    printf("Contact saved.\n");

    fclose(store);
    
    printf("Enter any key to continue\n");
    getchar();
    home();
}

void show_contacts()
{
    FILE *store;
    store = fopen("phonebook_store.txt", "rb");

    if (!store)
    {
        perror("FileError: Could not open file.");
    }

    struct contact contact;

    while (fread(&contact, sizeof(contact), 1, store))
    {
        printf("\nContact:"
                "\n\tName: %s"
                "\n\tAddress: %s"
                "\n\tPhone number: %s"
                "\n\tEmail address: %s",
                contact.name,
                contact.address,
                contact.phone_number,
                contact.email_address);
    }

    fclose(store);

    printf("Enter any key to continue\n");
    getchar();
    getchar();
    home();
}


void take_input(char *input_name)
{
    int i = 0;
    char in;
    char ch;
    
    do {
        in = getchar();

        if (in != 8 && in != 13)
        {
            *(input_name + i) = in;
            putchar(in);
            i++;
        }

        if (in == 8)
        {
            if (i > 0)
            {
                i--;
            }
            
            system("clear");

            for (int j = 0; j < i; j++)
            {
                ch = *(input_name + j);
                putchar(ch);
            }
        }
    } while (in != 10);

    *(input_name + i) = '\0';
}

int main()
{
    home();
    return 0;
}
