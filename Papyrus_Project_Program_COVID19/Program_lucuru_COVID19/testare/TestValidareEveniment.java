package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Tema1.ActivitateBirou;
import Tema1.Angajat;
import Tema1.Companie;
import Tema1.ContractAngajare;
import Tema1.Localitate;
import Tema1.Sala;
import Tema1.TipActivitate;
import Tema1.TipMunca;
import Tema1.TipSala;

class TestValidareEveniment {

	@Test
	void test() {

		ContractAngajare c1 = new ContractAngajare(LocalDate.of(2021, 9, 23), 35, 15000, TipMunca.Birou);
		ContractAngajare c2 = new ContractAngajare(LocalDate.of(2021, 1, 23), 35, 15000, TipMunca.Birou);
		ContractAngajare c3 = new ContractAngajare(LocalDate.of(2021, 1, 23), 35, 15067, TipMunca.Birou);
		Angajat p2 = new Angajat("bataraga", "georgiana", LocalDate.of(2018, 9, 23), "ceo", "IT", c1);
		Angajat p3 = new Angajat("calin", "roberta", LocalDate.of(2016, 9, 23), "ceo", "HR", c2);
		Angajat p4 = new Angajat("calin", "roberta", LocalDate.of(2016, 9, 23), "ceo", "HR", c2);
		List<Angajat> angajati = new ArrayList<>();
		angajati.add(p3);
		angajati.add(p2);
		Localitate l1 = new Localitate("focsani", "vrancea", "verde", (float) 0.54);
		Localitate l2 = new Localitate("bucuresti", "bucuresti", "rosu", (float) 3.54);
		Localitate l3 = new Localitate("bucuresti", "if", "rosu", (float) 3.59);

		List<Localitate> localitati = new ArrayList<>();
		localitati.add(l1);
		localitati.add(l2);

		Sala s1 = new Sala(TipSala.SalaConferinta, 1, 10);

		Companie c = new Companie("4PSA", LocalDate.of(1921, 9, 23), 400, angajati, localitati, 12);
		c.adaugaSala(TipSala.SalaConferinta, 15, 10);
		c.adaugaSala(TipSala.SpatiuComun, 12, 5);

		ActivitateBirou a1 = new ActivitateBirou(TipMunca.Birou, TipActivitate.Sedinta, 3, l1, s1, c);
		assertTrue(a1.creareActivitate(angajati));

//		daca schimb dispnibilitatea la un angajat 
		p2.setDisponibilitate(false);
		ActivitateBirou a2 = new ActivitateBirou(TipMunca.Birou, TipActivitate.Sedinta, 3, l1, s1, c);
		assertFalse(a2.creareActivitate(angajati));

//		daca stabilesc regimu de munca in companie telemunca
		ActivitateBirou a3 = new ActivitateBirou(TipMunca.Birou, TipActivitate.Sedinta, 3, l1, s1, c);
		p2.setDisponibilitate(true);
		c.setRegimMunca(TipMunca.Telemunca);
		assertFalse(a3.creareActivitate(angajati));
//		daca schimb scenariu la localitate unde are loc evenimentu in rosu
		ActivitateBirou a4 = new ActivitateBirou(TipMunca.Birou, TipActivitate.Sedinta, 3, l1, s1, c);
		c.setRegimMunca(TipMunca.Birou);
		l1.setScenariu("rosu");
		assertFalse(a4.creareActivitate(angajati));

//		revin la scenariu normal si alegem o sala care e deja ocupata
		ActivitateBirou a5 = new ActivitateBirou(TipMunca.Birou, TipActivitate.Sedinta, 3, l1, s1, c);
		l1.setScenariu("verde");
		s1.setOcupata(true);
		assertFalse(a5.creareActivitate(angajati));

	}

}
