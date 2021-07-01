package Tema1;

import java.time.LocalDate;

public class ContractAngajare {

	private LocalDate dataAngajare;
	private int nrOre;

	public boolean isAnulat() {
		return anulat;
	}

	public void setAnulat(boolean anulat) {
		this.anulat = anulat;
	}

	public String getStareContract() {
		return stareContract;
	}

	public void setStareContract(String stareContract) {
		this.stareContract = stareContract;
	}

	private int salariu;
	private TipMunca tipMunca;
	private boolean anulat = false;
	private String stareContract = "valabil";

	public ContractAngajare(LocalDate dataAngajare, int nrOre, int salariu, TipMunca tipMunca) {
		this.dataAngajare = dataAngajare;
		this.nrOre = nrOre;
		this.salariu = salariu;
		this.tipMunca = tipMunca;
	}

	// metoda gestionare contract angajare
	// se verifica starea contractului
	// se modifica tipul de munca in functie de regimul de munca al companiei si al
	// localitatii respective
	public boolean modificareContract(Angajat angajat, Companie companie, Localitate localitate) {

		if (this.anulat == true) {
			this.stareContract = "anulat";
			return false;

		} else if ((LocalDate.now().getMonthValue() - this.getDataAngajare().getMonthValue()) >= 3) {
			this.stareContract = "nevalabil";
			reziliereContract();
			return false;

		}

		else if (this.anulat == false) {
			this.stareContract = "valabil";

			if (localitate.getScenariu() == "verde") {
				this.setTipMunca(TipMunca.Birou);
			} else {
				this.setTipMunca(TipMunca.Telemunca);
				return false;
			}

			if (angajat.bolnav == true) {
				this.tipMunca = TipMunca.Telemunca;
				this.schimbareSalariu(this.getSalariu() + 300);
				return false;
			} else {
				this.tipMunca = TipMunca.Birou;
				return true;

			}
		}
		return true;
	}

	public void afisareDetaliiContract() {
		System.out.println("Data angajare: " + this.dataAngajare);
		System.out.println("Numar ore: " + this.nrOre);
		System.out.println("Salariu: " + this.salariu);
		System.out.println("Tip munca: " + this.tipMunca);

	}

	public void reziliereContract() {

		this.dataAngajare = LocalDate.now();
	}

	public void schimbareSalariu(int salariuNou) {

		this.salariu = salariuNou;

	}

	public LocalDate getDataAngajare() {
		return dataAngajare;
	}

	public void setDataAngajare(LocalDate dataAngajare) {
		this.dataAngajare = dataAngajare;
	}

	public int getNrOre() {
		return nrOre;
	}

	public void setNrOre(int nrOre) {
		this.nrOre = nrOre;
	}

	public int getSalariu() {
		return salariu;
	}

	public void setSalariu(int salariu) {
		this.salariu = salariu;
	}

	public TipMunca getTipMunca() {
		return tipMunca;
	}

	public void setTipMunca(TipMunca tipMunca) {
		this.tipMunca = tipMunca;
	}

	public void schimbareTipMunca(TipMunca tipMuncaNou) {

		this.tipMunca = tipMuncaNou;
	}

};
