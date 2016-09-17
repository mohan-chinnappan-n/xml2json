
package org.mohansun.dev;

import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class Mapper {


  public static void main( String[] args ) throws Exception {

    University uni = new University();
    uni.setName("Madras");
    uni.setNoOfDepartments(3);

    ArrayList<String> depts = new ArrayList<String>(3);
    depts.add("Math");
    depts.add("Engineering");
    depts.add("Agriculture");
    uni.setDepartments(depts);


    ObjectMapper mapper = new ObjectMapper();
    String uniJSON = mapper.writeValueAsString(uni);
    System.out.println(uniJSON);



    University uni2 = new University();
    uni.setName("Madras");
    uni.setNoOfDepartments(3);

    ArrayList<String> depts2 = new ArrayList<String>(1);
    depts2.add("Math");
    uni2.setDepartments(depts2);

    uniJSON= mapper.writeValueAsString(uni2);
    System.out.println(uniJSON);


  }
}
