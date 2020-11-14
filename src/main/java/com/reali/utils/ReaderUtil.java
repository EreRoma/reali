package com.reali.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReaderUtil {

    public static <T> List<T> readCsv(String filePathAndName, Class<T> typeObj) throws IOException {
        List<T> results = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get(filePathAndName));
        CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader).withType(typeObj).withFieldAsNull(null)
                .withIgnoreLeadingWhiteSpace(true).build();
        results = csvToBean.parse();
        return results;
    }

    public static Integer parseParam(String paramName, Map<String, String> requestParams) {
        return requestParams.get(paramName) == null ? null : (Integer.parseInt(requestParams.get(paramName)));
    }
}
