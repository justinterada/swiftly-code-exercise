package org.jcompany.grocery.mappers;

import org.jcompany.grocery.model.ProductRecord;
import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.model.UnitOfMeasure;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;

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
        final ProductRecordLine input = new ProductRecordLine.Builder()
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
}
