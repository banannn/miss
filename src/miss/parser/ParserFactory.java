package miss.parser;

public class ParserFactory {

	public static Parser createJsonParser() {
		return new JSONParser();
	}

	public static Parser createXmlParser() {
		return new XMLParser();
	}
	
}
