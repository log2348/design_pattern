package strategy;

public class AppendStrategy implements EncodingStrategy {

	@Override
	public String encode(String text) {
		
		return "부트캠프 : " + text;
	}

}
