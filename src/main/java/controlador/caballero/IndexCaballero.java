package controlador.caballero;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class IndexCamion
 */
@WebServlet("/IndexCaballero")
public class IndexCaballero extends HttpServlet{

	

		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @return 
	     * @see HttpServlet#HttpServlet()
	     */
	    public  IndexCaballero() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ArrayList<Caballero> caballeros= new ModeloCaballero().getTodos();

			
			request.setAttribute("asig", request.getParameter("asig"));
			request.setAttribute("caballeros", caballeros);
			request.getRequestDispatcher("indexCaballero.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
