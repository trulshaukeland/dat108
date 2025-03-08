package no.hvl.dat108.f04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Eksempel7 / Gjøre sammen i timen
 * 
 * Øve oss litt på flere grunnleggende 
 *  - source		IntStream.range(), Stream.iterate(), Stream.of()
 *  - intermediate	filter(), map(), limit(), distinct(), sorted()
 *  - terminal 		forEach(), collect(), toList()
 *  
 * operations på streams.
 */

public class Eksempel7 {
	
	public static void main(String[] args) {
		
		// a) Skrive ut alle partall i området [1,10>
		System.out.println("\n\nAlle partall i området [1,10>");
		IntStream.range(1, 10)
			.filter(n -> n % 2 == 0) // Kun partall
			.forEach(System.out::println);

		// b) Skrive ut kvadratet av alle tallene området [1,10>
		System.out.println("\n\nKvadratet av alle tallene i området [1,10>");
		IntStream.range(1, 10)
			.map(n -> n * n) // Kvadratet av hvert tall
			.forEach(System.out::println);

		// c) For en strøm av tallene 100, 103, 106, 109, ... 
		//    skriv ut de 10 første som er delelig med 4
		System.out.println("\n\nDe 10 første i (100, 103, 106, ...) som er delelig med 4");
		Stream.iterate(100, n -> n + 3) // Starter på 100, øker med 3 hver gang
			.filter(n -> n % 4 == 0) // Velger tall som er delelige med 4
			.limit(10) // Velger de 10 første
			.forEach(System.out::println);

		// d) For en stream av strenger, samle dem opp i en ny string, sortert 
		//    og uten duplikater. Skriv deretter ut resultatet.
		System.out.println("\n\nSorterte strenger uten duplikater");
		String resultat = Stream.of("banana", "apple", "orange", "banana", "grape", "apple")
			.distinct() // Fjerner duplikater
			.sorted() // Sorterer alfabetisk
			.collect(Collectors.joining(", ")); // Samler som en enkelt string
		
		System.out.println(resultat);

		// e) For en stream av strenger, samle dem sortert på stringlengde, 
		//    uten duplikater i en ny liste. Skriv deretter ut listen.
		System.out.println("\n\nSorterte strenger uten duplikater, sortert på lengde");
		List<String> favoritter = Stream.of("banana", "apple", "orange", "banana", "grape", "apple", "kiwi", "pear")
			.distinct() // Fjerner duplikater
			.sorted(Comparator.comparing(String::length)) // Sorterer etter lengde
			.collect(Collectors.toList()); // Samler i en liste
		
		System.out.println(favoritter);
	}
}