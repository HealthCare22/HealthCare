package validazione;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFieldsRegistration {

	
	
	private ArrayList<Pattern> pattern =  new ArrayList<>();
	private Matcher matcher;
	
	private static final String EMAIL_REGEX = "^(?!.{256,})[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
	private static final String NOME_REGEX = "^[a-z A-Z àéèìòù]{2,255}$";
	private static final String SURNAME_REGEX ="^[a-z A-Z àéèìòù]{2,255}$";
	private static final String PASSWORD_REGEX = "^(?=([^\\s])*[0-9])(?=([^\\s])*[a-zA-Z])([^\\s]){8,24}$";
	private static final String PROVINCIA_REGEX = "^[a-z A-Z àéèìòù]{2,255}$";
	private static final String COMUNE_REGEX = "^[a-z A-Z àéèìòù]{2,255}$";
	private static final String INDIRIZZO_REGEX = "^[a-z A-Z 0-9 àéèìòù',.-]{2,255}$";
	private static final String NUMEROTELEFONO_REGEX = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
	
	public ValidateFieldsRegistration() {
		pattern.add(Pattern.compile(EMAIL_REGEX));
		pattern.add( Pattern.compile(NOME_REGEX));
		pattern.add(Pattern.compile(SURNAME_REGEX));
		pattern.add(Pattern.compile(PASSWORD_REGEX));
		pattern.add(Pattern.compile(PROVINCIA_REGEX));
		pattern.add(Pattern.compile(COMUNE_REGEX));
		pattern.add(Pattern.compile(INDIRIZZO_REGEX));
		pattern.add(Pattern.compile(NUMEROTELEFONO_REGEX));
	}
	
	
	
	public boolean validateEmail(final String email) {
		
		
		matcher = pattern.get(0).matcher(email);
	
		return matcher.matches();
	}
	
	public boolean validateName(final String name) {
		matcher = pattern.get(1).matcher(name);
		return matcher.matches();
	}
	
	public boolean validateSurname(final String surname) {
		matcher = pattern.get(2).matcher(surname);
		return matcher.matches();
	}
	
	public boolean validatePassword(final String password) {
		matcher = pattern.get(3).matcher(password);
		return matcher.matches();
	}
	
	public boolean validateProvincia(final String provincia) {
		matcher = pattern.get(4).matcher(provincia);
		return matcher.matches();
	}
	
	public boolean validateComune(final String comune) {
		matcher = pattern.get(5).matcher(comune);
		return matcher.matches();
	}
	
	public boolean validateIndirizzo(final String indirizzo) {
		matcher = pattern.get(6).matcher(indirizzo);
		return matcher.matches();
	}
	
	public boolean validateNumeroTelefono(final String numeroTelefono) {
		matcher = pattern.get(7).matcher(numeroTelefono);
		return matcher.matches();
	}
	
	
}
