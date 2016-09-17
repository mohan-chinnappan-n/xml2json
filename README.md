#xml2json

### Project explains how to handle/perserve single array elements in XML using StAXON - JSON via StAX

#### How to run:

 $ mvn clean dependency:copy-dependencies package

  JSON output xml to JSON via staxon - explains about <?xml-multiple?> xml annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp.xml

  JSON output with  <?xml-multiple?> xml annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp2.xml


  pojo to JSON using jackson
  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.Mapper


##### Sample output  **with** <?xml-multiple?> xml annotation
  [mchinnappanh:xmlparser] $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp.xml
  <team>
    <?xml-multiple?>
    <employee>
      <name>Scott</name>
    </employee>
  </team>
   ==>
   {
  	"team" : {
  		"employee" : [ {
  			"name" : "Scott"
  		} ]
  	}
  }
===========================


##### Sample output  **without** <?xml-multiple?> xml annotation

[mchinnappanh:xmlparser] $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp2.xml
<team>
  <employee>
    <name>Scott</name>
  </employee>
</team>
 ==>
 {
	"team" : {
		"employee" : {
			"name" : "Scott"
		}
	}
}
