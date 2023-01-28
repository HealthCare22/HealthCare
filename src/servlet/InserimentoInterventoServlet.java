package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.GestioneInterventiBean;
import DAO.InterventoUtil;
import DAO.UtilForm;

/**
 * Servlet implementation class InserimentoInterventoServlet
 */
@WebServlet("/InserimentoInterventoServlet")
public class InserimentoInterventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoInterventoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descrizione = request.getParameter("descrizione");

		
		
		HttpSession http = request.getSession();
		String email = (String) http.getAttribute("email");
		String id_form = (String) http.getAttribute("id_form");
		
		
		System.out.println(descrizione + id_form + email);
		
		if(descrizione == null || "".equals(descrizione) || id_form == null || "".equals(id_form) ||
				email == null || "".equals(email)) {
			
			request.setAttribute("error_message", "Aggiunta dell'intervento fallita");
			request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
            
		}else {
			
			boolean addIntervento = InterventoUtil.addIntervento(email, descrizione, id_form);
			
			if(addIntervento) {   
				
				List<GestioneInterventiBean> listaInterventi = InterventoUtil.recuperaInterventi(id_form, email);
				request.setAttribute("ListaInterventi", listaInterventi);
				
	            request.getRequestDispatcher("/DettagliForm.jsp").forward(request, response);
	         } else {
	             request.setAttribute("error_message", "Aggiunta dell'intervento fallita");
	             request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
	         }   
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
