package gestioneForm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;


/**
 * Servlet implementation class MyFormServlet
 */
@WebServlet("/MyFormServlet")
public class MyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		request.setAttribute("email", email);
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		FormFacade facade = new FormFacade(mongoClient);
		List<GestioneFormBean>listaFormAperti = facade.getFormByStatus(email,true);
		List<GestioneFormBean>listaFormChiusi = facade.getFormByStatus(email,false);
		request.setAttribute("listaFormAperti", listaFormAperti);
		request.setAttribute("listaFormChiusi", listaFormChiusi);
		request.getRequestDispatcher("MyForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
