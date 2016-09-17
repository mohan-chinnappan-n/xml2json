#xml2json

### Project explains how to handle/perserve single array elements in XML-JSON conversion using StAXON - JSON via StAX

#### JSON output XML to JSON conversion via staxon - using : ```xml <?xml-multiple?>```  xml annotation


#### How to run:



 $ mvn clean dependency:copy-dependencies package

  JSON output XML to JSON conversion  with :
  ```xml <?xml-multiple?>
  ```
   annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp.xml

  JSON output XML to JSON conversion  without :
     ```xml <?xml-multiple?>
     ```  
  xml annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp2.xml


  pojo to JSON using jackson
  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.Mapper
 


#### Sample output  **with** <?xml-multiple?> xml annotation

<pre>
 $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* \
      org.mohansun.dev.App emp.xml

</pre>
```xml
  <team>
    <?xml-multiple?>
    <employee>
      <name>Scott</name>
    </employee>
  </team>
```

   ==>
```json
   {
  	"team" : {
  		"employee" : [ {
  			"name" : "Scott"
  		} ]
  	}
  }
```

#### Sample output  **without** <?xml-multiple?> xml annotation

<pre>

 $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* \
          org.mohansun.dev.App emp2.xml
</pre>

```xml
<team>
  <employee>
    <name>Scott</name>
  </employee>
</team>
```

 ==>

 ```json
 {
	"team" : {
		"employee" : {
			"name" : "Scott"
		}
	}
}
```
