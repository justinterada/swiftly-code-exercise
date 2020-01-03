package org.jcompany.grocery.readers;

import org.jcompany.grocery.model.ProductRecordLine;

import java.io.InputStream;
import java.util.List;

public interface ProductRecordLineReader {
    List<ProductRecordLine> getRecordLines(InputStream inputStream);
}
