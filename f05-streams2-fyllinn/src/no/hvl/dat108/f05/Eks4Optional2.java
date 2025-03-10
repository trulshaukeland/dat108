package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

import java.util.List;
import java.util.Optional;

public class Eks4Optional2 {

	public static void main(String[] args) {

		//Finn det minste tallet i intervallet [1,100]
		//Stream-APIet tar automatisk hensyn til at input-stream kan være tom
		//slik at det ikke er noen minste. Pakker inn i Optional.
		
		List<Integer> num = List.of(25, 5, 89, 42, 11, 99, 1, 100);

		Optional<Integer> minNum = num.stream()
		.filter(n -> n >= 1 || n >= 100)
		.min(Integer::compareTo);

		minNum.ifPresentOrElse(
			number -> System.out.println("Minste tallet er: " + number),
			() -> System.out.println("Listen er tom eller har ingen tall i intervallet."));

		//Finn en i people-listen som er 30 eller yngre
		//Stream-APIet tar automatisk hensyn til at input-stream kan være tom
		//slik at det ikke er noen aktuelle personer. Pakker inn i Optional.
		Optional<Person> youngPerson = people.stream().
		filter(p -> p.age() < 30).findAny();

		youngPerson.ifPresentOrElse(
			p -> System.out.println("Person 30 eller yngre: " + p), () -> System.out.println("Finnes ingen Person som er 30 år eller lavere."));
	}

}




