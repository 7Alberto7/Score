package com.inactec.score;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaPuntuaciones {
	private List<Puntuacion> lista;

	public ListaPuntuaciones() {
		this.lista = new ArrayList<Puntuacion>();
	}

	public void aniadirPuntuacion(Puntuacion puntuacion) {
		this.lista.add(puntuacion);
	}

	public void eliminarPuntuacion(Puntuacion puntuacion) {
		this.lista.remove(puntuacion);
	}

	public Puntuacion obtenerPuntuacion(int posicion) {
		return this.lista.get(posicion);
	}
	
	public int numeroElementos() {
		return this.lista.size();
	}

	@Override
	public String toString() {
		final Iterator<Puntuacion> itr = lista.iterator();
		String cadena = "ListaPuntuaciones [lista= ";
		while (itr.hasNext()) {
			Puntuacion elemento = itr.next();
			cadena = cadena + " : " + elemento.getNombre() + " " + Integer.toString(elemento.getPuntos()) + " : ";
		}
		return cadena;
	}

}
