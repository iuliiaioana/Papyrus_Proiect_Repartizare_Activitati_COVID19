package Tema1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Localitate {

	private String nume;
	private String judet;
	private String scenariu;
	private float rataIncidenta;
	private TipMunca regimMuncaLocalitate;

	public Localitate(String nume, String judet, String scenariu, float rataIncidenta) {
		this.nume = nume;
		this.judet = judet;
		this.scenariu = scenariu;
		this.rataIncidenta = rataIncidenta;
		stabilireRegim();
	}

	public void stabilireRegim() {
		if (this.scenariu.equals("rosu")) {
			this.regimMuncaLocalitate = TipMunca.Telemunca;
		} else {
			this.regimMuncaLocalitate = TipMunca.Birou;
		}
	}

	public void actualizareRata(float rataIncidentaNoua) {
		this.rataIncidenta = rataIncidentaNoua;
	}

	public void calculeazaScenariu() {
		if (this.rataIncidenta > 3) {
			this.scenariu = "rosu";
		} else {
			this.scenariu = "verde";
		}
	}

	public TipMunca raportarePeLocalitate() {
		if (this.scenariu.equals("rosu")) {
			return TipMunca.Telemunca;
		} else {
			return TipMunca.Birou;
		}
	}

	// daca avem mai mult de jumatate din angajatii care trebuie sa participe la o
	// activitate bolnavi, replanificam activitatea respectiva
	// daca mai mult de jumatate din activitati trebuie replanficate din cauza
	// angajatilor bolnavi, compania trece in regim de telemunca
	// daca scenariul este diferit fata de cel initial, replanificam activitatile -
	// se schimba regimul de munca
	// daca scenariul este rosu, bugetul alocat de finantatori pentru companie este
	// redus cu 5%
	public boolean situatieActualaModificata(List<Activitate> activitati, String scenariuNou, Companie companie) {
		int angajatiBolnavi = 0;
		int activitatiReplanificate = 0;

		if (activitati == null) {
			return false;
		} else {
			for (Activitate a : activitati) {
				for (Angajat angajat : a.getAngajati()) {
					if (angajat.isBolnav() == true) {
						angajatiBolnavi++;
					}
				}

				if (angajatiBolnavi > a.getAngajati().size() / 2) {
					activitatiReplanificate++;
				}
			}

			if (activitatiReplanificate > activitati.size() / 2) {
				return true;
			} else {
				if (scenariuNou.equals(this.scenariu)) {
					return false;
				} else {
					if (scenariuNou.equals("rosu")) {
						setScenariu("rosu");
						this.stabilireRegim();
						companie.setBuget(companie.getBuget() - 0.05 * companie.getBuget());
					} else {
						setScenariu("verde");
						this.stabilireRegim();
					}

					return true;
				}
			}
		}
	}

	public void salvareFisier() {
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Localitatea " + this.nume + " are rata de incidenta " + this.rataIncidenta
					+ " si se incadreaza in scenariul " + this.scenariu);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getJudet() {
		return judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public String getScenariu() {
		return scenariu;
	}

	public void setScenariu(String scenariu) {
		this.scenariu = scenariu;
	}

	public float getRataIncidenta() {
		return rataIncidenta;
	}

	public void setRataIncidenta(float rataIncidenta) {
		this.rataIncidenta = rataIncidenta;
	}

	public TipMunca getRegimMunca() {
		return this.regimMuncaLocalitate;
	}

};
