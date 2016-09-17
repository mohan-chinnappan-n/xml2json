package org.mohansun.dev;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLOutputFactory;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class App
{

    public static String convertToJson(String xml_data) {
      return convertToJson(xml_data, new PrintWriter(System.err));
     }


   public static String convertToJson(String xml_data, PrintWriter out) {
  // Conversion based on https://github.com/beckchr/staxon/wiki/Converting-XML-to-JSON
  /*
   * If we want to insert JSON array boundaries for multiple elements, we need to set the <code>autoArray</code>
   * property. If our XML source was decorated with <code><?xml-multiple?></code> processing instructions,
   * we'd set the <code>multiplePI</code> property instead.
   */
  JsonXMLConfig config = new JsonXMLConfigBuilder().autoArray(true).prettyPrint(true).build();
  InputStream input = null;
  OutputStream output = null;
  String ret = "error";
  try {
   input = new ByteArrayInputStream(xml_data.getBytes("UTF-8"));
   output = new ByteArrayOutputStream();
   /*
    * Create reader (XML).
    */
   XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(input);

   /*
    * Create writer (JSON).
    */
   XMLEventWriter writer = new JsonXMLOutputFactory(config).createXMLEventWriter(output);

   /*
    * Copy events from reader to writer.
    */
   writer.add(reader);

   /*
    * Close reader/writer.
    */
   reader.close();
   writer.close();
   ret = output.toString();
  } catch (UnsupportedEncodingException ue) {
   out.print("<font color='red'>Unsupported encoding during conversion: XML to JSON.</font>");
  } catch (XMLStreamException se) {
   out.print("<font color='red'>XML Stream exception during conversion: XML to JSON.</font>");
   se.printStackTrace();
  } catch (FactoryConfigurationError fe) {
   out.print("<font color='red'>Factory configuration error during conversion: XML to JSON.</font>");
   fe.printStackTrace();
  } catch (TransformerFactoryConfigurationError tfe) {
   out.print("<font color='red'>Transformer factory configuration error during conversion: XML to JSON.</font>");
   tfe.printStackTrace();
  } finally {
   /*
    * As per StAX specification, XMLEventReader/Writer.close() doesn't close the underlying stream.
    */
   if (output != null)
    try {
     output.close();
    } catch (IOException e) {
    }
   if (input != null)
    try {
     input.close();
    } catch (IOException e) {
    }
  }
  return ret;
 }

    public static void main( String[] args ) throws Exception {
        App app = new App();
        String xmlstr2 = String.join("\n"
                 , "<team>"
                 , "    <employee><name>Scott</name></employee>"
                 , "    <employee><name>Tiger</name></employee>"
                , "</team>"
        );

        String xmlstr1 = String.join("\n"
                 , "<team>"
                 , " <?xml-multiple?>"
                 , "    <employee><name>Scott</name></employee>"
                , "</team>"
        );
        String xmlstr0 = String.join("\n"
                 , "<team>"
                 , "    <employee><name>Scott</name></employee>"
                , "</team>"
        );

        System.out.println( xmlstr0 + " ==>\n "  +  app.convertToJson(xmlstr0) + "\n===========================\n" );
        System.out.println( xmlstr1 + " ==>\n "  +  app.convertToJson(xmlstr1) + "\n===========================\n" );
        System.out.println( xmlstr2 + " ==>\n "  +  app.convertToJson(xmlstr2) + "\n===========================\n" );


        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        gson.toJson(123, System.out);


    }

}
