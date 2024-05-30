package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloEscudo {

	private Conector conector = new Conector();

	public ArrayList<Escudo> getTodos() {
		ArrayList<Escudo> escudos = new ArrayList<>();

		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ESCUDOS");

			while (rs.next()) {
				Escudo es = new Escudo();

				rellenarEscudos(es, rs);

				escudos.add(es);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return escudos;
	}

	private void rellenarEscudos(Escudo es, ResultSet rs) throws SQLException {
	    es.setId(rs.getInt("id"));
	    es.setNombre(rs.getString("nombre"));
	    es.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
	}

	public Escudo getEscudo(int id) {
	    Escudo es = new Escudo();

	    try (PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ESCUDOS WHERE ID=?")) {
	        pst.setInt(1, id);
	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                rellenarEscudos(es, rs);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return es;
	}

}
