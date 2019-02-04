package com.app;

import org.apache.avro.Schema;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String schemaPath = args[0];
        String csvPath = args[1];
        String parquetPath =  args[2] + "_" + new Date().getTime() + ".parquet ";
        int maxRows = Integer.parseInt(args[3]);

        //parsing avro schema
        Schema schema = ParquetUtils.parseAvroSchema(schemaPath);

        //converting csv(args[1]) to parquet file(args[2]) using avro schema(args[0])
        ParquetUtils.writeToParquet(schema,csvPath,parquetPath);

        //printing content of generated parquet file(args[2]) with some maximum rows(args[3])
        ParquetUtils.readParquetFile(parquetPath,maxRows);

    }




}