package gestioneForm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import validazione.ValidateFieldsinserimentoInUnForm;

import com.mongodb.client.MongoClient;

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
		String id_form = (String) http.getAttribute("idform");
		boolean checked = true;
		ValidateFieldsinserimentoInUnForm validate = new ValidateFieldsinserimentoInUnForm();
		
		if(descrizione.length()<2) {
			request.setAttribute("error", "Il campo descrizione deve contenere almeno 2 caratteri");
			request.getRequestDispatcher("/MyFormServlet").forward(request, response);
			checked = false;
		}
		
		if(descrizione.length()> 800) {
			request.setAttribute("error", "Il campo descrizione deve contenere al massimo 800 caratteri");
			request.getRequestDispatcher("/MyFormServlet").forward(request, response);
			checked = false;
		}
		
		if(!validate.validateDescrizione(descrizione)) {
			request.setAttribute("error", "Il campo descrizione non presenta il formato stabilito");
			request.getRequestDispatcher("/MyFormServlet").forward(request, response);
			checked = false;
		}
	
		if(descrizione == null || "".equals(descrizione) || id_form == null || "".equals(id_form) ||
				email == null || "".equals(email)) {
			
			request.setAttribute("error", "Aggiunta dell'intervento fallita");
			request.getRequestDispatcher("/MyFormServlet").forward(request, response);
			checked = false;
            
		}else if(checked){
			MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
			FormFacade formFacade = new FormFacade(mongoClient);
			List<GestioneInterventiBean> addIntervento = formFacade.addIntervento(email, descrizione, id_form);
			request.setAttribute("listaInterventi", addIntervento);
			
			GestioneFormBean form = formFacade.getFormById(id_form);
			request.setAttribute("formById", form);
			
				if(addIntervento!=null) {
	            request.getRequestDispatcher("/DettagliForm.jsp").forward(request, response);
				}
		}else {}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
