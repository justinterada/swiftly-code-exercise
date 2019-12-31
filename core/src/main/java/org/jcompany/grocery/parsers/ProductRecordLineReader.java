package org.jcompany.grocery.parsers;

import org.jcompany.grocery.model.ProductRecordLine;

import java.io.InputStream;
import java.util.List;

public interface ProductRecordLineReader {
    List<ProductRecordLine> getRecords(InputStream inputStream);
}
