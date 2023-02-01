package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import Beans.GestioneInterventiBean;
import DAO.InterventoDAO;

/**
 * Servlet implementation class VisualizzaInterventiPersonaliServlet
 */
@WebServlet("/VisualizzaInterventiPersonaliServlet")
public class VisualizzaInterventiPersonaliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaInterventiPersonaliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getSession().getAttribute("email");
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		InterventoDAO interventoDao = new InterventoDAO(mongoClient);
		List<GestioneInterventiBean> listaInterventi = interventoDao.getInterventiByEmail(email);
		request.setAttribute("listaInterventi", listaInterventi);
		request.getRequestDispatcher("interventi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
