package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import validazione.ValidateFieldsInserimentoSintomi;

public class RicercaMalattiaRaraSintomiUT extends Mockito {


	 static ValidateFieldsInserimentoSintomi validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsInserimentoSintomi();
	 }
	 
	@Test
	public void TestSintomiMinimo2Caratteri() {
		
		String sintomo = "";
		assertEquals(false, validate.validateSintomo(sintomo));
		
	}
	
	@Test
	public void TestSintomiMassimo50Caratteri() {
		String sintomo = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertEquals(false, validate.validateSintomo(sintomo));
	}
	
	@Test
	public void TestSintomiCorrretto() {
		String sintomo ="diarrea";
		
		assertEquals(true, validate.validateSintomo(sintomo));
				
	}
	

}
