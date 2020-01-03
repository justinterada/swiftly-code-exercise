package org.jcompany.grocery.parsers;

import org.jcompany.grocery.model.ProductRecordLine;

import java.math.BigDecimal;

public class ProductRecordLineParser {
    public ProductRecordLine parse(String input) {
        int productId = Integer.parseInt(input.substring(0, 8));
        String description = input.substring(9, 68).trim();
        BigDecimal regularSingularPrice = parsePrice(input.substring(69, 77));
        BigDecimal promotionalSingularPrice = parsePrice(input.substring(78, 86));
        BigDecimal regularSplitPrice = parsePrice(input.substring(87, 95));
        BigDecimal promotionalSplitPrice = parsePrice(input.substring(96, 104));

        int regularForX = Integer.parseInt(input.substring(105, 113));
        int promotionalForX = Integer.parseInt(input.substring(114, 122));
        String productSize = input.substring(133, 142).trim();
        boolean[] flags = parseFlags(input.substring(123, 132));

        return ProductRecordLine.getBuilder()
                .withId(productId)
                .withDescription(description)
                .withPrice(regularSingularPrice)
                .withSplitPrice(regularSplitPrice)
                .withPromotionalPrice(promotionalSingularPrice)
                .withPromotionalSplitPrice(promotionalSplitPrice)
                .withRegularFor(regularForX)
                .withPromotionalFor(promotionalForX)
                .withSize(productSize)
                .withFlags(flags)
                .build();
    }

    private boolean[] parseFlags(String flagsString) {
        boolean[] flags = new boolean[flagsString.length()];
        for (int i = 0; i < flagsString.length(); i++) {
            if (Character.toUpperCase(flagsString.charAt(i)) == 'Y') {
                flags[i] = true;
            }
        }

        return flags;
    }

    private static BigDecimal parsePrice(String price) {
        int numberValue = Integer.parseInt(price);
        return BigDecimal.valueOf(numberValue, 2);
    }
}
