#ifndef CURRENCY_CONVERTER
#define CURRENCY_CONVERTER

/* Conversion rates */
#define USD_TO_GBP 0.83
#define USD_TO_INR 82.77
#define USD_TO_EUR 0.93
#define GBP_TO_INR 99.68
#define GBP_TO_EUR 1.12
#define INR_TO_EUR 0.011

/* Dollars */
float
convert_dollars_to_pounds (const float);
float
convert_dollars_to_rupees (const float);
float
convert_dollars_to_euros (const float);

/* Pounds */
float
convert_pounds_to_dollars (const float);
float
convert_pounds_to_rupees (const float);
float
convert_pounds_to_euros (const float);

/* Rupees */
float
convert_rupees_to_dollars (const float);
float
convert_rupees_to_pounds (const float);
float
convert_rupees_to_euros (const float);

/* Euros */
float
convert_euros_to_dollars (const float);
float
convert_euros_to_pounds (const float);
float
convert_euros_to_rupees (const float);

/* Helper methods */
float
convert_initial_to_final(const int, 
                         const int,
                         const float);

#endif /* CURRENCY_CONVERTER */
