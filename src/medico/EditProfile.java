package medico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneForm.FormDAO;
import gestioneForm.InterventoDAO;
import utenza.UserDAO;
import utenza.UserFacade;
import validazione.ValidateFieldsRegistration;

import com.mongodb.client.MongoClient;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("name").trim();
        String cognome = request.getParameter("surname").trim();
        String sesso = request.getParameter("gender").trim();
        String password = request.getParameter("password").trim();
        String email = request.getParameter("email").trim();
        String oldmail = (String) request.getSession().getAttribute("email");
        String provincia = request.getParameter("provincia").trim();
        String comune = request.getParameter("comune").trim();
        String indirizzo = request.getParameter("indirizzo").trim();
        String numero_telefono = request.getParameter("numero_telefono").trim();

        MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
        String oldMail = (String) request.getSession().getAttribute("email");
        UserFacade userFacade = new UserFacade(mongoClient);
        MMGBean oldDati = userFacade.getUserByEmail(oldMail);
        ValidateFieldsRegistration validate = new ValidateFieldsRegistration();
        
        
        // EMAIL VALIDATION
        if(!oldDati.getEmail().equals(email)) {
	        if(userFacade.existEmail(email) && (!oldmail.equals(email))) {
	        	request.setAttribute("error", "l'email inserita � gia presente nel database");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
	        }
			if(email.length()>255) {
				request.setAttribute("error", "Il campo Email deve contenere al massimo 255 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(email.length()<2) {
				request.setAttribute("error", "Il campo Email deve contenere almeno 2 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
	        
			if(!validate.validateEmail(email)) {
				request.setAttribute("error", "Il campo Email non rispetta il formato stabilito");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
				
			}
        }
        
        //PASSWORD VALIDATOR
		if(!oldDati.getPassword().equals(password)) {
			if(password.length()<8) {
				request.setAttribute("error", "Il campo Password deve contenere almeno 8 caratteri, almeno una lettera, almeno un numero e nessuno spazio");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(password.length()>32) {
				request.setAttribute("error", "Il campo Password deve contenere al massimo 24 caratteri,almeno una lettera, almeno un numero e nessuno spazio");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(!validate.validatePassword(password)) {
				request.setAttribute("error", "Il campo Password deve contenere almeno una lettera, almeno un numero e nessuno spazio");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
		}
		
		
		//PROVINCIA VALIDATOR
		if(!oldDati.getProvincia().equals(provincia)) {
			if(provincia.length()<2) {
				request.setAttribute("error", "Il campo Provincia deve contenere minimo 2 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(provincia.length()>255) {
				request.setAttribute("error", "Il campo Provincia deve contenere al massimo 255 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(!validate.validateProvincia(provincia)) {
				request.setAttribute("error", "Il campo Provincia deve contenere minimo 2 caratteri e non sono ammessi caratteri speciali");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
		}
		
		
		//COMUNE VALIDATOR
		if(!oldDati.getComune().equals(comune)) {
			if(comune.length()<2) {
				request.setAttribute("error", "Il campo Comune deve contenere almeno 2 caratteri e non deve essere vuoto");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(comune.length()>255) {
				request.setAttribute("error", "Il campo Comune deve contenere al massimo 255 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(!validate.validateComune(comune)) {
				request.setAttribute("error", "Il campo Comune deve contenere almeno 2 caratteri e non deve presentare caratteri speciali");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
    }
		
		//INDIRIZZO VALIDATOR
		if(!oldDati.getIndirizzo().equals(indirizzo)) {
			if(indirizzo.length()< 2) {
				request.setAttribute("error", "Il campo indirizzo deve contenere almeno 2 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			
			if(indirizzo.length()>255) {
				request.setAttribute("error", "Il campo indirizzo deve contenere al massimo 255 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(!validate.validateIndirizzo(indirizzo)) {
				request.setAttribute("error", "Il campo indirizzo deve contenere soltanto caratteri alfanumerici");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
		}
		
		//NUMERO DI TELEFONO VALIDATOR
		if(!oldDati.getTelefono().equals(numero_telefono)) {
			if(numero_telefono.length()<10) {
				request.setAttribute("error", "Il campo Telefono deve contenere almeno 10 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(numero_telefono.length()>11) {
				request.setAttribute("error", "Il campo Telefono deve contenere al massimo 11 caratteri");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
			if(!validate.validateNumeroTelefono(numero_telefono)) {
				request.setAttribute("error", "“Il campo Telefono deve contenere solo caratteri numerici, al più le prime 3 cifre possono essere separate da un trattino");
				request.getRequestDispatcher("ProfileServlet").forward(request, response);
			}
		}
        if (nome == null || cognome == null || sesso == null || password == null ||
                email == null || provincia == null || comune == null || indirizzo == null ||
                numero_telefono == null || "".equals(nome) || "".equals(cognome)
                || "".equals(sesso) || "".equals(password) || "".equals(email)
                || "".equals(provincia) || "".equals(comune) || "".equals(indirizzo) || "".equals(numero_telefono)) {
            request.getRequestDispatcher("ProfileServlet").forward(request, response);
        } else {
            
            boolean isUserFound = userFacade.modifyUser(password, email,
                    provincia, comune, indirizzo, numero_telefono,oldmail);

            request.getSession().setAttribute("email", email);
            if (isUserFound) {
                request.getRequestDispatcher("ProfileServlet").forward(request, response);
            } else {
                request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
                request.getRequestDispatcher("ProfileServlet").forward(request, response);
            }
        }
    }
}
