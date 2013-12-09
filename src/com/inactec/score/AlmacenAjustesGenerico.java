package com.inactec.score;

import android.content.Context;
import android.content.SharedPreferences;

public class AlmacenAjustesGenerico {
	private static String ajustesGenerico = "aGenerico";
	private Context context;
	private AjustesGenerico ajustesG;
	
	public AlmacenAjustesGenerico(Context context){
		this.context = context;
		this.ajustesG = new AjustesGenerico(0, 0, 0, 0, 0);
	}
	
	public void guardarAjustes(AjustesGenerico ajustesG){
		SharedPreferences ajustes = context.getSharedPreferences(ajustesGenerico, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = ajustes.edit();
		
		editor.putInt("Defecto", ajustesG.getValorDefecto());
		editor.putInt("Sumar", ajustesG.getValorSumar());
		editor.putInt("Restar", ajustesG.getValorRestar());
		editor.putInt("Max", ajustesG.getValorMax());
		editor.putInt("Min", ajustesG.getValorMin());
		editor.commit();		
	}

	public AjustesGenerico cargarAjustes() {
		SharedPreferences ajustes = context.getSharedPreferences(ajustesGenerico, Context.MODE_PRIVATE);
		
		this.ajustesG.setValorDefecto(ajustes.getInt("Defecto", 0));
		this.ajustesG.setValorSumar(ajustes.getInt("Sumar", 1));
		this.ajustesG.setValorRestar(ajustes.getInt("Restar", 1));
		this.ajustesG.setValorMax(ajustes.getInt("Max", 100));
		this.ajustesG.setValorMin(ajustes.getInt("Min", 0));
		return this.ajustesG;
	}
}
