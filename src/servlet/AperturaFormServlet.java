package servlet;

import DAO.FormDAO;
import com.mongodb.client.MongoClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class AperturaFormServlet
 */
@WebServlet("/AperturaFormServlet")
public class AperturaFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AperturaFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String topic = request.getParameter("topic");
        String titolo = request.getParameter("titolo");
        String descrizione = request.getParameter("descrizione");

        System.out.println(topic + titolo + descrizione);
        if (topic == null || titolo == null || descrizione == null || "".equals(topic) ||
                "".equals(titolo) || "".equals(descrizione)) {

            request.setAttribute("error_message", "Creazione del form non avvenuta con successo");

        } else {
            MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
            HttpSession session = request.getSession();

            String email = (String) session.getAttribute("email");
            FormDAO formDAO = new FormDAO(mongoClient);
            boolean isUserFound = formDAO.CreateNewForm(topic, titolo, descrizione, email);

            if (isUserFound) {
                request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
            } else {
                request.setAttribute("error_message", "Creazione del form non avvenuta con successo");
                request.getRequestDispatcher("/AperturaForm.jsp").forward(request, response);
            }
        }
    }
}
