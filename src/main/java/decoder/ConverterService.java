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

		String agr0 = args[0];
		String arg1 = args[1];
		
		if (args.length != 2) {
			System.out.println("Input Arguments Mismatch , expected arguments - 2");
			System.exit(-1);
		}
		
		convertInputJsonToXml(agr0, arg1);
	}

	public static void convertInputJsonToXml(String agr0, String arg1) {
		ConveterFactory converterFactory = new ConveterFactory();
		String content = null;
		String xmlOutput = null;

		ClassLoader classLoader = ConverterService.class.getClassLoader();

		File file = new File(classLoader.getResource(agr0).getFile());

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

		} catch (Exception e) {
			System.out.println("Cannot convert the given Json to XML");
		}
	}

}
