package org.jcompany.grocery.parsers;

import org.jcompany.grocery.model.ProductRecordLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductRecordFileReader implements ProductRecordLineReader {
    @Override
    public List<ProductRecordLine> getRecords(InputStream inputStream) {
        List<ProductRecordLine> productRecordList = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String line;
        ProductRecordLineParser parser = new ProductRecordLineParser();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                productRecordList.add(parser.parse(line));
            }
        } catch (IOException exception) {
            System.err.print("Exception when reading file: " + exception);
        }

        return productRecordList;
    }
}
