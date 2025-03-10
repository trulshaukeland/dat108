package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks2countmatch {

	public static void main(String[] args) {

		//Alle forbokstavene i fornavnene i en streng "CLTCM" - reduce() 

		String alleForbokstaver = people.stream()
		.map(p -> String.valueOf(p.firstName().charAt(0)))
		.reduce("", (acc, letter) -> acc + letter);

		System.out.println("Alle forbokstaver i alle navn: " + alleForbokstaver);
		//Antall personer over 50 år - count()

		double antallPersonerOver50 = people.stream()
		.filter(p -> p.age() > 50)
		.count();

		System.out.println("Antall personer over 50: " + antallPersonerOver50);
		
		//Er alle over 30 år?

		boolean alleOver30 = people.stream()
		.allMatch(p -> p.age() > 30);

		System.out.println("Alle over 30: " + alleOver30);
		//Er noen over 60 år?
		boolean noenOver60 = people.stream()
		.anyMatch(p -> p.age() > 60);

		System.out.println("Noen over 60: " + noenOver60);
	}

}




