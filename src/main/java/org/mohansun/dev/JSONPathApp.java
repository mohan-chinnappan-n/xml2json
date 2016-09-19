package org.mohansun.dev;


import java.util.List;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import com.jayway.jsonpath.*;


public class JSONPathApp  {

  public static void main(String[] args)  throws Exception{

    if (args.length < 2) {
      System.out.println("Usage: JSONPathApp <jsonFile> <jsonPathExpression>");
      System.exit(0);
    }

    String fileName = args[0];
    if (fileName == null) fileName = "store.json";

    String jsonExpr = args[1];
    if (jsonExpr == null) jsonExpr = "$.store.book[*].author";


    InputStream inputStream = new FileInputStream(new File(fileName));
    String json = IOUtils.toString(inputStream);

    List<String> authors = JsonPath.read(json, jsonExpr);
     

    System.out.println(authors);

  }

}
