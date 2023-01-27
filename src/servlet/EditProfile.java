package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Util;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		
		
		boolean isUserFound = Util.editUserInDb(nome, cognome,sesso, eta, password, email,
				provincia,comune, indirizzo, numero_telefono);

				if(isUserFound) {request.getRequestDispatcher("/profile.jsp").forward(request, response);
								System.out.println("Modifica avvenuta");
								}
				else {
					System.out.println("Esito errato per Utente non iserito (UserFound)");
					request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
					request.getRequestDispatcher("/profile.jsp").forward(request, response);}
				}
		}

