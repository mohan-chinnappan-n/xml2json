
package org.mohansun.dev;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import java.util.List;

import org.json.JSONObject;
import org.json.XML;



//import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.xml.XmlMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;

//ref: https://github.com/FasterXML/jackson-dataformat-xml

public class Xml2Json
{
  public static void main(String[] args) throws Exception
  {
    XmlMapper xmlMapper = new XmlMapper();
    String fileName = args[0];
    if (fileName == null) fileName = "emp.xml";

    List entries = xmlMapper.readValue(new File(fileName), List.class);

    ObjectMapper jsonMapper = new ObjectMapper()
      .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    String jsonStr = jsonMapper.writeValueAsString(entries);
    System.out.println(jsonStr);


    InputStream inputStream = new FileInputStream(new File(fileName));
    String xml = IOUtils.toString(inputStream);
    JSONObject jObject = XML.toJSONObject(xml);
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    Object json = mapper.readValue(jObject.toString(), Object.class);
    String output = mapper.writeValueAsString(json);
    System.out.println(output);





  }
}
