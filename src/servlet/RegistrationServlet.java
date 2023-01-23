package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.Util;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
		String eta = request.getParameter("eta");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String provincia = request.getParameter("provincia");
		String comune = request.getParameter("comune");
		String indirizzo = request.getParameter("indirizzo");
		String numero_telefono = request.getParameter("numero_telefono");
		
	// Checking for null and empty values
			if(nome == null || cognome == null || sesso == null || eta == null || password == null ||
					email == null || provincia == null || comune == null || indirizzo == null ||
					numero_telefono == null || "".equals(nome) || "".equals(cognome)
					|| "".equals(sesso) || "".equals(eta) || "".equals(password) || "".equals(email)
					|| "".equals(provincia) || "".equals(comune) || "".equals(indirizzo) || "".equals(numero_telefono)){
					System.out.println("Esito errato per campi dati vuoti");
					System.out.print(nome + cognome + sesso + eta + password + email + provincia + comune + indirizzo + numero_telefono);
					request.setAttribute("error_message", "Please fill the registration form");
					request.getRequestDispatcher("/navbar.html").forward(request, response);
		}else {
		boolean isUserFound = Util.appendUserInDb(nome, cognome,sesso, eta, password, email,
				provincia,comune, indirizzo, numero_telefono);

				if(isUserFound) {request.getRequestDispatcher("/login.jsp").forward(request, response);
								System.out.println("Registrazione avvenuta");
								}
				else {
					System.out.println("Esito errato per Utente non iserito (UserFound)");
					request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
					request.getRequestDispatcher("/logout.jsp").forward(request, response);}
				}
		}
}

