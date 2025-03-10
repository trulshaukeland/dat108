package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks1reduce {
	
	public static void main(String[] args) {
		
		/* Summen av aldrene til personene i people-listen */
	        int totalAge = people.stream()
            .mapToInt(p -> p.age())
            .reduce(0, (num1, num2) -> num1 + num2);

        System.out.println("Total alder: " + totalAge);

		/* En streng med alle initialene, "CD LC TC CB MA" */
        String initials = people.stream()
            .map(p -> p.firstName().charAt(0) + "" + p.lastName().charAt(0))
            .reduce("", (acc, letters) -> acc + letters + " ");

        System.out.println("Initialer: " + initials);
	}	
}
