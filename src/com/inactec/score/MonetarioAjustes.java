package com.inactec.score;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MonetarioAjustes extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajustes_monetario);
		final AlmacenAjustesMonetario almacenAjustes = new AlmacenAjustesMonetario(
				this);
		AjustesMonetario datosAjustes = almacenAjustes.cargarAjustes();

		// Cargar datos de XML local
		final EditText editDefecto = (EditText) findViewById(R.id.edit_puntos_por_defecto);
		final EditText editSumar = (EditText) findViewById(R.id.edit_puntos_a_sumar);
		final EditText editRestar = (EditText) findViewById(R.id.edit_puntos_a_restar);
		final EditText editMax = (EditText) findViewById(R.id.edit_puntos_max);
		final EditText editMin = (EditText) findViewById(R.id.edit_puntos_min);

		editDefecto.setText(Float.toString(datosAjustes.getValorDefecto()));
		editSumar.setText(Float.toString(datosAjustes.getValorSumar()));
		editRestar.setText(Float.toString(datosAjustes.getValorRestar()));
		editMax.setText(Float.toString(datosAjustes.getValorMax()));
		editMin.setText(Float.toString(datosAjustes.getValorMin()));

		Button btnAceptar = (Button) findViewById(R.id.btn_aceptar);

		btnAceptar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				float valorDefecto = Float.valueOf(editDefecto.getText()
						.toString());
				float valorSumar = Float
						.valueOf(editSumar.getText().toString());
				float valorRestar = Float.valueOf(editRestar.getText()
						.toString());
				float valorMax = Float.valueOf(editMax.getText().toString());
				float valorMin = Float.valueOf(editMin.getText().toString());
				almacenAjustes.guardarAjustes(new AjustesMonetario(valorDefecto,
						valorSumar, valorRestar, valorMax, valorMin));

				AjustesMonetario datosAjustes = almacenAjustes.cargarAjustes();

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
