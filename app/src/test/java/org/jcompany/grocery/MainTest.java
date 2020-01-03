package org.jcompany.grocery;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test
public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeTest
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterTest
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void main() throws IOException {
        Main.main(new String[] {"input-sample.txt"});

        String errorOutput = errContent.toString();
        assertEquals(errorOutput, "");
        String output = outContent.toString();
        assertNotNull(output);
        assertEquals(output, "{\n" +
                "    id: 80000001,\n" +
                "    description: \"Kimchi-flavored white rice\",\n" +
                "    displayPrice: \"$5.67 each\",\n" +
                "    calculatorPrice: 5.6700,\n" +
                "    promotionalDisplayPrice: null,\n" +
                "    promotionalCalculatorPrice: null,\n" +
                "    unitOfMeasure: EACH,\n" +
                "    size: \"18oz\",\n" +
                "    taxRate: 0.0000,\n" +
                "}\n" +
                "{\n" +
                "    id: 14963801,\n" +
                "    description: \"Generic Soda 12-pack\",\n" +
                "    displayPrice: \"$13.00 for 2\",\n" +
                "    calculatorPrice: 6.5000,\n" +
                "    promotionalDisplayPrice: \"$5.49 each\",\n" +
                "    promotionalCalculatorPrice: 5.4900,\n" +
                "    unitOfMeasure: EACH,\n" +
                "    size: \"12x12oz\",\n" +
                "    taxRate: 0.0775,\n" +
                "}\n" +
                "{\n" +
                "    id: 40123401,\n" +
                "    description: \"Marlboro Cigarettes\",\n" +
                "    displayPrice: \"$10.00 each\",\n" +
                "    calculatorPrice: 10.0000,\n" +
                "    promotionalDisplayPrice: \"$5.49 each\",\n" +
                "    promotionalCalculatorPrice: 5.4900,\n" +
                "    unitOfMeasure: EACH,\n" +
                "    size: \"\",\n" +
                "    taxRate: 0.0000,\n" +
                "}\n" +
                "{\n" +
                "    id: 50133333,\n" +
                "    description: \"Fuji Apples (Organic)\",\n" +
                "    displayPrice: \"$3.49 per pound\",\n" +
                "    calculatorPrice: 3.4900,\n" +
                "    promotionalDisplayPrice: null,\n" +
                "    promotionalCalculatorPrice: null,\n" +
                "    unitOfMeasure: POUND,\n" +
                "    size: \"lb\",\n" +
                "    taxRate: 0.0000,\n" +
                "}\n");
    }
}
