package com.inactec.score;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

        Button btnGenerico = (Button) findViewById(R.id.btn_generico);
        
        btnGenerico.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cargarMarcadorGenerico();
			}
		});

        Button btnMonetario = (Button) findViewById(R.id.btn_monetario);
        
        btnMonetario.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			}
		});

        Button btnTutorial = (Button) findViewById(R.id.btn_tutorial);
        
        btnTutorial.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			}
		});
        
        btnTutorial.setVisibility(View.INVISIBLE);

        Button btnNosotros = (Button) findViewById(R.id.btn_nosotros);
        
        btnNosotros.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cargarNosotros();
			}
		});
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}*/
	
	public void cargarMarcadorGenerico(){
		Intent i= new Intent(this, Generico.class);
		
		startActivity(i);
	}
	
	public void cargarNosotros(){
		Intent i= new Intent(this, Nosotros.class);
		
		startActivity(i);
	}

}
