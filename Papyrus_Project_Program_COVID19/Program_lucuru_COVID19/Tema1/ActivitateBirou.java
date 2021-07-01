
package Tema1;

import java.util.List;

public class ActivitateBirou extends Activitate {
	private Sala sala;
	private Localitate local;
	private Companie companie;

	public ActivitateBirou(TipMunca tipMunca, TipActivitate tipActivitate, int nrOre, Localitate local, Sala sala,
			Companie c) {
		super(tipMunca, tipActivitate, nrOre);
		this.sala = sala;
		this.local = local;
		this.companie = c;
	}

	// disponibilitate angajat
	// verificare regim munca la nivel comapanie
	// verificare scenariu localitate
	// verificare disponibilitate sali
	// daca e fizic intalnirea e intr-un singur loc deci are doar o localitate
	// asociata
	public boolean creareActivitate(List<Angajat> angajati) {

		for (Angajat a : angajati) {
			if (a.verificaDisponibilitate() == false) {
				return false;
			}
		}
		if (this.companie.getRegimMunca().equals(TipMunca.Telemunca)) {
			return false;
		} else {
			if (this.getTipMunca() == TipMunca.Birou) {
				if (this.local.getScenariu().equals("rosu")) {
					return false;
				} else {
					if (this.sala.verificaDisponibilitate() == false) {
						return false;
					} else {
						return true;
					}
				}

			} else {
				return false;
			}
		}

	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Localitate getLocal() {
		return local;
	}

	public void setLocal(Localitate local) {
		this.local = local;
	}

	public Companie getCompanie() {
		return companie;
	}

	public void setCompanie(Companie companie) {
		this.companie = companie;
	}
};
