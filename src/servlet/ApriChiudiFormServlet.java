package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import DAO.FormDAO;

/**
 * Servlet implementation class ApriChiudiFormServlet
 */
@WebServlet("/ApriChiudiFormServlet")
public class ApriChiudiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApriChiudiFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		HttpSession sessione = request.getSession();
		String idForm = (String) sessione.getAttribute("idform");
		Boolean statusForm = (Boolean) sessione.getAttribute("status");
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		FormDAO formDAO = new FormDAO(mongoClient);
		
	
		if (statusForm) {
			
			
			formDAO.setStatusFalse(idForm);
			request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
			
		}
		
		if(!statusForm) {
			
			formDAO.setStatusTrue(idForm);
			request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
