package org.jcompany.grocery;

import org.jcompany.grocery.model.ProductRecord;

import java.io.InputStream;
import java.util.List;

public interface ProductRecordReader {
    List<ProductRecord> getRecords(InputStream inputStream);
}
