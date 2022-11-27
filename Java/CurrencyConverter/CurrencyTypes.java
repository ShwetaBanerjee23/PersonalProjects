public enum CurrencyTypes {
    USD(new double[] {1.0, 0.96, 0.83, 139.12, 7.17, 81.67}),
    EUR(new double[] {1.04, 1.0, 0.86, 144.89, 7.47, 85.06}),
    GBP(new double[] {1.21, 1.16, 1.0, 168.22, 8.67, 98.75}),
    JPY(new double[] {0.0072, 0.0069, 0.0059, 1.0, 0.052, 0.59}),
    CNY(new double[] {0.14, 0.13, 0.12, 19.39, 1.0, 11.38}),
    INR(new double[] {0.012, 0.012, 0.010, 1.71, 0.088, 1.0});

    private final double[] conversionRates;

    CurrencyTypes(double[] conversionRates) {
        this.conversionRates = conversionRates;
    }

    public static int getPosition(CurrencyTypes currencyType) {
    /**************************************************************
     * This function gets the position of a currency type in the  *
     * enum.                                                      *
     **************************************************************/
        switch (currencyType) {
            case USD -> {return 0;}
            case EUR -> {return 1;}
            case GBP -> {return 2;}
            case JPY -> {return 3;}
            case CNY -> {return 4;}
            case INR -> {return 5;}
            // Should never reach here.
            default -> {return -1;}
        }
    }

    public static CurrencyTypes[] getTypes() {
    /**************************************************************
     * This function returns all the currency types in an array.  *
     **************************************************************/
        return new CurrencyTypes[] {CurrencyTypes.USD,
                CurrencyTypes.EUR,
                CurrencyTypes.GBP,
                CurrencyTypes.JPY,
                CurrencyTypes.CNY,
                CurrencyTypes.INR};
    }

    public double[] getConversionRates() {
    /**************************************************************
     * This function gets the conversion rates array for a given  *
     * currency type.                                             *
     **************************************************************/
        return this.conversionRates;
    }

    public static CurrencyTypes convertToCurrencyType(String currencyType) {
    /**************************************************************
     * This function returns the enum of the given string.        *
     **************************************************************/
        switch (currencyType.toLowerCase()) {
            case "us dollars" -> {return CurrencyTypes.USD;}
            case "euros" -> {return CurrencyTypes.EUR;}
            case "pound sterling" -> {return CurrencyTypes.GBP;}
            case "japanese yuan" -> {return CurrencyTypes.JPY;}
            case "chinese yuan" -> {return CurrencyTypes.CNY;}
            case "indian rupees" -> {return CurrencyTypes.INR;}
            default -> {return null;}
        }
    }
}
