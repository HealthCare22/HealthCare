package validazione;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFieldsInserimentoSintomi {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String SINTOMO_REGEX ="^[\\p{L}\\s]{3,50}$";


	
	public ValidateFieldsInserimentoSintomi() {
		pattern = Pattern.compile(SINTOMO_REGEX);
	}
	
	
	public boolean validateSintomo(final String sintomo) {
		matcher = pattern.matcher(sintomo);
		return matcher.matches();
	}
}
