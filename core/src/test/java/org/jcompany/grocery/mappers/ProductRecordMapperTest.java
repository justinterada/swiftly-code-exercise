package org.jcompany.grocery.mappers;

import org.jcompany.grocery.model.ProductRecord;
import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.model.UnitOfMeasure;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNull;

@Test
public class ProductRecordMapperTest {
    private ProductRecordMapper instance;

    @BeforeTest
    public void setup() {
        instance = new ProductRecordMapper();
    }

    @Test
    public void map() {
        final ProductRecordLine input = ProductRecordLine.getBuilder()
                .withId(80000001)
                .withDescription("Kimchi-flavored white rice")
                .withPrice(new BigDecimal("5.67"))
                .withSplitPrice(BigDecimal.ZERO)
                .withPromotionalPrice(BigDecimal.ZERO)
                .withPromotionalSplitPrice(BigDecimal.ZERO)
                .withRegularFor(0)
                .withPromotionalFor(0)
                .withSize("18oz")
                .withFlags(new boolean[] { false, false, false, false, false, false, false, false })
                .build();

        final ProductRecord output = instance.map(input);

        assertEquals(output.getId(), 80000001);
        assertEquals(output.getDescription(), "Kimchi-flavored white rice");
        assertEquals(output.getDisplayPrice(), "$5.67 each");
        assertEquals(output.getCalculatorPrice(), new BigDecimal("5.6700"));
        assertNull(output.getPromotionalDisplayPrice());
        assertNull(output.getPromotionalCalculatorPrice());
        assertEquals(output.getUnitOfMeasure(), UnitOfMeasure.EACH);
        assertEquals(output.getSize(), "18oz");
        assertEquals(output.getTaxRate(), BigDecimal.ZERO.setScale(4, BigDecimal.ROUND_UNNECESSARY));
    }

    @Test
    public void mapWithSplitPrice() {
        final ProductRecordLine input = ProductRecordLine.getBuilder()
                .withId(20005)
                .withDescription("Mandarin Oranges")
                .withPrice(BigDecimal.ZERO)
                .withSplitPrice(new BigDecimal("5.23"))
                .withPromotionalPrice(BigDecimal.ZERO)
                .withPromotionalSplitPrice(new BigDecimal("2.50"))
                .withRegularFor(2)
                .withPromotionalFor(1)
                .withSize("lb")
                .withFlags(new boolean[] { false, false, true, false, true, false, false, false })
                .build();

        final ProductRecord output = instance.map(input);

        assertEquals(output.getId(), 20005);
        assertEquals(output.getDescription(), "Mandarin Oranges");
        assertEquals(output.getDisplayPrice(), "$5.23 per 2 pounds");
        assertEquals(output.getCalculatorPrice(), new BigDecimal("2.6150"));
        assertEquals(output.getPromotionalDisplayPrice(), "$2.50 per pound");
        assertEquals(output.getPromotionalCalculatorPrice(), new BigDecimal("2.5000"));
        assertEquals(output.getUnitOfMeasure(), UnitOfMeasure.POUND);
        assertEquals(output.getSize(), "lb");
        assertEquals(output.getTaxRate(), new BigDecimal("0.0775"));
    }

    @Test
    public void mapWithPromotionalPrice() {
        final ProductRecordLine input = ProductRecordLine.getBuilder()
                .withId(9999)
                .withDescription("2% Milk")
                .withPrice(BigDecimal.ZERO)
                .withSplitPrice(new BigDecimal("5.00"))
                .withPromotionalPrice(new BigDecimal("2.00"))
                .withPromotionalSplitPrice(BigDecimal.ZERO)
                .withRegularFor(2)
                .withPromotionalFor(0)
                .withSize("1 gallon")
                .withFlags(new boolean[] { false, false, false, false, false, false, false, false })
                .build();

        final ProductRecord output = instance.map(input);

        assertEquals(output.getId(), 9999);
        assertEquals(output.getDescription(), "2% Milk");
        assertEquals(output.getDisplayPrice(), "$5.00 for 2");
        assertEquals(output.getCalculatorPrice(), new BigDecimal("2.5000"));
        assertEquals(output.getPromotionalDisplayPrice(), "$2.00 each");
        assertEquals(output.getPromotionalCalculatorPrice(), new BigDecimal("2.0000"));
        assertEquals(output.getUnitOfMeasure(), UnitOfMeasure.EACH);
        assertEquals(output.getSize(), "1 gallon");
        assertEquals(output.getTaxRate(), BigDecimal.ZERO.setScale(4, RoundingMode.UNNECESSARY));
    }

    @Test
    public void mapWithPromotionalSplitPrice() {
        final ProductRecordLine input = ProductRecordLine.getBuilder()
                .withId(8675309)
                .withDescription("Jack Daniels")
                .withPrice(new BigDecimal("25.00"))
                .withSplitPrice(BigDecimal.ZERO)
                .withPromotionalPrice(BigDecimal.ZERO)
                .withPromotionalSplitPrice(new BigDecimal("40.00"))
                .withRegularFor(0)
                .withPromotionalFor(2)
                .withSize("750 mL")
                .withFlags(new boolean[] { false, false, false, false, true, false, false, false })
                .build();

        final ProductRecord output = instance.map(input);

        assertEquals(output.getId(), 8675309);
        assertEquals(output.getDescription(), "Jack Daniels");
        assertEquals(output.getDisplayPrice(), "$25.00 each");
        assertEquals(output.getCalculatorPrice(), new BigDecimal("25.0000"));
        assertEquals(output.getPromotionalDisplayPrice(), "$40.00 for 2");
        assertEquals(output.getPromotionalCalculatorPrice(), new BigDecimal("20.0000"));
        assertEquals(output.getUnitOfMeasure(), UnitOfMeasure.EACH);
        assertEquals(output.getSize(), "750 mL");
        assertEquals(output.getTaxRate(), new BigDecimal("0.0775"));
    }

    @Test
    public void toStringTest() {
        ProductRecord record = ProductRecord.getBuilder()
                .withId(80000001)
                .withDescription("Kimchi-flavored white rice")
                .withDisplayPrice("$5.67 each")
                .withCalculatorPrice(new BigDecimal("5.6700"))
                .withUnitOfMeasure(UnitOfMeasure.EACH)
                .withSize("18oz")
                .withTaxRate(BigDecimal.ZERO.setScale(4, BigDecimal.ROUND_UNNECESSARY))
                .build();

        assertEquals(record.toString(), "{\n" +
                "    id: 80000001,\n" +
                "    description: \"Kimchi-flavored white rice\",\n" +
                "    displayPrice: \"$5.67 each\",\n" +
                "    calculatorPrice: 5.6700,\n" +
                "    promotionalDisplayPrice: null,\n" +
                "    promotionalCalculatorPrice: null,\n" +
                "    unitOfMeasure: EACH,\n" +
                "    size: \"18oz\",\n" +
                "    taxRate: 0.0000,\n" +
                "}");
    }
}
