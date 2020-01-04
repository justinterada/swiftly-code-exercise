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
        String[] actualLines = output.trim().split("\n");
        String[] expectedLines = new String[] { "{",
                "    id: 80000001,",
                "    description: \"Kimchi-flavored white rice\",",
                "    displayPrice: \"$5.67 each\",",
                "    calculatorPrice: 5.6700,",
                "    promotionalDisplayPrice: null,",
                "    promotionalCalculatorPrice: null,",
                "    unitOfMeasure: EACH,",
                "    size: \"18oz\",",
                "    taxRate: 0.0000,",
                "}",
                "{",
                "    id: 14963801,",
                "    description: \"Generic Soda 12-pack\",",
                "    displayPrice: \"$13.00 for 2\",",
                "    calculatorPrice: 6.5000,",
                "    promotionalDisplayPrice: \"$5.49 each\",",
                "    promotionalCalculatorPrice: 5.4900,",
                "    unitOfMeasure: EACH,",
                "    size: \"12x12oz\",",
                "    taxRate: 0.0775,",
                "}",
                "{",
                "    id: 40123401,",
                "    description: \"Marlboro Cigarettes\",",
                "    displayPrice: \"$10.00 each\",",
                "    calculatorPrice: 10.0000,",
                "    promotionalDisplayPrice: \"$5.49 each\",",
                "    promotionalCalculatorPrice: 5.4900,",
                "    unitOfMeasure: EACH,",
                "    size: \"\",",
                "    taxRate: 0.0000,",
                "}",
                "{",
                "    id: 50133333,",
                "    description: \"Fuji Apples (Organic)\",",
                "    displayPrice: \"$3.49 per pound\",",
                "    calculatorPrice: 3.4900,",
                "    promotionalDisplayPrice: null,",
                "    promotionalCalculatorPrice: null,",
                "    unitOfMeasure: POUND,",
                "    size: \"lb\",",
                "    taxRate: 0.0000,",
                "}" };

        assertEquals(actualLines.length, expectedLines.length);
        for (int lineNum = 0; lineNum < expectedLines.length; lineNum++) {
            assertEquals(actualLines[lineNum].trim(), expectedLines[lineNum].trim(), "Line " + (lineNum + 1));
        }
    }
}
