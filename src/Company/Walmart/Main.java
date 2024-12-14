package Company.Walmart;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Example List of Person objects
        List<Person> personList = Arrays.asList(
                new Person(1, "John"),
                new Person(2, "John"),
                new Person(3, "Bob")
        );

        // Convert List to Map using Java 8 Streams
        Map<Integer, String> personMap = personList.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));

        System.out.println("Person Map: " + personMap);
    }

    static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}

