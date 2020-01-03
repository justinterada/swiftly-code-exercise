package org.jcompany.grocery.parsers;

import org.jcompany.grocery.model.ProductRecordLine;

import java.math.BigDecimal;

public class ProductRecordLineParser {
    // This could also be loaded from a configuration file but for now it's here to
    // make changes easier to make
    private enum Column {
        ID(0, 7),
        DESCRIPTION(9, 67),
        REGULAR_PRICE(69, 76),
        PROMOTIONAL_PRICE(78, 85),
        REGULAR_SPLIT_PRICE(87, 94),
        PROMOTIONAL_SPLIT_PRICE(96, 103),
        REGULAR_FOR_X(105, 112),
        PROMOTIONAL_FOR_X(114, 121),
        PRODUCT_SIZE(133, 141),
        FLAGS(123, 131);

        private final int startColumnInclusive;
        private final int endColumnInclusive;

        Column(final int startColumnInclusive, final int endColumnInclusive) {
            this.startColumnInclusive = startColumnInclusive;
            this.endColumnInclusive = endColumnInclusive;
        }

        public String getValueFromLine(String input) {
            return input.substring(startColumnInclusive, endColumnInclusive + 1);
        }
    }

    public ProductRecordLine parse(String input) {
        int productId = Integer.parseInt(Column.ID.getValueFromLine(input));
        String description = Column.DESCRIPTION.getValueFromLine(input).trim();
        BigDecimal regularSingularPrice = parsePrice(Column.REGULAR_PRICE.getValueFromLine(input));
        BigDecimal promotionalSingularPrice = parsePrice(Column.PROMOTIONAL_PRICE.getValueFromLine(input));
        BigDecimal regularSplitPrice = parsePrice(Column.REGULAR_SPLIT_PRICE.getValueFromLine(input));
        BigDecimal promotionalSplitPrice = parsePrice(Column.PROMOTIONAL_SPLIT_PRICE.getValueFromLine(input));

        int regularForX = Integer.parseInt(Column.REGULAR_FOR_X.getValueFromLine(input));
        int promotionalForX = Integer.parseInt(Column.PROMOTIONAL_FOR_X.getValueFromLine(input));
        String productSize = Column.PRODUCT_SIZE.getValueFromLine(input).trim();
        boolean[] flags = parseFlags(Column.FLAGS.getValueFromLine(input));

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
