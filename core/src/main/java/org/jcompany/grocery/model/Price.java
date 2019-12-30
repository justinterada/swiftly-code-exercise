package org.jcompany.grocery.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {
    private final BigDecimal amount;
    private final Currency currency;

    private Price(final BigDecimal amount, final Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static class Builder {
        private BigDecimal amount;
        private Currency currency;

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            return new Price(this.amount, this.currency);
        }
    }
}
