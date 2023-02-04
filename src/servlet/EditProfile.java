package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FormDAO;
import DAO.InterventoDAO;
import DAO.UserDAO;
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
        UserDAO userDAO = new UserDAO(mongoClient);
        ValidateFieldsRegistration validate = new ValidateFieldsRegistration();
        
        
        // EMAIL VALIDATION
        if(userDAO.existEmail(email)) {
        	request.setAttribute("error", "l'email inserita è gia presente nel database");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
		if(email.length()>255) {
			request.setAttribute("error", "Il campo Email deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(email.length()<2) {
			request.setAttribute("error", "Il campo Email deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
        
		if(!validate.validateEmail(email)) {

			request.setAttribute("error", "Il campo Email non rispetta il formato stabilito");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
			
		}
		
        
        //PASSWORD VALIDATOR

		
		if(password.length()<8) {
			request.setAttribute("error", "Il campo Password deve contenere almeno 8 caratteri, almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(password.length()>24) {
			request.setAttribute("error", "Il campo Password deve contenere al massimo 24 caratteri,almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(!validate.validatePassword(password)) {
			request.setAttribute("error", "Il campo Password deve contenere almeno una lettera, almeno un numero e nessuno spazio");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
	
		
		
		//PROVINCIA VALIDATOR
		if(provincia.length()<2) {
			request.setAttribute("error", "Il campo Provincia deve contenere minimo 2 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(provincia.length()>255) {
			request.setAttribute("error", "Il campo Provincia deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(!validate.validateProvincia(provincia)) {
			request.setAttribute("error", "Il campo Provincia deve contenere minimo 2 caratteri e non sono ammessi caratteri speciali");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
		
		
		//COMUNE VALIDATOR
		if(comune.length()<2) {
			request.setAttribute("error", "Il campo Comune deve contenere almeno 2 caratteri e non deve essere vuoto");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(comune.length()>255) {
			request.setAttribute("error", "Il campo Comune deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(!validate.validateComune(comune)) {
			request.setAttribute("error", "Il campo Comune deve contenere almeno 2 caratteri e non deve presentare caratteri speciali");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
		
		//INDIRIZZO VALIDATOR
		if(indirizzo.length()< 2) {
			request.setAttribute("error", "Il campo indirizzo deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
		if(indirizzo.length()>255) {
			request.setAttribute("error", "Il campo indirizzo deve contenere al massimo 255 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(!validate.validateIndirizzo(indirizzo)) {
			request.setAttribute("error", "Il campo indirizzo deve contenere soltanto caratteri alfanumerici");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
	
		
		//NUMERO DI TELEFONO VALIDATOR
		if(numero_telefono.length()<10) {
			request.setAttribute("error", "Il campo Telefono deve contenere almeno 10 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(numero_telefono.length()>11) {
			request.setAttribute("error", "Il campo Telefono deve contenere al massimo 11 caratteri");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		if(!validate.validateNumeroTelefono(numero_telefono)) {
			request.setAttribute("error", "“Il campo Telefono deve contenere solo caratteri numerici, al più le prime 3 cifre possono essere separate da un trattino");
			request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
        if (nome == null || cognome == null || sesso == null || password == null ||
                email == null || provincia == null || comune == null || indirizzo == null ||
                numero_telefono == null || "".equals(nome) || "".equals(cognome)
                || "".equals(sesso) || "".equals(password) || "".equals(email)
                || "".equals(provincia) || "".equals(comune) || "".equals(indirizzo) || "".equals(numero_telefono)) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            
            boolean isUserFound = userDAO.editUserInDb(password, email,
                    provincia, comune, indirizzo, numero_telefono,oldmail);


            FormDAO formDAO = new FormDAO(mongoClient);
            formDAO.updateEmail(oldmail,email);


            InterventoDAO interventoDAO = new InterventoDAO(mongoClient);
            interventoDAO.updateEmailInterventi(oldmail, email);

            request.getSession().setAttribute("email", email);
            if (isUserFound) {
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            }
        }
    }
}
