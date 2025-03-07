package no.hvl.dat108.people;

/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene på etternavn.

		people.sort(Comparator.comparing(person -> person.lastName().charAt(0)));
		people.forEach(System.out::println);
	
		// 2: Skriv ut alle personene, én linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gjør dette.
		printAll(people);
				
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette.
		
		people.stream()
		.filter(p -> p.lastName().startsWith("C")).forEach(System.out::println);
				
		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		
		
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
				printConditionally(people, p -> p.firstName().startsWith("C"));
				
				// >>>> Tilbake til ppt for litt mer "teori" før vi gjør siste
				
				
		// 6: Skriv ut fornavn til alle over 50 år.
		//    	Lag en metode doConditionally(...)
				System.out.println();
				people.stream()
				.filter(p -> p.age() > 50).forEach(System.out::println);
				
			}
		
			private static void printAll(List<Person> people) {
				people.forEach(System.out::println);
			}	
	
			private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
				for (Person p : people) {
					if (predicate.test(p)) {
						System.out.println(p);
					}
				}
			}
}
