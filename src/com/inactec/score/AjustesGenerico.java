package com.inactec.score;

public class AjustesGenerico {
	private int valorDefecto;
	private int valorSumar;
	private int valorRestar;
	private int valorMax;
	private int valorMin;

	public AjustesGenerico(int valorDefecto, int valorSumar, int valorRestar,
			int valorMax, int valorMin) {
		this.valorDefecto = valorDefecto;
		this.valorSumar = valorSumar;
		this.valorRestar = valorRestar;
		this.valorMax = valorMax;
		this.valorMin = valorMin;
	}

	public int getValorDefecto() {
		return valorDefecto;
	}

	public void setValorDefecto(int valorDefecto) {
		this.valorDefecto = valorDefecto;
	}

	public int getValorSumar() {
		return valorSumar;
	}

	public void setValorSumar(int valorSumar) {
		this.valorSumar = valorSumar;
	}

	public int getValorRestar() {
		return valorRestar;
	}

	public void setValorRestar(int valorRestar) {
		this.valorRestar = valorRestar;
	}

	public int getValorMax() {
		return valorMax;
	}

	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}

	public int getValorMin() {
		return valorMin;
	}

	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}
}
