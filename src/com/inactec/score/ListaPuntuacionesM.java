package com.inactec.score;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaPuntuacionesM {
	private List<PuntuacionM> lista;

	public ListaPuntuacionesM() {
		this.lista = new ArrayList<PuntuacionM>();
	}

	public void aniadirPuntuacion(PuntuacionM puntuacion) {
		this.lista.add(puntuacion);
	}

	public void eliminarPuntuacion(PuntuacionM puntuacion) {
		this.lista.remove(puntuacion);
	}

	public PuntuacionM obtenerPuntuacion(int posicion) {
		return this.lista.get(posicion);
	}
	
	public int numeroElementos() {
		return this.lista.size();
	}

	@Override
	public String toString() {
		final Iterator<PuntuacionM> itr = lista.iterator();
		String cadena = "ListaPuntuaciones [lista= ";
		while (itr.hasNext()) {
			PuntuacionM elemento = itr.next();
			cadena = cadena + " : " + elemento.getNombre() + " " + Float.toString(elemento.getPuntos()) + " : ";
		}
		return cadena;
	}

}
