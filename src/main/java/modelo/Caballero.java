package modelo;

public class Caballero {

	private int id;
	private String nombre;
	private int fuerza;
	private int experiencia;
	private String foto;
	private int arma_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getArma_id() {
		return arma_id;
	}
	public void setArma_id(int arma_id) {
		this.arma_id = arma_id;
	}
}
