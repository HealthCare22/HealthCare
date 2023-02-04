package validazione;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFieldsAperturaForm {

	private ArrayList<Pattern> pattern =  new ArrayList<>();
	private Matcher matcher;
	
	private static final String TITOLO_REGEX = "^[a-z A-Z àéèìòù]{2,255}$";
	private static final String DESCRIZIONE_REGEX = "^[a-z A-Z àéèìòù]{2,800}$";
	
	
	public ValidateFieldsAperturaForm() {
		pattern.add(Pattern.compile(TITOLO_REGEX));
		pattern.add( Pattern.compile(DESCRIZIONE_REGEX));

	}
	
	
	public boolean validateTitolo(final String titolo) {
		matcher = pattern.get(0).matcher(titolo);
		
		return matcher.matches();
	}
	
	public boolean validateDescrizione(final String descrizione) {
		matcher = pattern.get(1).matcher(descrizione);
		
		return matcher.matches();
	}
	
	
	
	
}
