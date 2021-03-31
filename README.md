# CSWProject
This project is made as part of an assignment which will take Json Input and will convert to XML.
I have used a third party library to do the coversion which is added as dependency in pom.xml


Link to the library https://github.com/javadev/underscore-java

## Build

```bash
mvn clean package
```

A jar will be produced in the `target` directory.

## Run

```bash
java -jar CSWProject-<version>.jar <path>
```
## Instructions to run 
Access the resources folder (src/main/resources/JsonInput.json) which is the path for input json and
update the json input string in the JsonInput.json file

Run the jar and verify the XML file created under src/main/resources/<xmlOutput>

Please delete the XMLOutput.txt file after verification before runnig the jar again because each 
time new file will be created under the src/main/resources to write XML output
So if the same file name is used for each run then we have to delete the old file and run

If the project is imported to Eclipse with git and would like to see output file in Eclipse,then please
refresh the project to verify the new file created under src/main/resources

## Example

```bash
C:\Users\Maruthi\git\CSWProject>mvn clean package
```
```bash
C:\Users\Maruthi\git\CSWProject\target>java -jar CSWProject-0.0.1-SNAPSHOT.jar JsonInput.json src/main/resources/XMLOutput.txt 
```



