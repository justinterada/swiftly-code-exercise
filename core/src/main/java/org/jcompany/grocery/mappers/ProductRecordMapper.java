package org.jcompany.grocery.mappers;

import org.jcompany.grocery.model.ProductRecord;
import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.model.UnitOfMeasure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class ProductRecordMapper {
    public ProductRecord map(ProductRecordLine productRecordLine) {
        UnitOfMeasure unit = productRecordLine.getFlags()[2] ? UnitOfMeasure.POUND : UnitOfMeasure.EACH;

        BigDecimal calculatorPrice = null;
        String displayPrice = null;
        if (!productRecordLine.getPrice().equals(BigDecimal.ZERO)) {
            calculatorPrice = productRecordLine.getPrice();
            displayPrice = buildDisplayString(calculatorPrice);
        } else if (!productRecordLine.getSplitPrice().equals(BigDecimal.ZERO)) {
            calculatorPrice = productRecordLine.getSplitPrice().divide(
                    new BigDecimal(productRecordLine.getRegularFor()), 4, RoundingMode.FLOOR);
            displayPrice = buildDisplayStringForSplitPrice(productRecordLine.getSplitPrice(),
                    productRecordLine.getRegularFor(), unit);
        }

        BigDecimal promotionalCalculatorPrice= null;
        String promotionalDisplayPrice = null;
        if (!productRecordLine.getPromotionalPrice().equals(BigDecimal.ZERO)) {
            promotionalCalculatorPrice = productRecordLine.getPromotionalPrice();
            promotionalDisplayPrice = buildDisplayString(promotionalCalculatorPrice);
        } else if (!productRecordLine.getPromotionalSplitPrice().equals(BigDecimal.ZERO)) {
            promotionalCalculatorPrice = productRecordLine.getPromotionalSplitPrice().divide(
                    new BigDecimal(productRecordLine.getPromotionalFor()), 4, RoundingMode.FLOOR);
            promotionalDisplayPrice = buildDisplayStringForSplitPrice(productRecordLine.getPromotionalSplitPrice(),
                    productRecordLine.getPromotionalFor(), unit);
        }

        BigDecimal taxRate = BigDecimal.ZERO;
        if (productRecordLine.getFlags()[4]) {
            taxRate = new BigDecimal("0.0775");
        }

        return new ProductRecord.Builder()
                .withId(productRecordLine.getId())
                .withDescription(productRecordLine.getDescription())
                .withCalculatorPrice(calculatorPrice)
                .withDisplayPrice(displayPrice)
                .withPromotionalCalculatorPrice(promotionalCalculatorPrice)
                .withPromotionalDisplayPrice(promotionalDisplayPrice)
                .withUnitOfMeasure(unit)
                .withSize(productRecordLine.getSize())
                .withTaxRate(taxRate)
                .build();
    }

    private String buildDisplayString(BigDecimal price) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }

    private String buildDisplayStringForSplitPrice(BigDecimal price, int splitAmount, UnitOfMeasure unit) {
        if (unit.equals(UnitOfMeasure.EACH)) {
            return String.format("%s for %n", buildDisplayString(price), splitAmount);
        } else {
            if (splitAmount == 1) {
                return String.format("%s per %n pound", buildDisplayString(price), splitAmount);
            } else {
                return String.format("%s per %n pounds", buildDisplayString(price), splitAmount);
            }
        }
    }
}
