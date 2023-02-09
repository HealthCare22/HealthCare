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

	/**
	 * TCS_5.1 Apertura di un Form da parte di un MMG
	 * Il test verifica che il titolo abbia almeno 2 caratteri
	 */
	@Test
	public void TestTitoloMinimo2Caratteri() {
		String titolo = "";
		assertEquals(false, validate.validateTitolo(titolo));
	}
	
	/**
	 * TCS_5.2 Apertura di un Form da parte di un MMG
	 * Il test verifica che il titolo abbia al massimo 255 caratteri
	 */
	@Test
	public void TestTitoloMassimo255Caratteri() {
		String titolo = "Emorragiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateTitolo(titolo));
	}
	
	/**
	 * TCS_5.3 Apertura di un Form da parte di un MMG
	 * Il test verifica che il titolo sia formato solo da caratteri alfabetici
	 */
	@Test
	public void TestTitoloFormatoCaratteri() {
		String titolo = "Emorragia*95";
		assertEquals(false, validate.validateTitolo(titolo));
	}
	
	/**
	 * TCS_5.4 Apertura di un Form da parte di un MMG
	 * Il test verifica che la descrizione abbia almeno 2 caratteri
	 */
	@Test
	public void TestDescrizioneMinimo2Caratteri() {
		String titolo = "Delucidazioni su paziente epilettico";
		String descrizione = "";
		assertEquals(true, validate.validateTitolo(titolo));
		assertEquals(false, validate.validateDescrizione(descrizione));
	}
	
	/**
	 * TCS_5.5 Apertura di un Form da parte di un MMG
	 * Il test verifica che il titolo abbia al massimo 800 caratteri
	 */
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

	/**
	 * TCS_5.6 Apertura di un Form da parte di un MMG
	 * Il test verifica che l'apertura è andata a buon fine
	 */
	@Test
	public void TestAperturaFormCorretto() {
		String titolo = "Delucidazioni su paziente epilettico";
		String descrizione = "Ho un dubbio riguardo un mio paziente affetto da epilessia";
		assertEquals(true, validate.validateTitolo(titolo));
		assertEquals(true, validate.validateDescrizione(descrizione));
	}
}
