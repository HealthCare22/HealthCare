package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


import validazione.ValidateFieldsinserimentoInUnForm;

public class InserimentoInUnFormUT extends Mockito {

	static ValidateFieldsinserimentoInUnForm validate;
	 
	 @BeforeClass
	 public static void setup() {
		  validate = new ValidateFieldsinserimentoInUnForm();
	 }
	 
	@Test
	public void TestDescrizioneMinimo2Caratteri() {
		
		String descrizione = "";
		assertEquals(false, validate.validateDescrizione(descrizione));
		
	}
	
	@Test
	public void TestDescrizioneMassimo800Caratteri() {
		String descrizione = "Inerente alla patologia da lei descrittaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		assertEquals(false, validate.validateDescrizione(descrizione));
	}
	
	@Test
	public void TestDescrizioneCorretto() {
		
		String descrizione ="Inerente alla patologia da lei descritta, non so dirle come trattarla "
				+ "in quanto và oltre la mia esperienza professionale. Posso indirizzarla,però, dal "
				+ "mio collega, Dott. Giorgio Medugno di Salerno, il quale saprà sicuramente aiutarla.";
		
		assertEquals(true, validate.validateDescrizione(descrizione));
	}

}
