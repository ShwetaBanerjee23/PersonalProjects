#include "CurrencyConverter.h"
#include <stdio.h>

/**********************************************/
/*            CONVERT FROM DOLLARS            */
/**********************************************/
float
convert_dollars_to_pounds (const float amount)
{
    return amount * USD_TO_GBP;
}

float
convert_dollars_to_rupees (const float amount)
{
    return amount * USD_TO_INR;
}

float
convert_dollars_to_euros (const float amount)
{
    return amount * USD_TO_EUR;
}

/**********************************************/
/*            CONVERT FROM POUNDS             */
/**********************************************/
float
convert_pounds_to_dollars (const float amount)
{
    return amount / USD_TO_GBP;
}

float
convert_pounds_to_rupees (const float amount)
{
    return amount * GBP_TO_INR;
}

float
convert_pounds_to_euros (const float amount)
{
    return amount * GBP_TO_EUR;
}

/**********************************************/
/*            CONVERT FROM RUPEES             */
/**********************************************/
float
convert_rupees_to_dollars (const float amount)
{
    return amount / USD_TO_INR;
}

float
convert_rupees_to_pounds (const float amount)
{
    return amount / GBP_TO_INR;
}

float
convert_rupees_to_euros (const float amount)
{
    return amount * INR_TO_EUR;
}

/**********************************************/
/*            CONVERT FROM EUROS              */
/**********************************************/
float
convert_euros_to_dollars (const float amount)
{
    return amount / USD_TO_EUR;
}

float
convert_euros_to_pounds (const float amount)
{
    return amount / GBP_TO_EUR;
}

float
convert_euros_to_rupees (const float amount)
{
    return amount / INR_TO_EUR;
}

/**********************************************/
/*                HELPER METHODS              */
/**********************************************/


/* Converts an amount from a given initial currency */
/* to a given final currency and returns the result.*/
float
convert_initial_to_final(const int initial, 
                         const int final,
                         const float amount)
{
    switch (initial)
    {
        /* Dollars */
        case 1:

            /* Identify currency to convert to and perform conversion. */
            switch (final)
            {
                case 1:
                    return amount;
                
                case 2:
                    return convert_dollars_to_pounds(amount);
                
                case 3:
                    return convert_dollars_to_rupees(amount);
                
                case 4:
                    return convert_dollars_to_euros(amount);
                
                /* Unrecognized input. */
                default:
                    perror("InvalidInputError: Did not recognize "
                            "currency to convert to.");
            }

            break;
        
        /* Pounds */
        case 2:

            /* Identify currency to convert to and perform conversion. */
            switch (final)
            {

                case 1:
                    return convert_pounds_to_dollars(amount);
                
                case 2:
                    return amount;
                
                case 3:
                    return convert_pounds_to_rupees(amount);
                
                case 4:
                    return convert_pounds_to_euros(amount);
                
                /* Unrecognized input. */
                default:
                    perror("InvalidInputError: Did not recognize "
                            "currency to convert to.");
            }
        
            break;
        
        /* Rupees */
        case 3:
        
            /* Identify currency to convert to and perform conversion. */
            switch (final)
            {
                
                case 1:
                    return convert_rupees_to_dollars(amount);
                
                case 2:
                    return convert_rupees_to_pounds(amount);
                
                case 3:
                    return amount;
                
                case 4:
                    return convert_rupees_to_euros(amount);
                
                /* Unrecognized input. */
                default:
                    perror("InvalidInputError: Did not recognize "
                            "currency to convert to.");
            }

            break;
        
        /* Euros */
        case 4:

            /* Identify currency to convert to and perform conversion. */
            switch (final)
            {
                
                case 1:
                    return convert_euros_to_dollars(amount);
                
                case 2:
                    return convert_euros_to_pounds(amount);
                
                case 3:
                    return convert_euros_to_rupees(amount);
                
                case 4:
                    return amount;
                
                /* Unrecognized input. */
                default:
                    perror("InvalidInputError: Did not recognize "
                            "currency to convert to.");
            }

            break;
        
        /* Unrecognized input. */
        default:
            perror("InvalidInputError: Did not recognize "
                    "currency to convert from.");
    }

    return 0;
}

/* Get user input and convert as needed. */
int
main (void) {
    int intial_currency;
    int final_currency;
    float amount;

    printf("Welcome to currency converter!\n");

    /* Get currency to convert from. */
    printf("Which currency do you wish to convert from?\n"
            "\t1 - USD\n"
            "\t2 - GBP\n"
            "\t3 - INR\n"
            "\t4 - EUR\n");
    scanf("%d", &intial_currency);

    /* Get amount to convert. */
    printf("Enter the amount you want to convert: ");
    scanf("%f", &amount);

    /* Get currency to convert to. */
    printf("Which currency would you like to convert to?\n"
           "\t1 - USD\n"
            "\t2 - GBP\n"
            "\t3 - INR\n"
            "\t4 - EUR\n");
    scanf("%d", &final_currency);

    /* Perform conversion based on previous inputs. */
    float converted = convert_initial_to_final(intial_currency,
                                               final_currency,
                                               amount);

    /* Print value onyl if conversion was successful. */
    if (converted != 0)
        printf("Your converted value is: %.2f\n", converted);
}
