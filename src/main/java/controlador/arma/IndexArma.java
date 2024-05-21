package controlador.arma;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class IndexArma
 */
@WebServlet("/IndexArma")
public class IndexArma extends HttpServlet{

	

		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @return 
	     * @see HttpServlet#HttpServlet()
	     */
	    public  IndexArma() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ArrayList<Arma> armas= new ModeloArma().getTodos();


			request.setAttribute("asig", request.getParameter("asig"));
			request.setAttribute("armas", armas);
			request.getRequestDispatcher("indexArma.jsp").forward(request, response);
		}

}