package gestioneMalattie;
 
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

import validazione.ValidateFieldsInserimentoSintomi;

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
		ValidateFieldsInserimentoSintomi validate = new ValidateFieldsInserimentoSintomi();
		for(int i=1; i<=5; i++) {
			String sintomo = (String) request.getParameter("Sintomo"+i);
			if(sintomo!=null) {
				if(!validate.validateSintomo(sintomo)) {
					request.setAttribute("error_message", "ogni sintomo deve avere lunghezza compresa tra 2 e 50 caratteri");
					request.getRequestDispatcher("RicercaMalattia.jsp").forward(request, response);
				}else {
					listaNomiSintomi.add(sintomo.toLowerCase());
				}
			}
		}
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		MalattieFacade malattieFacade = new MalattieFacade(mongoClient);
		List<SintomoBean> listaSintomi = malattieFacade.getSintomiByNome(listaNomiSintomi);
		List<GestioneMalattieBean> listaMalattie = malattieFacade.getMalattieBySintomi(listaSintomi);
		request.setAttribute("listaMalattie", listaMalattie);
		request.getRequestDispatcher("listaMalattie.jsp").forward(request,response);
	}

}
