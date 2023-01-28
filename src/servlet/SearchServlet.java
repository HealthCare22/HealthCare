package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Beans.GestioneFormBean;
import DAO.FormDAO;
import com.mongodb.client.MongoClient;


/**
 * Servlet implementation class SearchSelect
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<GestioneFormBean> listaForm;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
        FormDAO formDAO = new FormDAO(mongoClient);

        listaForm = formDAO.recuperaForm();
        System.out.print(listaForm);
        request.setAttribute("allForm", listaForm);
        RequestDispatcher dispatcher = null;

        String returnTo = "CercaForm.jsp";
        dispatcher = getServletContext().getRequestDispatcher("/" + returnTo);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
