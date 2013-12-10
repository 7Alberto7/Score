package com.inactec.score;

public class AjustesMonetario {
	private float valorDefecto;
	private float valorSumar;
	private float valorRestar;
	private float valorMax;
	private float valorMin;

	public AjustesMonetario(float valorDefecto, float valorSumar, float valorRestar,
			float valorMax, float valorMin) {
		this.valorDefecto = valorDefecto;
		this.valorSumar = valorSumar;
		this.valorRestar = valorRestar;
		this.valorMax = valorMax;
		this.valorMin = valorMin;
	}

	public float getValorDefecto() {
		return valorDefecto;
	}

	public void setValorDefecto(float valorDefecto) {
		this.valorDefecto = valorDefecto;
	}

	public float getValorSumar() {
		return valorSumar;
	}

	public void setValorSumar(float valorSumar) {
		this.valorSumar = valorSumar;
	}

	public float getValorRestar() {
		return valorRestar;
	}

	public void setValorRestar(float valorRestar) {
		this.valorRestar = valorRestar;
	}

	public float getValorMax() {
		return valorMax;
	}

	public void setValorMax(float valorMax) {
		this.valorMax = valorMax;
	}

	public float getValorMin() {
		return valorMin;
	}

	public void setValorMin(float valorMin) {
		this.valorMin = valorMin;
	}
}
