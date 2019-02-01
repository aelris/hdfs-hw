package com.app;

import org.apache.avro.Schema;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class ParquetUtilsTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testParseAvroSchema() throws Exception {
        Schema result = ParquetUtils.parseAvroSchema("src/test/resources/sample.avsc");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testWriteToParquet() throws Exception {
        ParquetUtils.writeToParquet(null, "csvPath", "parquetPath");
    }

    @Test
    public void testReadParquetFile() throws Exception {
        ParquetUtils.readParquetFile("src/test/resources/fileForRead.parquet",5);

        assertEquals(  "{\"id\": 0, \"hotel_cluster\": \"a\"}\r\n" +
                "{\"id\": 1, \"hotel_cluster\": \"b\"}\r\n" +
                "{\"id\": 2, \"hotel_cluster\": \"c\"}\r\n" +
                "{\"id\": 3, \"hotel_cluster\": \"d\"}\r\n" +
                "{\"id\": 4, \"hotel_cluster\": \"e\"}\r\n", systemOutRule.getLog());
    }
}

