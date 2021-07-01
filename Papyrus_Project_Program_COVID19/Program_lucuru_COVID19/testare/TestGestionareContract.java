package testare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Tema1.Angajat;
import Tema1.Companie;
import Tema1.ContractAngajare;
import Tema1.Localitate;
import Tema1.TipMunca;

public class TestGestionareContract {

	@Test
	void testModificareContract() {
		ContractAngajare c1 = new ContractAngajare(LocalDate.of(2021, 1, 7), 40, 6500, TipMunca.Birou);
		ContractAngajare c2 = new ContractAngajare(LocalDate.of(2021, 5, 25), 40, 4500, TipMunca.Birou);
		ContractAngajare c3 = new ContractAngajare(LocalDate.of(2021, 4, 15), 20, 3000, TipMunca.Telemunca);
		ContractAngajare c4 = new ContractAngajare(LocalDate.of(2021, 5, 15), 20, 3000, TipMunca.Birou);

		c4.setAnulat(false);

		List<Angajat> angajati = new ArrayList<>();
		Angajat a1 = new Angajat("Calin", "Marian", LocalDate.of(1995, 5, 14), "HR Specialist", "HR", c1);
		Angajat a2 = new Angajat("Popa", "Ioana", LocalDate.of(1999, 3, 1), "Software Engineer", "IT", c2);
		Angajat a3 = new Angajat("Oprea", "Andreea", LocalDate.of(1996, 6, 24), "Data Scientist Intern", "IT", c3);
		Angajat a4 = new Angajat("Paun", "Marius", LocalDate.of(1990, 9, 2), "CEO", "IT", c4);

		a1.setBolnav(true);

		angajati.add(a1);
		angajati.add(a2);
		angajati.add(a3);
		angajati.add(a4);

		Localitate l1 = new Localitate("focsani", "vrancea", "verde", (float) 1.54);
		Localitate l2 = new Localitate("bucuresti", "bucuresti", "verde", (float) 2.54);
		Localitate l3 = new Localitate("bucuresti", "if", "rosu", (float) 3.59);

		List<Localitate> localitati = new ArrayList<>();
		localitati.add(l1);
		localitati.add(l2);
		localitati.add(l3);

		Companie companie = new Companie("IBM", LocalDate.of(1975, 10, 23), 1500, angajati, localitati, 300000);
		companie.stabillireRegimMunca();

		// angajatul nu mai are contractul valabil
		assertFalse(c1.modificareContract(a1, companie, l1));

		// angajatul nu este bolnav si lucreaza la birou
		assertTrue(c2.modificareContract(a2, companie, l2));
		assertEquals(TipMunca.Birou, c2.getTipMunca());

		// a 3-a localitate intra in scenariul verde si se modifica si tipul de munca
		// din contract
		l3.setScenariu("verde");
		assertTrue(c3.modificareContract(a3, companie, l3));
		assertEquals(TipMunca.Birou, c1.getTipMunca());

		// angajatul 4 este bolnav si tipul de munca este telemunca
		a4.setBolnav(true);
		assertFalse(c4.modificareContract(a4, companie, l1));
		assertEquals(TipMunca.Telemunca, c4.getTipMunca());

	}

}
