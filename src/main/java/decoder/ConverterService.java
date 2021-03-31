package decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterService {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Input Arguments Mismatch , expected arguments - 2");
			System.exit(-1);
		}

		String arg0 = args[0];
		String arg1 = args[1];

		convertInputJsonToXml(arg0, arg1);
	}

	public static void convertInputJsonToXml(String arg0, String arg1) {
		ConveterFactory converterFactory = new ConveterFactory();
		String content = null;
		String xmlOutput = null;

		ClassLoader classLoader = ConverterService.class.getClassLoader();

		File file = new File(classLoader.getResource(arg0).getFile());

		try {
			// Read Json File Content
			content = new String(Files.readAllBytes(file.toPath()));

			// Convert Json to XML
			XMLJSONConverterI xmlJSONConverterI = converterFactory.convertToXML(content);
			xmlOutput = xmlJSONConverterI.XMLJSONConverter(content);

			// Create new file to write XML content
			Path newFilePath = Paths.get(arg1);
			Files.createFile(newFilePath);

			// Write the actual XML content
			OutputStream os = new FileOutputStream(arg1);
			final PrintStream printStream = new PrintStream(os);
			printStream.println(xmlOutput);
			printStream.close();
			// The reason to write the message in catch block is the readAllBytes method
			// can't handle the special characters, but that doesn't effect my API to
			// convert
			// to XML
		} catch (Exception e) {
			System.out.println("Please check the XML output at " + arg1);
		}
	}

}
