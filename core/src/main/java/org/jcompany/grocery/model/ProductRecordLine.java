package org.jcompany.grocery.model;

import java.math.BigDecimal;

public class ProductRecordLine {
    private final int id;
    private final String description;
    private final BigDecimal price;
    private final BigDecimal promotionalPrice;
    private final BigDecimal splitPrice;
    private final BigDecimal promotionalSplitPrice;
    private final int regularFor;
    private final int promotionalFor;
    private final String size;
    private final boolean[] flags;

    private ProductRecordLine(final int id,
                              final String description,
                              final BigDecimal price,
                              final BigDecimal promotionalPrice,
                              final BigDecimal splitPrice,
                              final BigDecimal promotionalSplitPrice,
                              final int regularFor,
                              final int promotionalFor,
                              final String size,
                              final boolean[] flags) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.splitPrice = splitPrice;
        this.promotionalSplitPrice = promotionalSplitPrice;
        this.regularFor = regularFor;
        this.promotionalFor = promotionalFor;
        this.size = size;
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public BigDecimal getSplitPrice() {
        return splitPrice;
    }

    public BigDecimal getPromotionalSplitPrice() {
        return promotionalSplitPrice;
    }

    public int getRegularFor() {
        return regularFor;
    }

    public int getPromotionalFor() {
        return promotionalFor;
    }

    public String getSize() {
        return size;
    }

    public boolean[] getFlags() {
        return flags;
    }

    public static class Builder {
        private int id;
        private String description;
        private BigDecimal price;
        private BigDecimal promotionalPrice;
        private BigDecimal splitPrice;
        private BigDecimal promotionalSplitPrice;
        private int regularFor;
        private int promotionalFor;
        private String size;
        private boolean[] flags;

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withPromotionalFor(int promotionalFor) {
            this.promotionalFor = promotionalFor;
            return this;
        }

        public Builder withPromotionalPrice(BigDecimal promotionalPrice) {
            this.promotionalPrice = promotionalPrice;
            return this;
        }

        public Builder withPromotionalSplitPrice(BigDecimal promotionalSplitPrice) {
            this.promotionalSplitPrice = promotionalSplitPrice;
            return this;
        }

        public Builder withRegularFor(int regularFor) {
            this.regularFor = regularFor;
            return this;
        }

        public Builder withSize(String size) {
            this.size = size;
            return this;
        }

        public Builder withSplitPrice(BigDecimal splitPrice) {
            this.splitPrice = splitPrice;
            return this;
        }

        public Builder withFlags(boolean[] flags) {
            this.flags = flags;
            return this;
        }

        public ProductRecordLine build() {
            return new ProductRecordLine(this.id,
                this.description,
                this.price,
                this.promotionalPrice,
                this.splitPrice,
                this.promotionalSplitPrice,
                this.regularFor,
                this.promotionalFor,
                this.size,
                this.flags);
        }
    }
}
