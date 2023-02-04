package validazione;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFieldsinserimentoInUnForm {

	private Pattern pattern;
	private Matcher matcher;
	
private static final String DESCRIZIONE_REGEX = "^[\\p{L}0-9\\s\\w\\d\\,\\.\\?\\!:-]{2,800}$";

	
	public ValidateFieldsinserimentoInUnForm() {
		pattern = Pattern.compile(DESCRIZIONE_REGEX);
	}
	
	
	public boolean validateDescrizione(final String descrizione) {
		matcher = pattern.matcher(descrizione);
		return matcher.matches();
	}
}
