package decoder;

import com.github.underscore.lodash.U;

public class XMLJSONConverterImpl implements XMLJSONConverterI {

	// This method will convert Json string to XML string
	public String XMLJSONConverter(String jsonInputString) {
		return U.jsonToXml(jsonInputString);
	}

}
