package org.jcompany.grocery.model;

public class ProductRecord {
    private final int id;
    private final String description;
    private final Price price;
    private final Price promotionalPrice;
    private final Price splitPrice;
    private final Price promotionalSplitPrice;
    private final int regularFor;
    private final int promotionalFor;
    private final String size;
    private final UnitOfMeasure unitOfMeasure;

    private ProductRecord(final int id,
                         final String description,
                         final Price price,
                         final Price promotionalPrice,
                         final Price splitPrice,
                         final Price promotionalSplitPrice,
                         final int regularFor,
                         final int promotionalFor,
                         final String size,
                         final UnitOfMeasure unitOfMeasure) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.splitPrice = splitPrice;
        this.promotionalSplitPrice = promotionalSplitPrice;
        this.regularFor = regularFor;
        this.promotionalFor = promotionalFor;
        this.size = size;
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public Price getPromotionalPrice() {
        return promotionalPrice;
    }

    public Price getSplitPrice() {
        return splitPrice;
    }

    public Price getPromotionalSplitPrice() {
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public static class Builder {
        private int id;
        private String description;
        private Price price;
        private Price promotionalPrice;
        private Price splitPrice;
        private Price promotionalSplitPrice;
        private int regularFor;
        private int promotionalFor;
        private String size;
        private UnitOfMeasure unitOfMeasure;

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder withPromotionalFor(int promotionalFor) {
            this.promotionalFor = promotionalFor;
            return this;
        }

        public Builder withPromotionalPrice(Price promotionalPrice) {
            this.promotionalPrice = promotionalPrice;
            return this;
        }

        public Builder withPromotionalSplitPrice(Price promotionalSplitPrice) {
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

        public Builder withSplitPrice(Price splitPrice) {
            this.splitPrice = splitPrice;
            return this;
        }

        public Builder withUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public ProductRecord build() {
            return new ProductRecord(this.id,
                this.description,
                this.price,
                this.promotionalPrice,
                this.splitPrice,
                this.promotionalSplitPrice,
                this.regularFor,
                this.promotionalFor,
                this.size,
                this.unitOfMeasure);
        }
    }
}
