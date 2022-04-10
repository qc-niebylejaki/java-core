package com.qc.collections;

import java.time.Instant;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Map<Person, String> hashMap = new TreeMap<>(Comparator.comparing(Person::getName));
        hashMap.put(new Person("Adam"), "officer");
        hashMap.put(new Person("Adam"), "civillian");
        hashMap.put(new Person("Daniel"), "civillian");
        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("---");

        Set<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("Adam"));
        hashSet.add(new Person("Adam"));
        hashSet.add(new Person("Daniel"));
        hashSet.forEach(System.out::println);

        System.out.println("---");

        Set<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getName));
        treeSet.add(new Person("Adam"));
        treeSet.add(new Person("Adam"));
        treeSet.add(new Person("Daniel"));
        treeSet.forEach(System.out::println);

        System.out.println("---");

        Set<RandomPerson> randomSet = new HashSet<>();
        randomSet.add(new RandomPerson("Adam"));
        randomSet.add(new RandomPerson("Adam"));
        randomSet.add(new RandomPerson("Daniel"));
        randomSet.forEach(System.out::println);
    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class RandomPerson extends Person {

        public RandomPerson(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "RandomPerson{" +
                    "name='" + getName() + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return new Random(Instant.now().toEpochMilli()).nextInt();
        }
    }
}
