package decoder;

import java.io.IOException;

import org.junit.Test;

public class XMLJSONConverterImplTest {
	
	//Delete the file created at arg1 before running the test
	@Test
	public void testToVerifyXMLFileCreation() throws IOException {
		
		String agr0 = "JsonInput.json";
		String arg1 = "src/main/resources/XMLOutput.txt";
		
		ConverterService.convertInputJsonToXml(agr0,arg1);

		//Verify the file contents created at arg1 location
	}

}
