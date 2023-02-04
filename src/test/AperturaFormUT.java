package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import validazione.ValidateFieldsAperturaForm;



public class AperturaFormUT extends Mockito {


	 static ValidateFieldsAperturaForm validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsAperturaForm();
	 }
	 
	 
	@Test
	public void TestTitoloMinimo2Caratteri() {
		
		String titolo = "";
		assertEquals(false, validate.validateTitolo(titolo));
		
	}
	
	@Test
	public void TestTitoloMassimo255Caratteri() {
		String titolo = "Emorragiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateTitolo(titolo));
	}
	
	@Test
	public void TestTitoloFormatoCaratteri() {
		
		String titolo = "Emorragia*95";
		assertEquals(false, validate.validateTitolo(titolo));
	}
	
	
	@Test
	public void TestDescrizioneMinimo2Caratteri() {
		String titolo = "Delucidazioni su paziente epilettico";
		String descrizione = "";
		
		assertEquals(true, validate.validateTitolo(titolo));
		assertEquals(false, validate.validateDescrizione(descrizione));
		
	}
	
	@Test
	public void TestDescrizioneMassimo800Caratteri() {
		String titolo = "Delucidazioni su paziente epilettico";
		String descrizione = "Ho un dubbio riguardo un mio paziente affetto da epilessiaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		assertEquals(true, validate.validateTitolo(titolo));
		assertEquals(false, validate.validateDescrizione(descrizione));
	}
	
	
	@Test
	public void TestAperturaFormCorretto() {
		String titolo = "Delucidazioni su paziente epilettico";
		String descrizione = "Ho un dubbio riguardo un mio paziente affetto da epilessia";
		
		assertEquals(true, validate.validateTitolo(titolo));
		assertEquals(true, validate.validateDescrizione(descrizione));
	}
	

}
