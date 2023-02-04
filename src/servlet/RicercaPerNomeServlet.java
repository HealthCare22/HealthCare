package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MalattiaDAO;
import DAO.SintomoDAO;
import validazione.ValidateFieldsRicercaMalattiaRaraNome;
import Beans.GestioneMalattieBean;
import Beans.SintomoBean;

import com.mongodb.client.MongoClient;

/**
 * Servlet implementation class RicercaPerNomeServlet
 */
@WebServlet("/RicercaPerNomeServlet")
public class RicercaPerNomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaPerNomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeMalattia = request.getParameter("nomeMalattia");
        MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
        MalattiaDAO malattiaDAO = new MalattiaDAO(mongoClient);
        ValidateFieldsRicercaMalattiaRaraNome validate = new ValidateFieldsRicercaMalattiaRaraNome();
        
        if(nomeMalattia.length() < 2) {
        	request.setAttribute("error_message", "Il campo malattia deve essere compilato o deve avere minimo 2 caratteri alfabetici");
            request.getRequestDispatcher("/RicercaMalattia.jsp").forward(request, response);
        }
        
        if(nomeMalattia.length() > 40) {
        	request.setAttribute("error_message", "Il campo malattia deve contenere al massimo 40 caratteri");
            request.getRequestDispatcher("/RicercaMalattia.jsp").forward(request, response);
        }
        if(malattiaDAO.existMalattia(nomeMalattia)) {
          	request.setAttribute("error_message", "La malattia ricercata non è stata trovata");
            request.getRequestDispatcher("/RicercaMalattia.jsp").forward(request, response);
        }
        
        if(!validate.validateName(nomeMalattia)) {
        	request.setAttribute("error_message", "Il campo malattia non rispetta il formato stabilito");
            request.getRequestDispatcher("/RicercaMalattia.jsp").forward(request, response);
        }
        if (nomeMalattia == null || "".equals(nomeMalattia)) {

            request.setAttribute("error_message", "Ricerca della malattia per nome fallita! Riprova...");
            request.getRequestDispatcher("/RicercaMalattia.jsp").forward(request, response);

        } else {
      
            SintomoDAO sintomoDAO = new SintomoDAO(mongoClient);
            List<GestioneMalattieBean> listaMalattia = malattiaDAO.RicercaPerNome(nomeMalattia);
            List<SintomoBean> listaSintomi = sintomoDAO.getSintomi();
            request.setAttribute("listaMalattie", listaMalattia);
            request.setAttribute("listaSintomi", listaSintomi);
            request.getRequestDispatcher("/VediDettagliMalattia.jsp").forward(request, response);
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
