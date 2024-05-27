package controlador;

import modelo.Caballero;
import modelo.ModeloCaballero;

public class Validador {

	public static  boolean validarCaballero(Caballero c, ModeloCaballero mc) {

		if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
			return false;
		} else if (c.getFuerza() < 0 || c.getFuerza() > 100 || c.getExperiencia() < 0 || c.getExperiencia() > 100) {
			return false;
		} else if (mc.existeNombre(c.getNombre())) {
			return false;
		} else if (c.getArma() == null || c.getArma().getId() <= 0) {
			return false;
		} else if (c.getEscudo() == null || c.getEscudo().getId() <= 0) {
			return false;
		}
			return true;

	}
}
