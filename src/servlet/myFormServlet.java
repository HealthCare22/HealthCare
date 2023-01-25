package servlet;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.GestioneFormBean;
import DAO.UtilForm;

/**
 * Servlet implementation class myFormServlet
 */
@WebServlet("/myFormServlet")
public class myFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myFormServlet() {
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
		String status = request.getParameter("status");
		if(status == null ) {
			status = "true";
		}
		List<GestioneFormBean>listaForm = UtilForm.getFormByStatus(status); 
		request.setAttribute("listaForm", listaForm);
		request.getRequestDispatcher("/MyForm.jsp").forward(request, response);
	}

}
