package Tema1;

public class Sala {

	private TipSala tipSala;
	private int nrLocuri;
	private int numar;
	private boolean ocupata = false;

	public Sala(TipSala tipSala, int nrLocuri, int numar) {
		this.tipSala = tipSala;
		this.nrLocuri = nrLocuri;
		this.numar = numar;
	}

	public TipSala getTipSala() {
		return tipSala;
	}

	public void setTipSala(TipSala tipSala) {
		this.tipSala = tipSala;
	}

	public int getNrLocuri() {
		return nrLocuri;
	}

	public void setNrLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public boolean isOcupata() {
		return ocupata;
	}

	public void setOcupata(boolean ocupata) {
		this.ocupata = ocupata;
	}

	public boolean verificaDisponibilitate() {

		return !this.ocupata;

	}

	public void adaugaLocuri(int nrLocuri) {

		this.nrLocuri += nrLocuri;
	}

};
