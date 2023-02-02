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

        if (nome == null || cognome == null || sesso == null || password == null ||
                email == null || provincia == null || comune == null || indirizzo == null ||
                numero_telefono == null || "".equals(nome) || "".equals(cognome)
                || "".equals(sesso) || "".equals(password) || "".equals(email)
                || "".equals(provincia) || "".equals(comune) || "".equals(indirizzo) || "".equals(numero_telefono)) {
            System.out.println("Esito errato per campi dati vuoti");
           
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
            UserDAO userDAO = new UserDAO(mongoClient);
            boolean isUserFound = userDAO.editUserInDb(password, email,
                    provincia, comune, indirizzo, numero_telefono,oldmail);
            
            
            FormDAO formDAO = new FormDAO(mongoClient);
            formDAO.updateEmail(oldmail,email);
            
            
            InterventoDAO interventoDAO = new InterventoDAO(mongoClient);
            interventoDAO.updateEmailInterventi(oldmail, email);
            
            request.getSession().setAttribute("email", email);
            if (isUserFound) {
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
                System.out.println("Modifica avvenuta");
            } else {
                System.out.println("Esito errato per Utente non iserito (UserFound)");
                request.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            }
        }
    }
}