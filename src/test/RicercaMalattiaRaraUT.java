package test;

import static org.junit.Assert.assertEquals;   

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import gestioneMalattie.MalattiaDAO;
import validazione.ValidateFieldsRicercaMalattiaRaraNome;

public class RicercaMalattiaRaraUT extends Mockito{

	static ValidateFieldsRicercaMalattiaRaraNome validate;

	@BeforeClass
	public static void setup() {
		validate = new ValidateFieldsRicercaMalattiaRaraNome();
	}

	/**
	 * TCS_18.1 Ricerca di una MR
	 * Il test verifica che il nome della malattia abbia almeno 2 caratteri
	 */
	@Test
	public void TestNomeMinimo2Caratteri() {
		String name = "";
		assertEquals(false, validate.validateName(name));

	}
	
	/**
	 * TCS_18.2 Ricerca di una MR
	 * Il test verifica che il nome della malattia abbia al massimo 40 caratteri
	 */
	@Test
	public void TestNomeMassimo40Caratteri() {
		String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateName(name));
	}

	/**
	 * TCS_18.3 Ricerca di una MR
	 * Il test verifica che la malattia esista nel database
	 */
	@Test
	public void TestNomeMalattiaGiaEsistente() {
		String name = "aaaaaaaa";
		MalattiaDAO md = (MalattiaDAO)Mockito.mock(MalattiaDAO.class);
		when(md.existMalattia(name)).thenReturn(true);
		assertEquals(true, validate.validateName(name));
	}
	
	/**
	 * TCS_18.4 Ricerca di una MR
	 * Il test verifica che la ricerca vada a buon fine
	 */
	@Test
	public void TestMalattiaCorretta() {
		String name = "Progeria";
		MalattiaDAO md = (MalattiaDAO)Mockito.mock(MalattiaDAO.class);
		when(md.existMalattia(name)).thenReturn(false);
		assertEquals(true, validate.validateName(name));
	}
}
