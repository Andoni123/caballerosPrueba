package controlador.caballero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Validador;
import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import modelo.ModeloCaballero;
import modelo.ModeloArma;


/**
 * Servlet implementation class Store
 */
@WebServlet("/StoreCaballero")



public class StoreCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Caballero c = new Caballero();
		c.setNombre(request.getParameter("nombre"));
		c.setFuerza(Integer.parseInt((request.getParameter("fuerza"))));
		c.setExperiencia(Integer.parseInt(request.getParameter("experiencia")));
		c.setFoto(request.getParameter("experiencia"));
		Arma arma=new Arma();
		arma.setId(Integer.parseInt(request.getParameter("arma_id")));
		c.setArma(arma);
		Escudo escudo = new Escudo();
		escudo.setId(Integer.parseInt(request.getParameter("escudo_id")));
		c.setEscudo(escudo);
		ModeloCaballero mc = new ModeloCaballero();

		if(Validador.validarCaballero(c, mc)) {
			mc.insert(c);
			response.sendRedirect("IndexCaballero?msg=Stored");
		}else {
			response.sendRedirect("IndexCaballero?msg=noStored");
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