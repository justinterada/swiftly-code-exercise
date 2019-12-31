package org.jcompany.grocery;

import org.jcompany.grocery.mappers.ProductRecordMapper;
import org.jcompany.grocery.model.ProductRecord;
import org.jcompany.grocery.model.ProductRecordLine;
import org.jcompany.grocery.parsers.ProductRecordFileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        ProductRecordFileReader fileReader = new ProductRecordFileReader();
        ProductRecordMapper mapper = new ProductRecordMapper();
        List<ProductRecordLine> productRecordLines = fileReader.getRecords(inputStream);
        List<ProductRecord> productRecords = new ArrayList<>(productRecordLines.size());
        for (ProductRecordLine productRecordLine : productRecordLines) {
            productRecords.add(mapper.map(productRecordLine));
        }

        for (ProductRecord productRecord : productRecords) {
            System.out.println(productRecord.toString());
        }
    }
}
