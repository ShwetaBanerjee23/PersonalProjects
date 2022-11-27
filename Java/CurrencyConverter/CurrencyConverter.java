public record CurrencyConverter(CurrencyTypes from, double givenValue, CurrencyTypes to) {

    public double convert() {
        /**************************************************************
        * This function converts a given value in a given currency to *
        * a new currency - requested by the user.                     *
        **************************************************************/
        int fromPosition = CurrencyTypes.getPosition(from);
        int toPosition = CurrencyTypes.getPosition(to);

        CurrencyTypes[] currencyTypes = CurrencyTypes.getTypes();
        double[] conversionRates = currencyTypes[fromPosition].getConversionRates();

        return givenValue * conversionRates[toPosition];
    }
}
