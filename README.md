#xml2json

### Project explains how to handle/perserve single array elements in XML-JSON conversion using StAXON - JSON via StAX

#### JSON output XML to JSON conversion via staxon - using : ```xml <?xml-multiple?>```  xml annotation


#### How to run:



 $ mvn clean dependency:copy-dependencies package

  JSON output XML to JSON conversion  with :
  ```xml
    <?xml-multiple?>
  ```
   annotation

  <pre> $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp.xml </pre>

  JSON output XML to JSON conversion  without :
     ```xml
      <?xml-multiple?>
     ```  
   annotation

  <pre> $ java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.App emp2.xml  </pre>

 <pre>
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


## JSONPath

Input JSON:

```json

cat store.json
{
 "store": {
   "book": [{
     "category": "reference",
     "author": "Nigel Rees",
     "title": "Sayings of the Century",
     "price": 8.95
   }, {
     "category": "fiction",
     "author": "Evelyn Waugh",
     "title": "Sword of Honour",
     "price": 12.99
   }, {
     "category": "fiction",
     "author": "Herman Melville",
     "title": "Moby Dick",
     "isbn": "0-553-21311-3",
     "price": 8.99
   }, {
     "category": "fiction",
     "author": "J. R. R. Tolkien",
     "title": "The Lord of the Rings",
     "isbn": "0-395-19395-8",
     "price": 22.99
   }],
   "bicycle": {
     "color": "red",
     "price": 19.95
   }
 },
 "expensive": 10
}


```

Expression: $.store.book[*].author

Running:
<pre>

java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.JSONPathApp store.json '$.store.book[*].author'


["Nigel Rees","Evelyn Waugh","Herman Melville","J. R. R. Tolkien"]

</pre>


## pojo to JSON

<pre>
java -cp target/xmlparser-1.0-SNAPSHOT.jar:target/dependency/* org.mohansun.dev.Mapper
</pre>

```json
{"name":"Massachusetts Institute of Technology","noOfDepartments":3,"departments":["Math","Engineering","Agriculture"]}
{"name":"University of Madras","noOfDepartments":3,"departments":["Math","Engineering","Arts"]}
```
