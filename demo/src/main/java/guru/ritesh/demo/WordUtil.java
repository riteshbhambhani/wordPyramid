package guru.ritesh.demo;

import java.util.regex.Pattern;

public class WordUtil {
		
	public static boolean validateInput(String input) {
		
		if(input.isEmpty()) {
			return false;
		} 
	
		String regex = "[a-zA-Z]+";
		return Pattern.matches(regex, input);
	}

}
