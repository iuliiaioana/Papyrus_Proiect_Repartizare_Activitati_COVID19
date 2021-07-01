package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Tema1.Activitate;
import Tema1.Angajat;
import Tema1.Companie;
import Tema1.ContractAngajare;
import Tema1.Localitate;
import Tema1.TipActivitate;
import Tema1.TipMunca;

class TestVerificareSituatieActuala {

	@Test
	void testSituatieActualaModificata() {

		ContractAngajare c1 = new ContractAngajare(LocalDate.of(2019, 7, 20), 40, 10000, TipMunca.Birou);
		ContractAngajare c2 = new ContractAngajare(LocalDate.of(2020, 9, 23), 20, 3000, TipMunca.Birou);
		ContractAngajare c3 = new ContractAngajare(LocalDate.of(2015, 3, 23), 40, 12000, TipMunca.Birou);
		ContractAngajare c4 = new ContractAngajare(LocalDate.of(2000, 1, 15), 40, 30000, TipMunca.Birou);
		ContractAngajare c5 = new ContractAngajare(LocalDate.of(2021, 3, 9), 40, 7000, TipMunca.Birou);
		ContractAngajare c6 = new ContractAngajare(LocalDate.of(2010, 5, 5), 40, 15000, TipMunca.Birou);
		ContractAngajare c7 = new ContractAngajare(LocalDate.of(2020, 2, 27), 20, 9500, TipMunca.Birou);

		List<Angajat> angajati = new ArrayList<>();
		Angajat a1 = new Angajat("Popescu", "Maria", LocalDate.of(1997, 2, 10), "developer", "IT", c1);
		a1.setBolnav(true);
		Angajat a2 = new Angajat("Ionescu", "Catalin", LocalDate.of(1990, 10, 22), "recruiter", "HR", c2);
		a2.setBolnav(true);
		Angajat a3 = new Angajat("Marcu", "Daniela", LocalDate.of(1998, 8, 28), "developer", "IT", c3);
		Angajat a4 = new Angajat("Petrescu", "Marius", LocalDate.of(1982, 6, 15), "director", "IT", c4);
		Angajat a5 = new Angajat("Marculescu", "Oana", LocalDate.of(1999, 12, 20), "developer", "IT", c5);
		a5.setBolnav(true);
		Angajat a6 = new Angajat("Popa", "Lucian", LocalDate.of(1993, 2, 3), "manager", "IT", c6);
		Angajat a7 = new Angajat("Lungu", "Octavian", LocalDate.of(1998, 8, 1), "developer", "IT", c7);
		angajati.add(a1);
		angajati.add(a2);
		angajati.add(a3);
		angajati.add(a4);
		angajati.add(a5);
		angajati.add(a6);
		angajati.add(a7);

		Localitate l1 = new Localitate("Focsani", "Vrancea", "verde", (float) 0.54);
		Localitate l2 = new Localitate("Bucuresti", "Bucuresti", "rosu", (float) 3.54);
		Localitate l3 = new Localitate("Turnu Magurele", "Teleorman", "rosu", (float) 2.9);

		List<Localitate> localitati = new ArrayList<>();
		localitati.add(l1);
		localitati.add(l2);
		localitati.add(l3);

		Companie companie = new Companie("Amazon", LocalDate.of(1994, 7, 5), 200, angajati, localitati, 200000);
		companie.stabillireRegimMunca();

		Activitate activitate1 = new Activitate(TipMunca.Birou, TipActivitate.Planning, 2);
		activitate1.adaugaAngajat(a1);
		activitate1.adaugaAngajat(a2);
		activitate1.adaugaAngajat(a3);

		Activitate activitate2 = new Activitate(TipMunca.Birou, TipActivitate.Raportare, 1);
		activitate2.adaugaAngajat(a4);
		activitate2.adaugaAngajat(a6);
		activitate2.adaugaAngajat(a7);

		Activitate activitate3 = new Activitate(TipMunca.Birou, TipActivitate.Sedinta, 2);
		activitate3.adaugaAngajat(a2);
		activitate3.adaugaAngajat(a5);
		activitate3.adaugaAngajat(a7);

		Activitate activitate4 = new Activitate(TipMunca.Telemunca, TipActivitate.Videocall, 3);
		activitate4.adaugaAngajat(a1);
		activitate4.adaugaAngajat(a3);

		Activitate activitate5 = new Activitate(TipMunca.Telemunca, TipActivitate.ActivitateIndividuala, 8);
		activitate5.adaugaAngajat(a7);

		List<Activitate> activitati1 = new ArrayList<>();
		activitati1.add(activitate1);
		activitati1.add(activitate2);
		activitati1.add(activitate3);

		List<Activitate> activitati2 = new ArrayList<>();
		activitati2.add(activitate4);
		activitati2.add(activitate5);

		// 2 din cele 3 activitati trebuie replanificate
		assertTrue(l1.situatieActualaModificata(activitati1, "verde", companie));

		// nu se replanifica activitati, scenariul este acelasi
		assertFalse(l2.situatieActualaModificata(activitati2, "rosu", companie));

		// initial scenariul in localitatea 3 este rosu
		assertEquals("rosu", l3.getScenariu());
		// initial regimul de munca este Telemunca
		assertEquals(TipMunca.Telemunca, l3.getRegimMunca());

		// nu se replanifica activitati, se schimba scenariul
		assertTrue(l3.situatieActualaModificata(activitati2, "verde", companie));
		assertEquals("verde", l3.getScenariu());

		// s-a schimbat scenariul, deci s-a schimbat si regimul de munca
		assertEquals(TipMunca.Birou, l3.getRegimMunca());

	}

}
