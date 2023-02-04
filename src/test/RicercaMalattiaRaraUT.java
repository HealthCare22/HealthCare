package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import DAO.MalattiaDAO;
import validazione.ValidateFieldsRicercaMalattiaRaraNome;

public class RicercaMalattiaRaraUT extends Mockito{
	
	static ValidateFieldsRicercaMalattiaRaraNome validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsRicercaMalattiaRaraNome();
	 }
	 
	 
	@Test
	public void TestNomeMinimo2Caratteri() {
		
		String name = "";
		assertEquals(false, validate.validateName(name));
		
	}
	
	@Test
	public void TestNomeMassimo40Caratteri() {
		String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateName(name));
	}
	
	@Test
	public void TestNomeMalattiaGiaEsistente() {
		
		String name = "aaaaaaaa";
		MalattiaDAO md = (MalattiaDAO)Mockito.mock(MalattiaDAO.class);
		
		when(md.existMalattia(name)).thenReturn(true);
		
		assertEquals(true, validate.validateName(name));
		
	}

}
