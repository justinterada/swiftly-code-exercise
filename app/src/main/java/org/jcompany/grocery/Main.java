package org.jcompany.grocery;

import org.jcompany.grocery.model.ProductRecord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        ProductRecordFileReader fileReader = new ProductRecordFileReader();
        List<ProductRecord> records = fileReader.getRecords(inputStream);

        System.out.print("Loaded " + records.size() + " records");
    }
}
