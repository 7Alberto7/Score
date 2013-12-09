package com.inactec.score;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListViewGenerico extends ArrayAdapter<Puntuacion> {
	private final Activity actividad;
	private final ListaPuntuaciones listaJugadores;
	private final AlmacenAjustesGenerico almacenAjustes;

	public ListViewGenerico(Activity actividad,
			ListaPuntuaciones listaJugadores,
			AlmacenAjustesGenerico almacenAjustes) {
		super(actividad, 0);
		this.actividad = actividad;
		this.listaJugadores = listaJugadores;
		this.almacenAjustes = almacenAjustes;
	}

	@Override
	public View getView(final int posicion, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista_generico, parent,
				false);
		TextView textView = (TextView) view.findViewById(R.id.participante);
		textView.setText(listaJugadores.obtenerPuntuacion(posicion).getNombre());
		final TextView textPuntos = (TextView) view.findViewById(R.id.puntos);
		textPuntos.setText(Integer.toString(listaJugadores.obtenerPuntuacion(
				posicion).getPuntos()));

		Button btnRestar = (Button) view.findViewById(R.id.btn_restar);

		btnRestar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AjustesGenerico datosAjustes = almacenAjustes.cargarAjustes();
				int puntosActuales = listaJugadores.obtenerPuntuacion(posicion)
						.getPuntos();
				int puntosRestar = datosAjustes.getValorRestar();
				int puntosMin = datosAjustes.getValorMin();
				if (puntosActuales > puntosMin) {
					puntosActuales -= puntosRestar;
					if (puntosActuales < puntosMin) {
						puntosActuales = puntosMin;
					}
					textPuntos.setText(Integer.toString(puntosActuales));
					listaJugadores.obtenerPuntuacion(posicion).setPuntos(
							puntosActuales);
				}

			}
		});

		Button btnSumar = (Button) view.findViewById(R.id.btn_sumar);

		btnSumar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AjustesGenerico datosAjustes = almacenAjustes.cargarAjustes();
				int puntosActuales = listaJugadores.obtenerPuntuacion(posicion)
						.getPuntos();
				int puntosSumar = datosAjustes.getValorSumar();
				int puntosMax = datosAjustes.getValorMax();
				if (puntosActuales < puntosMax) {
					puntosActuales += puntosSumar;
					if (puntosActuales > puntosMax) {
						puntosActuales = puntosMax;
					}
					textPuntos.setText(Integer.toString(puntosActuales));
					listaJugadores.obtenerPuntuacion(posicion).setPuntos(
							puntosActuales);
				}

			}
		});

		return view;
	}

	@Override
	public int getCount() {
		return listaJugadores.numeroElementos();
	}

	@Override
	public Puntuacion getItem(int arg0) {
		return listaJugadores.obtenerPuntuacion(arg0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
