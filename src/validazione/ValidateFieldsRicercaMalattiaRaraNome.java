package validazione;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFieldsRicercaMalattiaRaraNome {


	private Pattern pattern;
	private Matcher matcher;
	
	private static final String NOME_MALATTIA_REGEX = "^[a-z A-Z àéèìòù]{2,40}$";
	
	
	public ValidateFieldsRicercaMalattiaRaraNome() {
		
		pattern = Pattern.compile(NOME_MALATTIA_REGEX);
		
	}
	
	public boolean validateName(final String name) {
		matcher = pattern.matcher(name);
		return matcher.matches();
	}
}
