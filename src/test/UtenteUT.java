package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import Beans.GestioneFormBean;
import Beans.MMGBean;
import DAO.FormDAO;
import DAO.UserDAO;
import validazione.ValidateFields;



 public class UtenteUT extends Mockito {
	
	UserDAO userMock;
	FormDAO formMock;
	
	@InjectMocks
	ValidateFields validate;
	
	@Mock
	UserDAO user;
	
	
	boolean nome;
	boolean cognome;
	boolean email;
	boolean indirizzo;
	boolean provincia;
	boolean comune;
	String sesso;
	boolean telefono;
	boolean password;
	

	//Verifica che il campo nome non sia null
	@Test
	public void validaNomeNull() {
		
		boolean verify = true;
		nome = validate.validateName(null);
		cognome = validate.validateSurname("Califano");
		email = validate.validateEmail("pasqualecalifano@gmail.com");
		indirizzo = validate.validateIndirizzo("Via Dottor Pietro Fimiani");
		provincia = validate.validateProvincia("SA");
		comune = validate.validateComune("Castel San Giorgio");
		sesso = "M";
		telefono = validate.validateNumeroTelefono("3492490930");
		password = validate.validatePassword("pippo");
		

		
	
		
	
		
	}
	

	
}


