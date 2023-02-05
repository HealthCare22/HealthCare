package test;

import static org.junit.Assert.assertEquals; 
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import utenza.UserDAO;
import validazione.ValidateFieldsRegistration;



 public class RegistrationUT extends Mockito {
	
	 static ValidateFieldsRegistration validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsRegistration();
	 }
	 
	@Test
	public void TestName2Caratteri() {
		
		String nome = "";
		assertEquals(false, validate.validateName(nome));
		
	}
 
	@Test
	public void TestName255caratteri() {
		
		String nome = "Pasqualeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		
		assertEquals(false, validate.validateName(nome));
		
	}
	
	@Test
	public void TestNameFormatoCaratteri() {
		
		String nome = "Pasquale95";
		assertEquals(false, validate.validateName(nome));
		
	}
	
	
	@Test
	public void TestCognome2Caratteri() {
		
		String nome = "Pasquale"; 
		String cognome = "";
		
		assertEquals(false, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
	}
	
	
	@Test
	public void TestCognome255Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califanooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooo";
		
		assertEquals(false, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
	}

	@Test
	public void TestCognomeFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano95";
		assertEquals(false, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
	}
	
	@Test
	public void Email2Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "";
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(false, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
	}
	
	@Test
	public void Email255Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifanooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooo@gmail.com";
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(false, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
	}
	
	@Test
	public void TestEmailFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasquale*califano@gmail.com";
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(false, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
	}
	
	@Test
	public void TestEmailGiaEsistente() {
		
		UserDAO ud = Mockito.mock(UserDAO.class);
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		
		when(ud.existEmail(email)).thenReturn(true);
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
		
	}
	
	@Test
	public void TestIndirizzo2Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
		
	}
	
	@Test
	public void TestIndirizzo255Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
	}
	
	@Test
	public void TestIndirizzoFormatoCaratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro ## Fimiani";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
	}
	
	@Test
	public void TestProvincia2Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestProvincia255Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "Salernoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestProvinciaFormatoCaratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA#";
		
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestComune2Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
	}

	@Test
	public void TestComune255Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgioooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
		
	}
	
	@Test
	public void TestComuneFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel#@SanGiorgio";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
	}
	
	/*
	 * Non abbiamo previsto un Test sul sesso, poichè esso verrà settato tramite una Radio nella jsp (Scriverlo meglio)
	 * 
	 * 
	 */
	
	@Test
	public void TestTelefonoAlmeno10Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
		
	}
	
	@Test
	public void TestTelefonoMassimo11Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-333455321897";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
	}
	
	@Test
	public void TestTelefonoFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-22BB451";
		
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
	}
	
	
	@Test
	public void TestPasswordMinimo8Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
		
	}
	
	@Test
	public void TestPasswordMassimo24Caratteri() {
		
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippoplutopaperino  ooooo";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
	}
	
	@Test
	public void TestPasswordFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippopluto paperino";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
	}
	
	/*
	 * Chiedere per la conferma password come fare
	 * 
	 * 
	 */

	@Test
	public void TestRegistrazioneCorretto() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippopluto45";
		
		assertEquals(true, validate.validateName(nome));
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
	}

	

	
}


