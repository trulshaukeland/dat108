package no.hvl.dat108.f05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Eks6utviklere {
	
	public static void main(String[] args) throws Exception {
		
		List<Utvikler> utviklere = Arrays.asList(
				new Utvikler("Arne", Set.of("Java", "C")),
				new Utvikler("Pere", Set.of("Javascript", "C++")),
				new Utvikler("Knut", Set.of("Java")),
				new Utvikler("Anne", Set.of("Haskell", "C#", "Python")),
				new Utvikler("Emma", Set.of("Clojure", "Ruby", "C")),
				new Utvikler("Lise", Set.of("Java", "C")));

		System.out.println(
				"\n\u001B[1mEn oversikt over hvilke utviklere som kan Java:\u001B[0m \n");
		List<Utvikler> utviklereSomKanJava = utviklere.stream().filter(u -> u.spraak().contains("Java")).collect(Collectors.toList());

		utviklereSomKanJava.stream()
		.map(u -> u.navn()).forEach(System.out::println);
		System.out.println(
				"\n\u001B[1mNavnet på en utvikler som kan C#, eller \"INGEN\" om ingen kan C#:\u001B[0m \n");

		utviklere.stream()
		.filter(u -> u.spraak().contains("C#"))
		.findAny()
		.ifPresentOrElse(
			u -> System.out.println("Utvikler som kan C#: " + u.navn()), 
			() -> System.out.println("INGEN")
		);
		
		System.out.println(
				"\n\u001B[1mEn sortert liste over alle programmeringsspråkene utviklerne kan:\u001B[0m \n");
		
		utviklere.stream()
		.flatMap(u -> u.spraak().stream())
		.distinct()
		.sorted()
		.forEach(System.out::println);

		System.out.println(
				"\n\u001B[1mHvilket språk flest utviklere kan (finner ett av dem): \u001B[0m \n");

		//Tall for antalall utviklere pr språk
		Map<String, Long> språkteller = utviklere.stream().flatMap(u -> u.spraak().stream())
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		//Finn høyeste antall utviklere som kan et språk
		Optional<Map.Entry<String, Long>> mestBrukt = språkteller.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue());

		System.out.println(mestBrukt.map(Map.Entry::getKey).orElse("Ingen språk funnet"));

		//Vrien - Prøv selv ...
		
		//Hint1: Bruk flatMap, collect, groupingBy, identity og counting
		//       for å finne antall av hvert språk. Lagre dette i en variabel
		//		 av typen (Map<String, Long>).
		
		//Hint2: Bruk deretter max for å finne det språket flest utviklere kan.
		//       Husk at max returnerer en Optional. Og at en Map.Entry 
		//		 inneholder både key og value.
		
		System.out.println(
				"\n\u001B[1mHvilke(t) språk flest utviklere kan hvis det er flere: \u001B[0m \n");

		// Finn høyeste antall utviklere som kan et språk
		long maxCount = språkteller.values().stream()
    		.max(Long::compare)
    		.orElse((long) 0);

		// Hent ALLE språk med maks antall utviklere
		List<String> mestPopulæreSpråk = språkteller.entrySet().stream()
			.filter(entry -> entry.getValue() == maxCount)
			.map(Map.Entry::getKey)
			.toList();

		System.out.println(mestPopulæreSpråk.isEmpty() ? "Ingen språk funnet" : mestPopulæreSpråk);
		
		//Vrien - Prøv selv ...
		
		//Hint:  Bruk Map-et fra forrige oppgave, og filtrer ut de språkene
		//	     som har samme antall utviklere som det språket flest utviklere kan.


	}
}





