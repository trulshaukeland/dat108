package no.hvl.dat108.f04;

import static no.hvl.dat108.f04.People.people;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * Eksempel2
 * 
 * I dette eksemplet ser vi hvordan vi kan erstatte 
 * lambda-uttrykk med metodereferanser.
 */
public class Eksempel2 {
	
	private static String initialer(Person p) {
		return p.firstName().substring(0,1) + p.lastName().substring(0,1);
	}
	
	private static double snitt(double a, double b) {
		return (a + b) / 2;
	}
	
	// Metode som utfører en handling på en Person ved hjelp av en Consumer-funksjon
	private static void gjorNoeMedPerson(Person person, Consumer<Person> consumer) {
		consumer.accept(person);
	}
	
	// Metode som omformer en Person til en String ved hjelp av en Function-funksjon
	private static String personTilString(Person person, Function<Person, String> func) {
		return func.apply(person);
	}
	
	// Metode som utfører en binær operasjon på to Double-verdier ved hjelp av en BinaryOperator
	private static double brukeBiFunc(Double a, Double b, BinaryOperator<Double> operator) {
		return operator.apply(a, b);
	}
	
	public static void main(String[] args) {
		
		Person arne = new Person("Arne", "And", 1990);

		// Bruker metodereferanse i stedet for lambda: p -> System.out.println(p)
		gjorNoeMedPerson(arne, System.out::println);

		// Bruker metodereferanse i stedet for lambda: p -> p.firstName()
		String fornavn = personTilString(arne, Person::firstName);
		System.out.println(fornavn);

		// Bruker metodereferanse i stedet for lambda: p -> initialer(p)
		String initialer = personTilString(arne, Eksempel2::initialer);
		System.out.println(initialer);

		// Bruker metodereferanse i stedet for lambda: (a, b) -> Math.max(a, b)
		double maks = brukeBiFunc(4.0, 5.0, Math::max);
		System.out.println(maks);

		// Bruker metodereferanse i stedet for lambda: (a, b) -> snitt(a, b)
		double snitt = brukeBiFunc(2.0, 5.0, Eksempel2::snitt);
		System.out.println(snitt);

		// Sorterer listen av personer basert på fornavn
		people.sort((p1, p2) -> p1.firstName().compareTo(p2.firstName()));

		// Bruker metodereferanse i stedet for lambda: p -> System.out.println(p)
		people.forEach(System.out::println);
	}
}