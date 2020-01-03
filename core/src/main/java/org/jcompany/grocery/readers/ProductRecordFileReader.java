package org.jcompany.grocery.readers;

import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.parsers.ProductRecordLineParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductRecordFileReader implements ProductRecordLineReader {
    private final ProductRecordLineParser lineParser;

    public ProductRecordFileReader(ProductRecordLineParser lineParser) {
        this.lineParser = lineParser;
    }

    @Override
    public List<ProductRecordLine> getRecordLines(InputStream inputStream) {
        List<ProductRecordLine> productRecordList = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(inputStream)) {
            try (BufferedReader bufferedReader = new BufferedReader(isr)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    productRecordList.add(lineParser.parse(line));
                }
            }
        } catch (IOException exception) {
            System.err.print("Exception when reading file: " + exception);
        }
        return productRecordList;
    }
}
