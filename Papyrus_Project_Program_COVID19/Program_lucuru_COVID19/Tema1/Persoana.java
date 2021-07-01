package Tema1;

import java.time.LocalDate;

public class Persoana {

	private String nume;
	private String prenume;
	private LocalDate dataNastere;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public LocalDate getDataNastere() {
		return dataNastere;
	}

	public void setDataNastere(LocalDate dataNastere) {
		this.dataNastere = dataNastere;
	}

	public Persoana(String nume, String prenume, LocalDate dataNastere) {
		this.nume = nume;
		this.prenume = prenume;
		this.dataNastere = dataNastere;
	}

	public void afisareDetaliiPersoana() {

		System.out.println("Nume: " + this.nume);
		System.out.println("Prenume: " + this.prenume);
		System.out.println("Data nasterii: " + this.dataNastere);

	}
};
