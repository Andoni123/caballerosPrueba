package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCaballero {

	private Conector conector = new Conector();

	public ArrayList<Caballero> getTodos() {
		ArrayList<Caballero> caballeros = new ArrayList<>();

		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CABALLEROS");

			while (rs.next()) {
				Caballero c = new Caballero();

				rellenarCaballero(c, rs);

				caballeros.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return caballeros;
	}

	private void rellenarCaballero(Caballero c, ResultSet rs) throws SQLException {
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		c.setFuerza(rs.getInt("fuerza"));
		c.setExperiencia(rs.getInt("experiencia"));
		c.setFoto(rs.getString("foto"));
		c.setArma_id(rs.getInt("arma_id"));
	}
}
