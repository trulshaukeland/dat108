package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

import java.util.stream.Collectors;

public class Eks1reduce {
	
	public static void main(String[] args) {
		
		/* Summen av aldrene til personene i people-listen */
	        int totalAge = people.stream()
            .mapToInt(p -> p.age())
            .sum();

        System.out.println("Total alder: " + totalAge);

		/* En streng med alle initialene, "CD LC TC CB MA" */
        String initials = people.stream()
            .map(p -> p.firstName().charAt(0) + "" + p.lastName().charAt(0))
            .collect(Collectors.joining(" "));

        System.out.println("Initialer: " + initials);
	}	
}
