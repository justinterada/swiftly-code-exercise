package org.jcompany.grocery;

import org.jcompany.grocery.model.Price;
import org.jcompany.grocery.model.ProductRecord;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class ProductRecordLineParser {


    public ProductRecord parse(String input) {
        int productId = Integer.parseInt(input.substring(0, 8));
        String description = input.substring(9, 68).trim();
        BigDecimal regularSingularPrice = parsePrice(input.substring(69, 77));
        BigDecimal promotionalSingularPrice = parsePrice(input.substring(78, 86));
        BigDecimal regularSplitPrice = parsePrice(input.substring(87, 95));
        BigDecimal promotionalSplitPrice = parsePrice(input.substring(96, 104));

        int regularForX = Integer.parseInt(input.substring(105, 113));
        int promotionalForX = Integer.parseInt(input.substring(114, 122));
        String flags = input.substring(123, 132);
        String productSize = input.substring(133, 142).trim();

        return new ProductRecord.Builder()
                .withId(productId)
                .withDescription(description)
                .withPrice(new Price.Builder().withAmount(regularSingularPrice).withCurrency(Currency.getInstance(Locale.US)).build())
                .withSplitPrice(new Price.Builder().withAmount(regularSplitPrice).withCurrency(Currency.getInstance(Locale.US)).build())
                .withPromotionalPrice(new Price.Builder().withAmount(promotionalSingularPrice).withCurrency(Currency.getInstance(Locale.US)).build())
                .withPromotionalSplitPrice(new Price.Builder().withAmount(promotionalSplitPrice).withCurrency(Currency.getInstance(Locale.US)).build())
                .withRegularFor(regularForX)
                .withPromotionalFor(promotionalForX)
                .withSize(productSize)
                .build();
    }

    private static BigDecimal parsePrice(String price) {
        int numberValue = Integer.parseInt(price);
        return BigDecimal.valueOf(numberValue, 2);
    }
}
