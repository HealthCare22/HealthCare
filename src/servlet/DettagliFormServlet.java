package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;

import Beans.GestioneFormBean;
import Beans.GestioneInterventiBean;
import DAO.FormDAO;
import DAO.InterventoDAO;

/**
 * Servlet implementation class DettaglioFormServlet
 */
@WebServlet("/DettaglioFormServlet")
public class DettagliFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idForm = (String) request.getParameter("id");
		

	
			
			System.out.print(idForm);
			HttpSession sessione = request.getSession();
			sessione.setAttribute("idform", idForm);
	
		
		//request.setAttribute("id", idForm);
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		FormDAO formDAO = new FormDAO(mongoClient);
		
		GestioneFormBean form = formDAO.getFormById(idForm);
		
		
		InterventoDAO interventoDAO = new InterventoDAO(mongoClient);
		List<GestioneInterventiBean> listaInterventi = interventoDAO.recuperaInterventi(idForm);
		
		
		
		
		request.setAttribute("listaInterventi", listaInterventi);
		request.setAttribute("formById", form);
		request.getRequestDispatcher("/DettagliForm.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
