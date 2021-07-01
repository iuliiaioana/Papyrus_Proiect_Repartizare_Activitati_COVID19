package Tema1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Angajat extends Persoana {

	private String functie;
	private String departament;
	private boolean disponibilitate = true;
	boolean bolnav = false;
	List<Activitate> activitati = new ArrayList<>();
	private ContractAngajare c;

	public Angajat(String nume, String prenume, LocalDate dataNastere, String functie, String departament,
			ContractAngajare c) {
		super(nume, prenume, dataNastere);
		this.functie = functie;
		this.departament = departament;
		this.c = c;
	}

	public boolean verificaDisponibilitate() {
		return this.disponibilitate;
	}

	public void schimbaDepartament(String departament) {
		this.departament = departament;
	}

	public void adaugaActivitate(Activitate activitate) {
		this.activitati.add(activitate);
	}

	public void afisareDetaliiAngajat() {
		super.afisareDetaliiPersoana();
		System.out.println("Functie: " + this.functie);
		System.out.println("Departament: " + this.departament);

		if (this.disponibilitate) {
			System.out.println("Angajatul este disponibil");
		} else {
			System.out.println("Angajatul nu este disponibil");
		}

		if (this.bolnav) {
			System.out.println("Angajatul este bolnav");
		} else {
			System.out.println("Angajatul nu este bolnav");
		}
		System.out.println("Angajatul are atribuite urmatoarele activitati:");
		if (activitati != null) {
			for (Activitate a : activitati) {
				a.afisareDetaliiActivitate();
			}
		}
	}

	public void schimbaFunctie(String functie) {
		this.functie = functie;
	}

	public String getFunctie() {
		return functie;
	}

	public String getDepartament() {
		return departament;
	}

	public boolean isDisponibilitate() {
		return disponibilitate;
	}

	public void setDisponibilitate(boolean disponibilitate) {
		this.disponibilitate = disponibilitate;
	}

	public boolean isBolnav() {
		return bolnav;
	}

	public void setBolnav(boolean bolnav) {
		this.bolnav = bolnav;
	}

	public List<Activitate> getActivitati() {
		return activitati;
	}

	public void setActivitati(List<Activitate> activitati) {
		this.activitati = activitati;
	}
};
