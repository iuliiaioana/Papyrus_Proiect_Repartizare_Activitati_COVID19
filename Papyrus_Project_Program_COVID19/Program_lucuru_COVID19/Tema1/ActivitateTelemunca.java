package Tema1;

public class ActivitateTelemunca extends Activitate {

	private String platformaOnline;

	public ActivitateTelemunca(TipMunca tipMunca, TipActivitate tipActivitate, int nrOre, String platformaOnline) {
		super(tipMunca, tipActivitate, nrOre);
		this.platformaOnline = platformaOnline;

	}

};
