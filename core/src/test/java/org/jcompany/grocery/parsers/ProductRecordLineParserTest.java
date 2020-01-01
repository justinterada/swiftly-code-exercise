package org.jcompany.grocery.parsers;

import org.jcompany.grocery.model.ProductRecordLine;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test
public class ProductRecordLineParserTest {
    private ProductRecordLineParser instance;

    @BeforeTest
    public void setup() {
        instance = new ProductRecordLineParser();
    }

    @Test
    public void parse() {
        final String input = "80000001 Kimchi-flavored white rice                                  00000567 00000000 00000000 00000000 00000000 00000000 NNNNNNNNN      18oz";

        ProductRecordLine output = instance.parse(input);

        assertNotNull(output);
        assertEquals(output.getId(), 80000001);
        assertEquals(output.getDescription(), "Kimchi-flavored white rice");
        assertEquals(output.getPrice(), new BigDecimal("5.67"));
        assertEquals(output.getSplitPrice(), BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_UNNECESSARY));
        assertEquals(output.getPromotionalPrice(), BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_UNNECESSARY));
        assertEquals(output.getPromotionalSplitPrice(), BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_UNNECESSARY));
        assertEquals(output.getRegularFor(), 0);
        assertEquals(output.getPromotionalFor(), 0);
        assertEquals(output.getSize(), "18oz");
        assertEquals(output.getFlags(), new boolean[] { false, false, false, false, false, false, false, false, false});
    }
}
