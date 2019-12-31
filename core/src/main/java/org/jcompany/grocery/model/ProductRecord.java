package org.jcompany.grocery.model;

import java.math.BigDecimal;

public class ProductRecord {
    private final int id;
    private final String description;
    private final String displayPrice;
    private final BigDecimal calculatorPrice;
    private final String promotionalDisplayPrice;
    private final BigDecimal promotionalCalculatorPrice;
    private final UnitOfMeasure unitOfMeasure;
    private final String size;
    private final BigDecimal taxRate;

    private ProductRecord(final int id,
                          final String description,
                          final String displayPrice,
                          final BigDecimal calculatorPrice,
                          final String promotionalDisplayPrice,
                          final BigDecimal promotionalCalculatorPrice,
                          final UnitOfMeasure unitOfMeasure,
                          final String size,
                          final BigDecimal taxRate) {
        this.id = id;
        this.description = description;
        this.displayPrice = displayPrice;
        this.calculatorPrice = calculatorPrice;
        this.promotionalDisplayPrice = promotionalDisplayPrice;
        this.promotionalCalculatorPrice = promotionalCalculatorPrice;
        this.unitOfMeasure = unitOfMeasure;
        this.size = size;
        this.taxRate = taxRate;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public BigDecimal getCalculatorPrice() {
        return calculatorPrice;
    }

    public BigDecimal getPromotionalCalculatorPrice() {
        return promotionalCalculatorPrice;
    }

    public String getPromotionalDisplayPrice() {
        return promotionalDisplayPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public String getSize() {
        return size;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public static class Builder {
        private int id;
        private String description;
        private String displayPrice;
        private BigDecimal calculatorPrice;
        private String promotionalDisplayPrice;
        private BigDecimal promotionalCalculatorPrice;
        private UnitOfMeasure unitOfMeasure;
        private String size;
        private BigDecimal taxRate;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCalculatorPrice(BigDecimal calculatorPrice) {
            this.calculatorPrice = calculatorPrice;
            return this;
        }

        public Builder withDisplayPrice(String displayPrice) {
            this.displayPrice = displayPrice;
            return this;
        }

        public Builder withPromotionalCalculatorPrice(BigDecimal promotionalCalculatorPrice) {
            this.promotionalCalculatorPrice = promotionalCalculatorPrice;
            return this;
        }

        public Builder withPromotionalDisplayPrice(String promotionalDecimalPrice) {
            this.promotionalDisplayPrice = promotionalDecimalPrice;
            return this;
        }

        public Builder withTaxRate(BigDecimal taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder withSize(String size) {
            this.size = size;
            return this;
        }

        public Builder withUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public ProductRecord build() {
            return new ProductRecord(id,
                    description,
                    displayPrice,
                    calculatorPrice,
                    promotionalDisplayPrice,
                    promotionalCalculatorPrice,
                    unitOfMeasure,
                    size,
                    taxRate);
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "    id: " + id + ",\n" +
                "    description: \"" + description + "\",\n" +
                "    displayPrice: \"" + displayPrice + "\",\n" +
                "    calculatorPrice: " + calculatorPrice + ",\n" +
                "    promotionalDisplayPrice: \"" + promotionalDisplayPrice + "\",\n" +
                "    promotionalCalculatorPrice: " + promotionalCalculatorPrice + ",\n" +
                "    unitOfMeasure: " + unitOfMeasure + ",\n" +
                "    size: \"" + displayPrice + "\",\n" +
                "    taxRate: " + promotionalCalculatorPrice + ",\n" +
                "}";
    }
}
