package org.jcompany.grocery;

import org.jcompany.grocery.model.ProductRecord;

public class ProductRecordLineParser {


    public ProductRecord parse(String input) {
        String productId = input.substring(0, 8);
        String description = input.substring(9, 68);
        String regularSingularPrice = input.substring(69, 77);
        String promotionalSingularPrice = input.substring(78, 86);
        String regularSplitPrice = input.substring(87, 95);
        String promotionalSplitPrice = input.substring(96, 104);
        String regularForX = input.substring(105, 113);
        String promotionalForX = input.substring(114, 122);
        String flags = input.substring(123, 132);
        String productSize = input.substring(133, 142);

        return new ProductRecord.Builder().build();
    }
}
