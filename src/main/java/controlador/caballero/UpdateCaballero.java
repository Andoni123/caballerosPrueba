package controlador.caballero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class UpdateCamionero
 */
@WebServlet("/UpdateCaballero")
public class UpdateCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ModeloCaballero cm = new ModeloCaballero();
	Caballero c = new Caballero();
	c.setId(Integer.parseInt(request.getParameter("idMod"))) ;
	c.setNombre(request.getParameter("nombreMod"));
	c.setFuerza(Integer.parseInt(request.getParameter("fuerzaMod"))) ;
	c.setExperiencia(Integer.parseInt(request.getParameter("experienciaMod"))) ;
	c.setFoto(request.getParameter("fotoMod"));
	Arma arma=new Arma();
	arma.setId(Integer.parseInt(request.getParameter("arma_idMod")));
	c.setArma(arma);
	Escudo escudo = new Escudo();
	escudo.setId(Integer.parseInt(request.getParameter("escudo_idMod")));
	c.setEscudo(escudo);
	
	if(cm.update(c)) {
		response.sendRedirect("IndexCaballero?msg=modificado");
	}else {
		response.sendRedirect("IndexCaballero?msg=noModificado");
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
