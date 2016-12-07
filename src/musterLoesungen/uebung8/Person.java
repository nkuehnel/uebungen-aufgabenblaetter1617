package musterLoesungen.uebung8;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.age;
	}

	private void increaseAge() {
		this.age++;
	}

	public static void main(String[] args) {

		// 1a

		Person karl = new Person("Karl", 43);
		Person lutz = new Person("Lutz", 12);
		Person lotta = new Person("Lotta", 39);

		List<Person> household = new ArrayList<>();
		household.add(karl);
		household.add(lutz);
		household.add(lotta);

		// Personen landen in Reihenfolge, in
		// der sie hinzugefügt werden in der Liste
		for (Person person : household) {
			person.increaseAge();
			System.out.println(person);
		}

		// 1b

		Person rolf = new Person("Rolf", 30);
		household.add(1, rolf);

		// Rolf ist an zweiter Stelle, da der Index bei 0 anfängt
		for (Person person : household) {
			person.increaseAge();
			System.out.println(person);
		}

		// Wirft eine Exception, da die Liste nur bis Index 3 geht
		// household.add(4, rolf);

		System.out.println(household.size());

		// 1c

		// False, da Liste nicht leer
		System.out.println(household.isEmpty());

		// household.clear();

		// true, wenn mit clear() Liste geleert
		System.out.println(household.isEmpty());

		// 1d

		if (household.contains(rolf)) {
			// Entfernt rolf
			household.remove(rolf);

			// nochmalige Entfernung produziert keinen Fehler, remove() gibt
			// false zurück
			household.remove(rolf);
		}

		// Löschen über Index
		household.remove(household.indexOf(lotta));

		// Produziert Exception, da indexOf() nun -1
		// zurückgibt, da Lotta bereits gelöscht
		// wurde. remove() wirft dann eine Exception,
		// weil auf den index -1 zugegriffen wird
		// household.remove(household.indexOf(lotta));
	}

}
