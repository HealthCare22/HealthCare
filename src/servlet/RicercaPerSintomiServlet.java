package servlet;
 
import java.io.IOException; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import Beans.GestioneMalattieBean;
import Beans.SintomoBean;
import DAO.MalattiaDAO;
import DAO.SintomoDAO;

/**
 * Servlet implementation class RicercaPerSintomiServlet
 */
@WebServlet("/RicercaPerSintomiServlet")
public class RicercaPerSintomiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaPerSintomiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> listaNomiSintomi = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			String sintomo = (String) request.getParameter("Sintomo"+i);
			if(sintomo!=null) {
				listaNomiSintomi.add(i-1,sintomo);
			}else {
				listaNomiSintomi.add(i-1,"null");
			}
			
		
		}
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		MalattiaDAO malattiaDao= new MalattiaDAO(mongoClient);
		List<SintomoBean> listaSintomi = sintomoDao.getSintomiByNome(listaNomiSintomi);
		List<GestioneMalattieBean> listaMalattie = malattiaDao.getMalattieBySintomi(listaSintomi);
		request.setAttribute("listaMalattie", listaMalattie);
		request.getRequestDispatcher("listaMalattie.jsp").forward(request,response);
	}

}
