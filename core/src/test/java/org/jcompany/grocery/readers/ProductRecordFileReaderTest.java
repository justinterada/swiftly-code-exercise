package org.jcompany.grocery.readers;

import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.parsers.ProductRecordLineParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertSame;

@Test
public class ProductRecordFileReaderTest {
    private ProductRecordFileReader instance;
    private ProductRecordLineParser lineParser;

    @BeforeMethod
    public void setup() {
        lineParser = mock(ProductRecordLineParser.class);
        instance = new ProductRecordFileReader(lineParser);
    }

    @Test
    public void getRecordLines() {
        InputStream input = getClass().getResourceAsStream("/test-input.txt");
        ProductRecordLine parsedOutput = new ProductRecordLine.Builder().build();
        when(lineParser.parse("80000001 Kimchi-flavored white rice                                  00000567 00000000 00000000 00000000 00000000 00000000 " +
                "NNNNNNNNN      18oz")).thenReturn(parsedOutput);

        List<ProductRecordLine> productRecordLines = instance.getRecordLines(input);

        assertNotNull(productRecordLines);
        assertEquals(productRecordLines.size(), 1);
        assertSame(productRecordLines.get(0), parsedOutput);
    }

    @Test
    public void getRecordLinesWithException() throws IOException {
        InputStream input = mock(InputStream.class);
        when(input.read()).thenThrow(IOException.class);

        List<ProductRecordLine> productRecordLines = instance.getRecordLines(input);

        assertNotNull(productRecordLines);
        assertEquals(productRecordLines.size(), 0);
        verify(lineParser, never()).parse(anyString());
    }
}
