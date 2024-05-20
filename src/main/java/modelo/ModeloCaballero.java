package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

public class ModeloCaballero extends ArrayList<Caballero> {

	public ArrayList<Caballero> getTodos(){
		ArrayList<Caballero> caballeros = new ArrayList<>();
			
			
			try {		
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM CABALLEROS");
				
				
				while(rs.next()) {
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
		c.setArma_id(rs.getInt("id_arma"));
	}
}
	