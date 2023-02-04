package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import DAO.UserDAO;
import validazione.ValidateFieldsModificaDatiAnagrafici;


public class ModificaDatiAnagraficiUT extends Mockito{

	 static ValidateFieldsModificaDatiAnagrafici validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsModificaDatiAnagrafici ();
	 }
	 
	@Test
	public void Email2Caratteri() {
		
	
		String email = "";
		
		assertEquals(false, validate.validateEmail(email));
		
	}
	
	@Test
	public void Email255Caratteri() {
	
		String email = "pasqualecalifanooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooo@gmail.com";
	
		assertEquals(false, validate.validateEmail(email));
		
	}
	
	@Test
	public void TestEmailFormatoCaratteri() {
	
		String email = "pasquale*califano@gmail.com";
		assertEquals(false, validate.validateEmail(email));
	}
	
	@Test
	public void TestEmailGiaEsistente() {
		
		UserDAO ud = Mockito.mock(UserDAO.class);
		String email = "pasqualecalifano@gmail.com";
		
		when(ud.existEmail(email)).thenReturn(true);
		

		
	}
	
	@Test
	public void TestIndirizzo2Caratteri() {
		
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "";
		
	
		assertEquals(true, validate.validateEmail(email));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
		
	}
	
	@Test
	public void TestIndirizzo255Caratteri() {
		
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
		
	
		assertEquals(true, validate.validateEmail(email));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
	}
	
	@Test
	public void TestIndirizzoFormatoCaratteri() {
		
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro ## Fimiani";
		
	
		assertEquals(true, validate.validateEmail(email));
		assertEquals(false, validate.validateIndirizzo(indirizzo));
	}
	
	@Test
	public void TestProvincia2Caratteri() {
		
	
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "";
		
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestProvincia255Caratteri() {
	
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "Salernoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo";
		
		
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestProvinciaFormatoCaratteri() {
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA#";
		
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(false, validate.validateProvincia(provincia));
	}
	
	@Test
	public void TestComune2Caratteri() {

		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "";
		
		
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
	}

	@Test
	public void TestComune255Caratteri() {
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgioooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
		

		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(false, validate.validateComune(comune));
		
	}
	
	@Test
	public void TestComuneFormatoCaratteri() {
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel#@SanGiorgio";
		
	
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
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "";
		
	
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
		
	}
	
	@Test
	public void TestTelefonoMassimo11Caratteri() {
		
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-333455321897";
		
		
		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
	}
	
	@Test
	public void TestTelefonoFormatoCaratteri() {
	
		String email = "pasqualecalifano@gmail.com";
		String indirizzo = "Via Dottor Pietro Fimiani";
		String provincia = "SA";
		String comune = "Castel San Giorgio";
		String telefono = "333-22BB451";
		
		

		assertEquals(true, validate.validateEmail(email));
		assertEquals(true, validate.validateIndirizzo(indirizzo));
		assertEquals(true, validate.validateProvincia(provincia));
		assertEquals(true, validate.validateComune(comune));
		assertEquals(false, validate.validateNumeroTelefono(telefono));
	}
	
	
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
	
	/*
	 * Chiedere per la conferma password come fare
	 * 
	 * 
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


