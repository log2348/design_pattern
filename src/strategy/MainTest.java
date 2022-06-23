package strategy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Base64.Decoder;

public class MainTest {
	
	/*
	 * 전략 패턴
	 * 
	 * 인터페이스를 선언
	 * 필요한 클래스들을 그때 그때 꽂아넣는 것
	 * 
	 */
	public static void main(String[] args) {
		
		String text = "http://localhost:9090/user?username=abc";
		
		Base64Strategy base64Strategy = new Base64Strategy();
		NormalStrategy normalStrategy = new NormalStrategy();
		AppendStrategy appendStrategy = new AppendStrategy();
		HttpStrategy httpStrategy = new HttpStrategy();
		
		Encoder encoder = new Encoder();
		encoder.setEncodingStrategy(base64Strategy);
		
		String encodingString = encoder.getMessage(text);
		System.out.println("encodingString : " + encodingString);
		
		// 디코딩 해보기
		try {
			String result = URLDecoder.decode(encodingString, "UTF-8");
			System.out.println("result : " + result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 문제 Base64 디코딩 해보기
		Decoder base64Decoder = Base64.getDecoder();
		String base64DecodingString = new String(base64Decoder.decode(encodingString));
		System.out.println("base64DecodingString : " + base64DecodingString);
		
	}

}
