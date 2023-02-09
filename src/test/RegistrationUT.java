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

	/**
	 * TCS_1.1: Registrazione MMG
	 * Il test verifica che il campo "nome" contiene almeno 2 caratteri 
	 */
	@Test
	public void TestName2Caratteri() {
		String nome = "";
		assertEquals(false, validate.validateName(nome));
	}

	/**
	 * TCS_1.2: Registrazione MMG 
	 * Il test verifica che il campo "nome" contiene al massimo 255 caratteri 
	 */
	@Test
	public void TestName255caratteri() {
		String nome = "Pasqualeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		assertEquals(false, validate.validateName(nome));
	}

	/**
	 * TCS_1.3: Registrazione MMG
	 * Il test verifica che il campo "nome" contiene soltanto caratteri alfabetici  
	 */
	@Test
	public void TestNameFormatoCaratteri() {
		String nome = "Pasquale95";
		assertEquals(false, validate.validateName(nome));
	}

	/**
	 * TCS_1.4: Registrazione MMG
	 * Il test verifica che il campo "cognome" contiene almeno 2 caratteri  
	 */
	@Test
	public void TestCognome2Caratteri() {
		String nome = "Pasquale"; 
		String cognome = "";
		assertEquals(false, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
	}

	/**
	 * TCS_1.5: Registrazione MMG
	 * Il test verifica che il campo "cognome" contiene al massimo 255 caratteri   
	 */
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

	/**
	 * TCS_1.6: Registrazione MMG
	 * Il test verifica che il campo "cognome" contiene soltanto caratteri alfabetici   
	 */
	@Test
	public void TestCognomeFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano95";
		assertEquals(false, validate.validateSurname(cognome));
		assertEquals(true, validate.validateName(nome));
	}

	/**
	 * TCS_1.7: Registrazione MMG
	 * Il test verifica che il campo "email" contiene almeno 2 caratteri   
	 */
	@Test
	public void Email2Caratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "";
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(false, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
	}

	/**
	 * TCS_1.8: Registrazione MMG
	 * Il test verifica che il campo "email" contiene al massimo 255 caratteri 
	 */
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

	/**
	 * TCS_1.9: Registrazione MMG 
	 * Il test verifica che il campo "email" rispetta il formato standard di email
	 */
	@Test
	public void TestEmailFormatoCaratteri() {
		String nome = "Pasquale";
		String cognome = "Califano";
		String email = "pasquale*califano@gmail.com";
		assertEquals(true, validate.validateSurname(cognome));
		assertEquals(false, validate.validateEmail(email));
		assertEquals(true, validate.validateName(nome));
	}

	/**
	 * TCS_1.10: Registrazione MMG
	 * Il test verifica che il campo "email" non sia già presente nel database
	 * (utente già registrato)
	 */
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

	/**
	 * TCS_1.11: Registrazione MMG
	 * Il test verifica che il campo "indirizzo" contiene almeno 2 caratteri 
	 */
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

	/**
	 * TCS_1.12: Registrazione MMG 
	 * Il test verifica che il campo "indirizzo" contiene al massimo 255 caratteri
	 */
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

	/**
	 * TCS_1.13: Registrazione MMG
	 * Il test verifica che il campo "indirizzo" contiene soltanto caratteri alfanumerici e spazi
	 */
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

	/**
	 * TCS_1.14: Registrazione MMG 
	 * Il test verifica che il campo "provincia" contiene almeno 2 caratteri
	 */
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

	/**
	 * TCS_1.15: Registrazione MMG
	 * Il test verifica che il campo "provincia" contiene soltanto caratteri alfabetici
	 */
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


	/**
	 * TCS_1.16: Registrazione MMG
	 * Il test verifica che il campo "provincia" contiene al massimo 255 caratteri 
	 */
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

	/**
	 * TCS_1.17: Registrazione MMG
	 * Il test verifica che il campo "comune" contiene almeno 2 caratteri 
	 */
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

	/**
	 * TCS_1.18: Registrazione MMG
	 * Il test verifica che il campo "comune" contiene soltanto caratteri alfabetici 
	 */
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

	/**
	 * TCS_1.19: Registrazione MMG 
	 * Il test verifica che il campo "provincia" contiene al massimo 255 caratteri
	 */
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

	/**
	 * TCS_1.20: Registrazione MMG
	 * Questo test non è stato implementato poichè il sesso viene inserito dall'utente
	 * tramite radio button. Non viene inoltre effettuato il test su valori nulli poichè
	 * il valore è settato di default a 'M'  
	 */
	@Test
	public void TestSesso() {
		//empty
	}

	/**
	 * TCS_1.21: Registrazione MMG
	 * Il test verifica che il campo "telefono" contiene almeno 10 caratteri 
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

	/**
	 * TCS_1.22: Registrazione MMG 
	 * Il test verifica che il campo "telefono" contiene al massimo 11 caratteri
	 */
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

	/**
	 * TCS_1.23: Registrazione MMG 
	 * Il test verifica che il campo "telefono" contiene soltanto caratteri numerici o il carattere '-'
	 */
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

	/**
	 * TCS_1.24: Registrazione MMG
	 * Il test verifica che il campo "password" contiene almeno 8 caratteri 
	 */
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

	/**
	 * TCS_1.25: Registrazione MMG
	 * Il test verifica che il campo "password" contiene al massimo 24 caratteri 
	 */
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

	/**
	 * TCS_1.26: Registrazione MMG
	 * Il test verifica che il campo "password" contiene almeno un carattere alfabetico e un carattere numerico
	 */
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


	/**
	 * TCS_1.27: Registrazione MMG
	 * Questo test non è stato implementato poichè la conferma password viene verificata
	 * tramite controllo nella servlet.
	 */
	@Test
	public void TestConfermaPassword() {
		//empty
	}


	/**
	 * TCS_1.28: Registrazione MMG
	 * Il test verifica che la registrazione sia andata a buon fine
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


