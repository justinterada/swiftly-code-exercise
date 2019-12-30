package org.jcompany.grocery;

import org.jcompany.grocery.model.ProductRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class ProductRecordFileReader implements ProductRecordReader {
    @Override
    public List<ProductRecord> getRecords(InputStream inputStream) {
        List<ProductRecord> productRecordList = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String line;
        HashSet<String> dictionary = new HashSet<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                dictionary.add(line.toUpperCase(Locale.US));
            }
        } catch (IOException exception) {
            System.err.print("Exception when reading file: " + exception);
        }

        return productRecordList;
    }
}
