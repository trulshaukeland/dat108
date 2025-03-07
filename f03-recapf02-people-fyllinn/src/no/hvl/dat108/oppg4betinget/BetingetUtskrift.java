package no.hvl.dat108.oppg4betinget;

/* Lars-Petter Helland, 20. august 2024
 * 
 * Uke34 - Oppgave 4
 * 
 * Her er en liten oppgave dere kan prøve på labben og frem til 
 * mandag for å se om dere har fått med dere hovedideen med 
 * lambda-uttrykk.
 * 
 * Oppgavetekst:
 * 
 * Lag en generell metode betingetUtskrift(...) som tar inn en streng 
 * og et (false | true) lambda-uttrykk og som skriver ut strengen kun 
 * hvis uttrykket er sant.
 * 
 * Lag en main(...)-metode som tester dette ut med et par ulike input, 
 * f.eks. krav om at stringen begynner på "X" eller at den er lengre 
 * enn 3 tegn.
 */

public class BetingetUtskrift {
	
	private static void betingetUtskrift(String s, Betingelse betingelse) {
		if(betingelse.test(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		
		String s1 = "Xhabition is the best scenter in Bergen";
		String s2 = "Hi";

		Betingelse starterMedX = s -> s.startsWith("X");

		Betingelse lengreEn3Tegn = s -> s.length() < 3;

		betingetUtskrift(s1, lengreEn3Tegn);
		betingetUtskrift(s2, lengreEn3Tegn);
		betingetUtskrift(s1, starterMedX);
		betingetUtskrift(s2, starterMedX);
	}
}

@FunctionalInterface
interface  Betingelse{
	boolean test(String s);
}



