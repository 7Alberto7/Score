package com.inactec.score;

import android.content.Context;
import android.content.SharedPreferences;

public class AlmacenAjustesMonetario {
	private static String ajustesMonetario = "aMonetario";
	private Context context;
	private AjustesMonetario ajustesM;
	
	public AlmacenAjustesMonetario(Context context){
		this.context = context;
		this.ajustesM = new AjustesMonetario(0, 0, 0, 0, 0);
	}
	
	public void guardarAjustes(AjustesMonetario ajustesM){
		SharedPreferences ajustes = context.getSharedPreferences(ajustesMonetario, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = ajustes.edit();
		
		editor.putFloat("Defecto", ajustesM.getValorDefecto());
		editor.putFloat("Sumar", ajustesM.getValorSumar());
		editor.putFloat("Restar", ajustesM.getValorRestar());
		editor.putFloat("Max", ajustesM.getValorMax());
		editor.putFloat("Min", ajustesM.getValorMin());
		editor.commit();		
	}

	public AjustesMonetario cargarAjustes() {
		SharedPreferences ajustes = context.getSharedPreferences(ajustesMonetario, Context.MODE_PRIVATE);
		
		this.ajustesM.setValorDefecto(ajustes.getFloat("Defecto", 0));
		this.ajustesM.setValorSumar(ajustes.getFloat("Sumar", 1));
		this.ajustesM.setValorRestar(ajustes.getFloat("Restar", 1));
		this.ajustesM.setValorMax(ajustes.getFloat("Max", 100));
		this.ajustesM.setValorMin(ajustes.getFloat("Min", 0));
		return this.ajustesM;
	}
}
