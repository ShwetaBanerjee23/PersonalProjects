import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /**************************************************************
     * This function gets the required values: initial currency,  *
     * final currency, and value to convert. It then returns the  *
     * converted value.                                           *
     **************************************************************/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which currency would you like to convert from? " +
                "\n\tUS Dollars, " +
                "\n\tEuros, " +
                "\n\tPound Sterling, " +
                "\n\tJapanese Yuan, " +
                "\n\tChinese Yuan, " +
                "\n\tIndian Rupees ");
        String fromString = scanner.nextLine();
        // Get initial currency.
        CurrencyTypes from = CurrencyTypes.convertToCurrencyType(fromString);

        System.out.println("Which currency would you like to convert to? " +
                "\n\tUS Dollars, " +
                "\n\tEuros, " +
                "\n\tPound Sterling, " +
                "\n\tJapanese Yuan, " +
                "\n\tChinese Yuan, " +
                "\n\tIndian Rupees ");
        String toString = scanner.nextLine();
        // Get final currency.
        CurrencyTypes to = CurrencyTypes.convertToCurrencyType(toString);

        System.out.println("What is the value you would like to convert? ");
        // Get value to convert.
        double givenValue = Double.parseDouble(scanner.nextLine());

        CurrencyConverter currencyConverter = new CurrencyConverter(from, givenValue, to);
        double convertedValue = currencyConverter.convert();

        // Return the converted value.
        System.out.println("The converted value is " + convertedValue + ".");
    }
}
