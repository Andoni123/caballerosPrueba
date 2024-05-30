package modelo;

import java.sql.PreparedStatement;
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
	public ArrayList<Caballero> buscarCaballerosPorNombre(String nombre) {
	    ArrayList<Caballero> caballeros = new ArrayList<>();
	    
	    String sql = "SELECT * FROM CABALLEROS WHERE NOMBRE LIKE ?";
	    
	    try {
	        PreparedStatement pst = conector.getConexion().prepareStatement(sql);
	        
	        pst.setString(1, "%" + nombre + "%");

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            Caballero caballero = new Caballero();
	            rellenarCaballero(caballero, rs);
	            caballeros.add(caballero);
	        }
	        
	        pst.close();
	        rs.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return caballeros;
	}

				

	private void rellenarCaballero(Caballero c, ResultSet rs) throws SQLException {
		ModeloArma modeloArma= new ModeloArma();
		ModeloEscudo modeloEscudo= new ModeloEscudo();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		c.setFuerza(rs.getInt("fuerza"));
		c.setExperiencia(rs.getInt("experiencia"));
		c.setFoto(rs.getString("foto"));
		c.setArma(modeloArma.getArma(rs.getInt("arma_id")));
		c.setEscudo(modeloEscudo.getEscudo(rs.getInt("escudo_id")));
	}
	public void insert(Caballero c) {
		 String sql = "INSERT INTO CABALLEROS (NOMBRE,FUERZA,EXPERIENCIA,FOTO,ARMA_ID,ESCUDO_ID) VALUES (?,?,?,?,?,?)";
		 try {
			
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getFuerza());
			pst.setInt(3,c.getExperiencia());
			pst.setString(4, c.getFoto());
			pst.setInt(5, c.getArma().getId());
			pst.setInt(6, c.getEscudo().getId());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	public boolean existeNombre(String nombre) {
        String sql = "SELECT COUNT(*) FROM caballeros WHERE nombre = ?";
        try (PreparedStatement pst = conector.getConexion().prepareStatement(sql)) {
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//	public boolean delete(String string) {
//
//		String sql="DELETE FROM CABALLEROS WHERE ID=?";
//		try {
//			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
//			pst.setInt(1, id);
//			pst.execute();
//			
//			return true;
//		} catch (SQLException e) {
//			return false;
//		}
//		return false;
//	}
	public boolean update(Caballero c) {
		String sql ="UPDATE CABALLEROS SET NOMBRE=?,FUERZA=?,EXPERIENCIA=?,FOTO=?,ARMA_ID=?,ESCUDO_ID=? WHERE ID=?";
		
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement(sql);
			
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getFuerza());
			pst.setInt(3, c.getExperiencia());
			pst.setString(4, c.getFoto());
			pst.setInt(5, c.getArma().getId());
			pst.setInt(6, c.getEscudo().getId());
			pst.setInt(6, c.getId());
			
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
}
