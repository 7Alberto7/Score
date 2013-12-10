package com.inactec.score;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListViewMonetario extends ArrayAdapter<PuntuacionM> {
	private final Activity actividad;
	private final ListaPuntuacionesM listaJugadores;
	private final AlmacenAjustesMonetario almacenAjustes;

	public ListViewMonetario(Activity actividad,
			ListaPuntuacionesM listaJugadores,
			AlmacenAjustesMonetario almacenAjustes) {
		super(actividad, 0);
		this.actividad = actividad;
		this.listaJugadores = listaJugadores;
		this.almacenAjustes = almacenAjustes;
	}

	@Override
	public View getView(final int posicion, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista_monetario, parent,
				false);
		TextView textView = (TextView) view.findViewById(R.id.participante);
		textView.setText(listaJugadores.obtenerPuntuacion(posicion).getNombre());
		final TextView textPuntos = (TextView) view.findViewById(R.id.puntos);
		textPuntos.setText(formatearNumero(listaJugadores.obtenerPuntuacion(
				posicion).getPuntos()));

		Button btnRestar = (Button) view.findViewById(R.id.btn_restar);

		btnRestar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AjustesMonetario datosAjustes = almacenAjustes.cargarAjustes();
				float puntosActuales = listaJugadores.obtenerPuntuacion(posicion)
						.getPuntos();
				float puntosRestar = datosAjustes.getValorRestar();
				float puntosMin = datosAjustes.getValorMin();
				if (puntosActuales > puntosMin) {
					puntosActuales -= puntosRestar;
					if (puntosActuales < puntosMin) {
						puntosActuales = puntosMin;
					}
					textPuntos.setText(formatearNumero(puntosActuales));
					listaJugadores.obtenerPuntuacion(posicion).setPuntos(
							puntosActuales);
				}

			}
		});

		Button btnSumar = (Button) view.findViewById(R.id.btn_sumar);

		btnSumar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AjustesMonetario datosAjustes = almacenAjustes.cargarAjustes();
				float puntosActuales = listaJugadores.obtenerPuntuacion(posicion)
						.getPuntos();
				float puntosSumar = datosAjustes.getValorSumar();
				float puntosMax = datosAjustes.getValorMax();
				if (puntosActuales < puntosMax) {
					puntosActuales += puntosSumar;
					if (puntosActuales > puntosMax) {
						puntosActuales = puntosMax;
					}
					textPuntos.setText(formatearNumero(puntosActuales));
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
	public PuntuacionM getItem(int arg0) {
		return listaJugadores.obtenerPuntuacion(arg0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public String formatearNumero(float cantidad) {
		String cadena = String.format("%.2f", cantidad);

		return cadena;
	}

}
