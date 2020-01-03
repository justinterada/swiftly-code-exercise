package org.jcompany.grocery;

import org.jcompany.grocery.mappers.ProductRecordMapper;
import org.jcompany.grocery.model.ProductRecord;
import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.readers.ProductRecordFileReader;
import org.jcompany.grocery.parsers.ProductRecordLineParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ProductRecordFileReader fileReader = new ProductRecordFileReader(new ProductRecordLineParser());
        ProductRecordMapper mapper = new ProductRecordMapper();
        List<ProductRecord> productRecords = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(args[0])) {
            List<ProductRecordLine> productRecordLines = fileReader.getRecordLines(inputStream);
            for (ProductRecordLine productRecordLine : productRecordLines) {
                productRecords.add(mapper.map(productRecordLine));
            }
        }

        for (ProductRecord productRecord : productRecords) {
            System.out.println(productRecord.toString());
        }
    }
}
