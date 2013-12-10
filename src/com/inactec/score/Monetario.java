package com.inactec.score;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Monetario extends Activity {

    Button btAdd;
    ListView lvDatos;
    EditText etDatos;
    float puntosInicio;
    AjustesMonetario datosAjustes;
    AlmacenAjustesMonetario almacenAjustes;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generico);
        almacenAjustes = new AlmacenAjustesMonetario(this);
        datosAjustes = almacenAjustes.cargarAjustes();
        puntosInicio = datosAjustes.getValorDefecto();
        
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // If your minSdkVersion is 11 or higher, instead use:
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        btAdd = (Button) findViewById(R.id.btAgregar);
        lvDatos = (ListView) findViewById(R.id.lvDatos);
        etDatos = (EditText) findViewById(R.id.etDatos);
        
        final ListaPuntuacionesM mLista = new ListaPuntuacionesM();
        final ListViewMonetario mAdapter = new ListViewMonetario(this, mLista, almacenAjustes);
        lvDatos.setAdapter(mAdapter);
        
        btAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (etDatos.getText().length() > 0) {
					mLista.aniadirPuntuacion(new PuntuacionM(etDatos.getText().toString(), puntosInicio));
					mAdapter.notifyDataSetChanged();
					etDatos.setText("");
				}
				
			}
		});
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	    super.onCreateOptionsMenu(menu);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_generico, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
			case R.id.menu_ajustes:
					cargarAjustes();
					break;
        }
        return true;
	}
	
	public void cargarAjustes(){
		Intent i= new Intent(this, MonetarioAjustes.class);
		
		startActivityForResult(i, 1234);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
			if(requestCode == 1234 && resultCode == RESULT_OK){
				datosAjustes.setValorDefecto(data.getExtras().getFloat("defecto"));
				datosAjustes.setValorSumar(data.getExtras().getFloat("sumar"));
				datosAjustes.setValorRestar(data.getExtras().getFloat("restar"));
				datosAjustes.setValorMax(data.getExtras().getFloat("max"));
				datosAjustes.setValorMin(data.getExtras().getFloat("min"));
				puntosInicio = datosAjustes.getValorDefecto();
			}
	}

}
