package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import utenza.UserDAO;
import validazione.ValidateFieldsModificaDatiAnagrafici;


public class ModificaDatiAnagraficiUT extends Mockito{

	static ValidateFieldsModificaDatiAnagrafici validate;

	@BeforeClass
	public static void setup() {
		validate = new ValidateFieldsModificaDatiAnagrafici ();
	}

	/**
	 * TCS_4.1 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova mail abbia almeno 2 caratteri
	 */
	@Test
	public void Email2Caratteri() {
		String email = "";
		String indirizzo = "Via Dotto Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(false, validate.validateEmail(email));
	}

	/**
	 * TCS_4.2 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova mail abbia al massimo 255 caratteri
	 */
	@Test
	public void Email255Caratteri() {

		String email = "pasqualecalifanooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooo@gmail.com";
		String indirizzo = "Via Dotto Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(false, validate.validateEmail(email));

	}

	/**
	 * TCS_4.3 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova mail rispetti il formato standard di email
	 */
	@Test
	public void TestEmailFormatoCaratteri() {
		String email = "pasquale*califano@gmail.com";
		String indirizzo = "Via Dotto Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(false, validate.validateEmail(email));
	}

	/**
	 * TCS_4.4 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova mail non sia già registrata
	 */
	@Test
	public void TestEmailGiaEsistente() {
		UserDAO ud = Mockito.mock(UserDAO.class);
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dotto Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		when(ud.existEmail(email)).thenReturn(true);
	}

	/**
	 * TCS_4.5 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo indirizzo abbia almeno 2 caratteri
	 */
	@Test
	public void TestIndirizzo2Caratteri() {
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(false, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.6 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo indirizzo abbia al più 255 caratteri
	 */
	@Test
	public void TestIndirizzo255Caratteri() {
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(false, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.7 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo indirizzo contenga soltanto caratteri alfanumerici
	 */
	@Test
	public void TestIndirizzoFormatoCaratteri() {
		String indirizzo = "Via Dottor Pietro ## Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(false, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.8 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova provincia abbia almeno 2 caratteri
	 */
	@Test
	public void TestProvincia2Caratteri() {
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}
	
	/**
	 * TCS_4.9 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova provincia contenga soltanto caratteri alfabetici
	 */
	@Test
	public void TestProvinciaFormatoCaratteri() {
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA#";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.10 Modifica dati anagrafici del MMG
	 * Il test verifica che la nuova provincia abbia al più 255 caratteri
	 */
	@Test
	public void TestProvincia255Caratteri() {
		String provincia = "Salernoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String comune = "Castel San Giorgio";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.11 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo comune abbia almeno 2 caratteri
	 */
	@Test
	public void TestComune2Caratteri() {
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String comune = "";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}
	
	/**
	 * TCS_4.12 Modifica dati anagrafici del MMG
	 * Il test verifica che il comune contenga solo caratteri alfabetici
	 */
	@Test
	public void TestComuneFormatoCaratteri() {
		String comune = "Castel#@SanGiorgio";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.13 Modifica dati anagrafici del MMG
	 * Il test che verifica che il comune abbia al più 255 caratteri
	 */
	@Test
	public void TestComune255Caratteri() {
		String comune = "Castel San Giorgioooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";		
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String telefono = "3312435870";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.14 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo numero di telefono abbia almeno 10 caratteri
	 */
	@Test
	public void TestTelefonoAlmeno10Caratteri() {
		String comune = "Castel San Giorgio";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String telefono = "";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}

	/**
	 * TCS_4.15 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo numero di telefono abbia al massimo 11 caratteri
	 */
	@Test
	public void TestTelefonoMassimo11Caratteri() {
		String telefono = "333-333455321897";
		String comune = "Castel San Giorgio";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));
	}
	
	/**
	 * TCS_4.16 Modifica dati anagrafici del MMG
	 * Il test verifica che il nuovo numero di telefono contenga soltanto caratteri numerici
	 */
	@Test
	public void TestTelefonoFormatoCaratteri() {
		String telefono = "333-22BB451";
		String comune = "Castel San Giorgio";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String email = "pasqualecalifano@gmail.com";
		String provincia = "SA";
		String password = "pippopluto1";
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
		assertEquals(true, validate.validateEmail(email));	
		}
	
	/**
	 * TCS_4.17 Modifica dati anagrafici del MMG
	 * Il test verifica che la password contenga almeno 8 caratteri
	 */
	@Test
	public void TestPasswordMinimo8Caratteri() {
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "";
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
	}
	
	/**
	 * TCS_4.18 Modifica dati anagrafici del MMG
	 * Il test verifica che la password contenga al più 24 caratteri
	 */
	@Test
	public void TestPasswordMassimo24Caratteri() {
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippoplutopaperino  ooooo";
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
	}

	/**
	 * TCS_4.19 Modifica dati anagrafici del MMG
	 * Il test verifica che la password contenga almeno una lettera, un numero e nessuno spazio
	 */
	@Test
	public void TestPasswordFormatoCaratteri() {

		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippopluto paperino";
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(false, validate.validatePassword(password));
	}
	
	/**
	 * TCS_4.20: Registrazione MMG
	 * Questo test non è stato implementato poichè la conferma password viene verificata
	 * tramite controllo nella servlet.
	 */
	@Test
	public void TestConfermaPassword() {
		//empty
	}
	
	/**
	 * TCS_4.21: Registrazione MMG
	 * Il test verifica che la registrazione sia andata a buon fine
	 */
	@Test
	public void TestRegistrazioneCorretto() {
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-3454562";
		String password = "pippopluto45";
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(true, validate.validateNumeroTelefono(telefono));
		assertEquals(true, validate.validatePassword(password));
	}
}


