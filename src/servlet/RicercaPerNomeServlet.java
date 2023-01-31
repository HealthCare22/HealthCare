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

        if (nomeMalattia == null || "".equals(nomeMalattia)) {

            request.setAttribute("error_message", "Ricerca della malattia per nome fallita! Riprova...");

        } else {
            MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
            MalattiaDAO malattiaDAO = new MalattiaDAO(mongoClient);
            SintomoDAO sintomoDAO = new SintomoDAO(mongoClient);
            List<GestioneMalattieBean> listaMalattia = malattiaDAO.RicercaPerNome(nomeMalattia);
            List<SintomoBean> listaSintomi = sintomoDAO.getSintomi();
            request.setAttribute("listaMalattia", listaMalattia);
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
