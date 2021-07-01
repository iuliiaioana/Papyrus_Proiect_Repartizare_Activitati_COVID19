package Tema1;

import java.util.List;
import java.util.ArrayList;

public class Activitate {

	private TipMunca tipMunca;
	private TipActivitate tipActivitate;
	private int nrOre;
	private MasinaStareActivitate stare;
	List<Angajat> angajati = new ArrayList<>();

	public Activitate(TipMunca tipMunca, TipActivitate tipActivitate, int nrOre) {
		this.tipMunca = tipMunca;
		this.tipActivitate = tipActivitate;
		this.nrOre = nrOre;

	}

	public void schimbareTipMunca(TipMunca tipMuncaNou) {
		this.tipMunca = tipMuncaNou;
	}

	public TipMunca getTipMunca() {
		return tipMunca;
	}

	public void setTipMunca(TipMunca tipMunca) {
		this.tipMunca = tipMunca;
	}

	public TipActivitate getTipActivitate() {
		return tipActivitate;
	}

	public void setTipActivitate(TipActivitate tipActivitate) {
		this.tipActivitate = tipActivitate;
	}

	public int getNrOre() {
		return nrOre;
	}

	public void setNrOre(int nrOre) {
		this.nrOre = nrOre;
	}

	public MasinaStareActivitate getStare() {
		return stare;
	}

	public void setStare(MasinaStareActivitate stare) {
		this.stare = stare;
	}

	public List<Angajat> getAngajati() {
		return angajati;
	}

	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}

	public void adaugaAngajat(Angajat angajat) {
		this.angajati.add(angajat);
	}

	public void schimbareTipActivitate(TipActivitate tipActivitateNou) {
		this.tipActivitate = tipActivitateNou;
	}

	public void schimbareNrOre(int nrOreNou) {
		this.nrOre = nrOreNou;
	}

	// pentru crearea unei activitati toti angajatii trebuie sa fie disponibili
	public boolean solicitaParticipare(List<Angajat> angajati) {
		for (Angajat a : angajati) {
			if (a.verificaDisponibilitate()) {
				a.adaugaActivitate(this);
				this.angajati.add(a);
			} else {
				System.out.println("Angajatul " + a.getNume() + " " + a.getPrenume() + " nu este disponibil");
				return false;
			}
		}

		return true;
	}

	public void afisareDetaliiActivitate() {
		System.out.println("Activitatea " + this.tipActivitate + " cu tipul de munca " + this.tipMunca
				+ " si numarul de ore " + this.nrOre);
	}

	public void afisareDetaliiAngajatiActivitate() {
		for (Angajat a : angajati) {
			a.afisareDetaliiAngajat();
		}
	}

	public void confirmare() {
		System.out.println("Activitate confirmata.");
	}

	public void modificare() {
		System.out.println("Activitate a fost modificata.");
	}

	public void finalizare() {
		System.out.println("Activitate a fost finalizata.");
	}

	public void anulare() {
		System.out.println("Activitate a fost anulata.");
	}

};
