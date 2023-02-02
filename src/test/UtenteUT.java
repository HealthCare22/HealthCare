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



 public class UtenteUT extends Mockito {
	
	UserDAO userMock;
	FormDAO formMock;
	
	
	
	
	String nome;
	String cognome;
	String email;
	String indirizzo;
	String provincia;
	String comune;
	String sesso;
	String telefono;
	String password;
	
	
	//Verifica che il campo nome non sia null
	@Test
	public void testRegistration() {
		
		userMock = (UserDAO) Mockito.mock(UserDAO.class);
		nome = null;
		cognome = "Califano";
		email = "pasqualecalifano@gmail.com";
		indirizzo = "Via Dottor Pietro Fimiani";
		provincia = "SA";
		comune = "Castel San Giorgio";
		sesso = "M";
		telefono = "3333454562";
		password = "pippo";

		when(userMock.appendUserInDb(nome, cognome, sesso, password, email, provincia, comune, indirizzo, telefono)).thenReturn(true);
		
		final String message = "Il campo Nome deve contenere almeno 2 caratteri";
		
		
		
	}
	

	
}

