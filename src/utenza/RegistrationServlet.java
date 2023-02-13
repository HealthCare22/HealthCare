package utenza;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validazione.ValidateFieldsRegistration;

import com.mongodb.client.MongoClient;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("name");
        String cognome = request.getParameter("surname");
        String sesso = request.getParameter("gender");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirmEmail");
        String provincia = request.getParameter("provincia");
        String comune = request.getParameter("comune");
        String indirizzo = request.getParameter("indirizzo");
        String numero_telefono = request.getParameter("numero_telefono");
        boolean checked = true;

        MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
        UserFacade userFacade = new UserFacade(mongoClient);
        ValidateFieldsRegistration validate = new ValidateFieldsRegistration();
        
        
        // EMAIL VALIDATION
        if(userFacade.existEmail(email)) {
        	request.setAttribute("error_message", "l'email inserita è gia presente nel database");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
        }
		if(email.length()>255) {
			request.setAttribute("error_message", "Il campo Email deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(email.length()<2) {
			request.setAttribute("error_message", "Il campo Email deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
        if(!email.equals(confirmEmail)) {
			
			request.setAttribute("error_message", "l'email non corrisponde");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
        }
		if(!validate.validateEmail(email)) {

			request.setAttribute("error_message", "Il campo Email non rispetta il formato stabilito");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
			
		}
		
        
        
        //NOME VALIDATION 
        if(nome.length()< 2) {
        	   
       		request.setAttribute("error_message", "Il campo Nome deve contenere almeno 2 caratteri");
    		request.getRequestDispatcher("/registration.jsp").forward(request, response);
    		checked = false;
    		
        }
        
       if(nome.length() > 255) {
    	   
   		request.setAttribute("error_message", "Il campo Nome deve contenere al massimo 255 caratteri");
		request.getRequestDispatcher("/registration.jsp").forward(request, response);
		checked = false;
       }
		if(!validate.validateName(nome)) {
			request.setAttribute("error_message", "Il campo Nome deve contenere solo caratteri alfabetici o spazi");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
    
        //COGNOME VALIDATION
        
        if(cognome.length()<2) {
        	request.setAttribute("error_message", "Il campo cognome deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
        }
       if(cognome.length()> 255) {
    	   request.setAttribute("error_message", "Il campo cognome deve contenere massimo 255 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
       }
		if(!validate.validateSurname(cognome)) {
			request.setAttribute("error_message", "Il campo Cognome deve contenere soltanto caratteri alfabetici o spazi");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}

        //PASSWORD VALIDATOR

		if(!password.equals(confirmPassword)) {
			request.setAttribute("error_message", "Il campo Conferma Password non corrisponde al campo Password");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(password.length()<8) {
			request.setAttribute("error_message", "Il campo Password deve contenere almeno 8 caratteri, almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(password.length()>24) {
			request.setAttribute("error_message", "Il campo Password deve contenere al massimo 24 caratteri,almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(!validate.validatePassword(password)) {
			request.setAttribute("error_message", "Il campo Password deve contenere almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
	
		
		
		//PROVINCIA VALIDATOR
		if(provincia.length()<2) {
			request.setAttribute("error_message", "Il campo Provincia deve contenere minimo 2 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(provincia.length()>255) {
			request.setAttribute("error_message", "Il campo Provincia deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(!validate.validateProvincia(provincia)) {
			request.setAttribute("error_message", "Il campo Provincia deve contenere minimo 2 caratteri e non sono ammessi caratteri speciali");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		
		
		
		//COMUNE VALIDATOR
		if(comune.length()<2) {
			request.setAttribute("error_message", "Il campo Comune deve contenere almeno 2 caratteri e non deve essere vuoto");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(comune.length()>255) {
			request.setAttribute("error_message", "Il campo Comune deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(!validate.validateComune(comune)) {
			request.setAttribute("error_message", "Il campo Comune deve contenere almeno 2 caratteri e non deve presentare caratteri speciali");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		
		
		//INDIRIZZO VALIDATOR
		if(indirizzo.length()< 2) {
			request.setAttribute("error_message", "Il campo indirizzo deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		
		if(indirizzo.length()>255) {
			request.setAttribute("error_message", "Il campo indirizzo deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(!validate.validateIndirizzo(indirizzo)) {
			request.setAttribute("error_message", "Il campo indirizzo deve contenere soltanto caratteri alfanumerici");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
	
		
		//NUMERO DI TELEFONO VALIDATOR
		if(numero_telefono.length()<10) {
			request.setAttribute("error_message", "Il campo Telefono deve contenere almeno 10 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(numero_telefono.length()>11) {
			request.setAttribute("error_message", "Il campo Telefono deve contenere al massimo 11 caratteri");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}
		if(!validate.validateNumeroTelefono(numero_telefono)) {
			request.setAttribute("error_message", "“Il campo Telefono deve contenere solo caratteri numerici, al più le prime 3 cifre possono essere separate da un trattino");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			checked = false;
		}

        // Checking for null and empty values
        if (nome == null || cognome == null || sesso == null || password == null ||
                email == null || provincia == null || comune == null || indirizzo == null ||
                numero_telefono == null || "".equals(nome) || "".equals(cognome)
                || "".equals(sesso) || "".equals(password) || "".equals(email)
                || "".equals(provincia) || "".equals(comune) || "".equals(indirizzo) || "".equals(numero_telefono)) {
           
            request.setAttribute("error_message", "Please fill the registration form");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } else if(checked){
            
            boolean isUserFound = userFacade.registerUser(nome, cognome, sesso, UserDAO.encrypt(password), email,
                    provincia, comune, indirizzo, numero_telefono);

            if (isUserFound) {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}

