package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Util;
import DAO.UtilForm;

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
		if(topic == null || titolo == null || descrizione == null || "".equals(topic) || 
				"".equals(titolo) || "".equals(descrizione) ) {
			
			request.setAttribute("error_message", "Creazione del form non avvenuta con successo");
            
		}else {
			boolean isUserFound = UtilForm.CreateNewForm(topic, titolo, descrizione);
			
			if(isUserFound) {               
	             request.getRequestDispatcher("/login.jsp").forward(request, response);
	         } else {
	             request.setAttribute("error_message", "Creazione del form non avvenuta con successo");
	             request.getRequestDispatcher("/logout.jsp").forward(request, response);
	         }   
		}
		
		
		
	}

}
