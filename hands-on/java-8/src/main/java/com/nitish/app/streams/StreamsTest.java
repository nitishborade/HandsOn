package com.nitish.app.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		List<Person> persons = getPersons();

		// Count sex="M" persons
		Stream<Person> stream = persons.stream();
		
		// Predicate is used to create a condition for matching only person with sex=M
		Predicate<Person> p = (person) -> person.getSex().equals("M");
		
		// Use the predicate to filter the stream of objects
		// This filters only the persons of sex=M
		Stream<Person> mstream = stream.filter(p);
		
		// Convert it back to list. Stream once used cannot be reused. To reuse
		
		// 1 . convert it back to a collection
		List<Person> mpersons = mstream.collect(Collectors.toList());
		System.out.println(mpersons.size());

		// Just like for loop, using a consumer
		mpersons.forEach((person) -> {System.out.println(person.getName());});
		
		// 2 Use supplier to get a new stream each time
		Person[] array = persons.toArray(new Person[persons.size()]); // Converts a list<objects> to array of objects. Puts persons list into a new array of persons
		Supplier<Stream<Person>> supp = () -> Stream.of(array);
		supp.get().forEach((person) -> {person.setSex("F");});
		supp.get().forEach((person) -> {System.out.println(person.getName() + " " + person.getSex());});

	}
	
	static List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();
		
		for(int i=0; i<10; i++) {
			Person p = new Person();
			p.setName("Person " + i);
			p.setSex(i % 2 == 0 ? "M" : "F");
			persons.add(p);
		}
		return persons;
	}
	
}

class Person {
    
    private String name;
    private String sex; //M or F
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}