package Tema1;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicatie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContractAngajare c1 = new ContractAngajare(LocalDate.of(2021, 9, 23), 35, 15000, TipMunca.Birou);
		ContractAngajare c2 = new ContractAngajare(LocalDate.of(2021, 1, 23), 35, 15000, TipMunca.Birou);
		ContractAngajare c3 = new ContractAngajare(LocalDate.of(2021, 1, 23), 35, 15067, TipMunca.Birou);

		Persoana p1 = new Persoana("anghel", "iulia", LocalDate.of(2016, 9, 23));

		Angajat p2 = new Angajat("bataraga", "georgiana", LocalDate.of(2018, 9, 23), "ceo", "IT", c1);
		Angajat p3 = new Angajat("calin", "roberta", LocalDate.of(2016, 9, 23), "ceo", "HR", c2);
		Angajat p4 = new Angajat("calin", "roberta", LocalDate.of(2016, 9, 23), "ceo", "HR", c2);

//verificare persoana
//		p1.afisareDetaliiPersoana();

//		verficare angajat
//		p2.afisareDetaliiAngajat();
		p2.schimbaDepartament("Sales");
		p2.schimbaFunctie("intern");
//		p2.afisareDetaliiAngajat();
		// met prin mostenire
//		p3.afisareDetaliiPersoana();
//		System.out.println(p4.verificaDisponibilitate());

		Activitate a = new Activitate(TipMunca.Telemunca, TipActivitate.Sedinta, 3);
		Activitate a2 = new Activitate(TipMunca.Telemunca, TipActivitate.Planning, 3);
		p2.adaugaActivitate(a);
		p2.adaugaActivitate(a2);
		a.adaugaAngajat(p2);

		p3.adaugaActivitate(a);
		a.adaugaAngajat(p3);

//		p2.afisareDetaliiAngajat();
//		a.afisareDetaliiAngajatiActivitate();
//		a.confirmare();
//		a.modificare();
//		a.finalizare();
//		a.anulare();
		List<Angajat> angajati = new ArrayList<>();
		angajati.add(p3);
		angajati.add(p2);
		p2.setDisponibilitate(false);
//		System.out.println(a.solicitaParticipare(angajati));

//		verificare contract

//		c1.afisareDetaliiContract();
//		c1.schimbareSalariu(1300);
//		c1.schimbareTipMunca(TipMunca.Telemunca);
//		c1.afisareDetaliiContract();
//		
//	
		Localitate l1 = new Localitate("focsani", "vrancea", "verde", (float) 0.54);
		Localitate l2 = new Localitate("bucuresti", "bucuresti", "rosu", (float) 3.54);
		Localitate l3 = new Localitate("bucuresti", "if", "rosu", (float) 3.59);

		List<Localitate> localitati = new ArrayList<>();
		localitati.add(l1);
		localitati.add(l2);

		Companie c = new Companie("4PSA", LocalDate.of(1921, 9, 23), 400, angajati, localitati, 40);
		c.adaugaSala(TipSala.SalaConferinta, 15, 10);
		c.adaugaSala(TipSala.SpatiuComun, 12, 5);
		c.afisareDetalii();

		c.adaugaLocalitate(l3);

		c.adaugaAngajati(p4);

		System.out.println(l1.raportarePeLocalitate());
		l1.actualizareRata(4);
		l1.calculeazaScenariu();
		System.out.println(l1.raportarePeLocalitate());
		l1.salvareFisier();
	}

}
