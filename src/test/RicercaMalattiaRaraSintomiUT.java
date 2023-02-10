package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import gestioneMalattie.SintomoDAO;
import utenza.UserDAO;
import validazione.ValidateFieldsInserimentoSintomi;

public class RicercaMalattiaRaraSintomiUT extends Mockito {

	static ValidateFieldsInserimentoSintomi validate;

	@BeforeClass
	public static void setup() {
		validate = new ValidateFieldsInserimentoSintomi();
	}

	/**
	 * TCS_17.1 Inserimento sintomi del paziente e individuazione di una MR
	 * Il test verifica che ogni sintomo abbia almeno 2 caratteri
	 */
	@Test
	public void TestSintomiMinimo2Caratteri() {
		String sintomo = "";
		assertEquals(false, validate.validateSintomo(sintomo));
	}

	/**
	 * TCS_17.2 Inserimento sintomi del paziente e individuazione di una MR
	 * Il test verifica che ogni sintomo abbia al massimo 50 caratteri
	 */
	@Test
	public void TestSintomiMassimo50Caratteri() {
		String sintomo = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateSintomo(sintomo));
	}
	
	/**
	 * TCS_17.3 Inserimento sintomi del paziente e individuazione di una MR
	 * Il test verifica che la ricerca vada a buon fine ma che non mostri nessun risultato
	 */
	@Test
	public void TestSintomiCorrettoNessunaCorrispondenza() {
		String sintomo = "aaaaaaaaaaaaaaaa";
		assertEquals(true, validate.validateSintomo(sintomo));
	}

	/**
	 * TCS_17.4 Inserimento sintomi del paziente e individuazione di una MR
	 * Il test verifica che la ricerca vada a buon fine
	 */
	@Test
	public void TestSintomiCorretto() {
		String sintomo ="diarrea";
		assertEquals(true, validate.validateSintomo(sintomo));
	}
	
	@Test
	public void TestSintomiUnoCorrettoUnoNonPresenteNelDb() {
		String sintomo = "diarrea";
		String sintomo2 = "aaaaaaaaa";
		
		SintomoDAO sd = Mockito.mock(SintomoDAO.class);
		when(sd.existSintomo(sintomo2)).thenReturn(true);
		assertEquals(true, validate.validateSintomo(sintomo));
		assertEquals(true, validate.validateSintomo(sintomo2));
	}
}
