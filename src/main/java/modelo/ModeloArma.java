package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloArma {

	private Conector conector = new Conector();

	public ArrayList<Arma> getTodos() {
		ArrayList<Arma> armas = new ArrayList<>();

		try {
			Statement st = conector.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ARMAS");

			while (rs.next()) {
				Arma a = new Arma();

				rellenarArma(a, rs);

				armas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return armas;
	}

	private void rellenarArma(Arma a, ResultSet rs) throws SQLException {
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setCapacidad_danio(rs.getInt("capacidad_danio"));
		a.setFoto(rs.getString("foto"));
	}
	public Arma getArma(int id) {
		Arma a = new Arma();

		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ARMAS WHERE ID=?");
			pst.setInt(1,id);			
			ResultSet rs = pst.executeQuery();

			

				rs.next();
				rellenarArma(a, rs);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}
}

