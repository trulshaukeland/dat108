package no.hvl.dat108.f04;

import static no.hvl.dat108.f04.People.people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Eksempel1 / Oppgave i timen
 * 
 * I dette eksemplet skal en liste av Personer gjøres om til en liste
 * av Stringer. Hvordan omformingen fra Person til String skal gjøres
 * skal oppgis som en parameter til metoden hjelpemetoden tilListeAvString().
 * 
 */
public class Eksempel1 {
	
	// Method to convert List<Person> to List<String>
	public static List<String> tilListeAvString(List<Person> liste, Function<Person, String> omformer) {
		
		List<String> resultat = new ArrayList<>();
		
		// Convert each Person to String using the function
		for (Person p : liste) {
			resultat.add(omformer.apply(p)); // Apply the given function
		}
				
		return resultat;
	}

	public static void main(String[] args) {
		
		// Convert list of People to a list of first names
		List<String> fornavnene = tilListeAvString(people, Person::firstName);
		System.out.println(fornavnene);		

		// Convert list of People to a list of last names
		List<String> etternavnene = tilListeAvString(people, Person::lastName);
		System.out.println(etternavnene);	

		// Convert list of People to a custom formatted string
		List<String> fullBeskrivelse = tilListeAvString(people, p -> p.firstName() + " " + p.lastName() + " is " + p.age() + " years old.");
		System.out.println(fullBeskrivelse);
	}
}