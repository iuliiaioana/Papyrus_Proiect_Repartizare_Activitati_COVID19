package Tema1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Companie {
	private String nume;
	private LocalDate dataInfiintare;
	private int nrAngajati;
	TipMunca regimMunca = TipMunca.Birou;
	private List<Angajat> angajati = new ArrayList<>();
	private List<Localitate> localitati = new ArrayList<>();
	private List<Sala> sali;
	private double buget;

	public TipMunca getRegimMunca() {
		return regimMunca;
	}

	public void setRegimMunca(TipMunca regimMunca) {
		this.regimMunca = regimMunca;
	}

	public Companie(String nume, LocalDate dataInfiintare, int nrAngajati, List<Angajat> angajati,
			List<Localitate> localitati, double buget) {
		this.nume = nume;
		this.dataInfiintare = dataInfiintare;
		this.nrAngajati = nrAngajati;
		this.angajati = angajati;
		this.localitati = localitati;
		this.sali = new ArrayList<>();
		this.buget = buget;
	}

	public void afisareDetalii() {
		System.out.println("Nume: " + this.nume);
		System.out.println("Data infiintare: " + this.dataInfiintare);
		System.out.println("Numar angajati: " + this.nrAngajati);
		System.out.println("Buget alocat de finantatori: " + this.buget);
	}

	public void adaugaAngajati(Angajat angajat) {
		this.angajati.add(angajat);
		this.nrAngajati++;
	}

	public void adaugaSala(TipSala tipSala, int nrLocuri, int numar) {
		Sala s = new Sala(tipSala, nrLocuri, numar);
		sali.add(s);
	}

	void adaugaLocalitate(Localitate localitate) {
		this.localitati.add(localitate);
	}

	public void schimbaNume(String numeNouCompanie) {
		this.nume = numeNouCompanie;
	}

	public void stabillireRegimMunca() {
		int count = 0;

		for (Localitate l : this.localitati) {
			if (l.getScenariu().equals("rosu")) {
				count++;
			}
		}

		if (count > this.localitati.size() / 2) {
			this.setRegimMunca(TipMunca.Telemunca);
		} else {
			this.setRegimMunca(TipMunca.Birou);
		}
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public LocalDate getDataInfiintare() {
		return dataInfiintare;
	}

	public void setDataInfiintare(LocalDate dataInfiintare) {
		this.dataInfiintare = dataInfiintare;
	}

	public int getNrAngajati() {
		return nrAngajati;
	}

	public void setNrAngajati(int nrAngajati) {
		this.nrAngajati = nrAngajati;
	}

	public List<Angajat> getAngajati() {
		return angajati;
	}

	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}

	public List<Localitate> getLocalitati() {
		return localitati;
	}

	public void setLocalitati(List<Localitate> localitati) {
		this.localitati = localitati;
	}

	public List<Sala> getSali() {
		return sali;
	}

	public void setSali(List<Sala> sali) {
		this.sali = sali;
	}

	public double getBuget() {
		return buget;
	}

	public void setBuget(double buget) {
		this.buget = buget;
	}
};
