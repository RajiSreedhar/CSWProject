package decoder;

public class ConveterFactory {

	public XMLJSONConverterImpl convertToXML(String jsonString) {

		if (jsonString == null || jsonString.isEmpty()) {
			return null;
		}

		else {
			return new XMLJSONConverterImpl();
		}
	}

}
