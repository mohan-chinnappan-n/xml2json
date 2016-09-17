#xml2json

### Project explains how to handle/perserve single array elements in XML using StAXON - JSON via StAX

#### How to run:

<pre>

 $ mvn clean dependency:copy-dependencies package

  JSON output xml to JSON via staxon - explains about <?xml-multiple?> xml annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp.xml

  JSON output with  <?xml-multiple?> xml annotation

  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp2.xml


  pojo to JSON using jackson
  $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.Mapper
</pre>


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
