package com.inactec.score;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GenericoAjustes extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajustes_generico);
		final AlmacenAjustesGenerico almacenAjustes = new AlmacenAjustesGenerico(
				this);
		AjustesGenerico datosAjustes = almacenAjustes.cargarAjustes();

		// Cargar datos de XML local
		final EditText editDefecto = (EditText) findViewById(R.id.edit_puntos_por_defecto);
		final EditText editSumar = (EditText) findViewById(R.id.edit_puntos_a_sumar);
		final EditText editRestar = (EditText) findViewById(R.id.edit_puntos_a_restar);
		final EditText editMax = (EditText) findViewById(R.id.edit_puntos_max);
		final EditText editMin = (EditText) findViewById(R.id.edit_puntos_min);

		editDefecto.setText(Integer.toString(datosAjustes.getValorDefecto()));
		editSumar.setText(Integer.toString(datosAjustes.getValorSumar()));
		editRestar.setText(Integer.toString(datosAjustes.getValorRestar()));
		editMax.setText(Integer.toString(datosAjustes.getValorMax()));
		editMin.setText(Integer.toString(datosAjustes.getValorMin()));

		Button btnAceptar = (Button) findViewById(R.id.btn_aceptar);

		btnAceptar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int valorDefecto = Integer.valueOf(editDefecto.getText()
						.toString());
				int valorSumar = Integer
						.valueOf(editSumar.getText().toString());
				int valorRestar = Integer.valueOf(editRestar.getText()
						.toString());
				int valorMax = Integer.valueOf(editMax.getText().toString());
				int valorMin = Integer.valueOf(editMin.getText().toString());
				almacenAjustes.guardarAjustes(new AjustesGenerico(valorDefecto,
						valorSumar, valorRestar, valorMax, valorMin));

				AjustesGenerico datosAjustes = almacenAjustes.cargarAjustes();

				Intent intent = new Intent();
				intent.putExtra("defecto", datosAjustes.getValorDefecto());
				intent.putExtra("sumar", datosAjustes.getValorSumar());
				intent.putExtra("restar", datosAjustes.getValorRestar());
				intent.putExtra("max", datosAjustes.getValorMax());
				intent.putExtra("min", datosAjustes.getValorMin());
				setResult(RESULT_OK, intent);

				finish();
			}
		});
	}
}
