package modelo;

public class Arma {

	private int id;
	private String nombre;
	private int capacidad_danio;
	private String foto;
	
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
	public int getCapacidad_danio() {
		return capacidad_danio;
	}
	public void setCapacidad_danio(int capacidad_danio) {
		this.capacidad_danio = capacidad_danio;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
