package org.jcompany.grocery;

import org.jcompany.grocery.model.ProductRecord;

import java.util.Enumeration;

public interface ProductRecordReader {
    public Enumeration<ProductRecord> getRecords();
}
