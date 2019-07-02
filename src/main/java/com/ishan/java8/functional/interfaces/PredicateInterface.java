package com.ishan.java8.functional.interfaces;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * New functional interfaces toolbox :- java.util.function
 * 4 main types of functional interfaces :
 *
 * 3. Predicate
 * {@link java.util.function.Predicate}
 * The single abstract method (test) in the Predicate interface takes in
 * an object and returns a boolean.
 *
 */
public class PredicateInterface
{
    public static void main(String[] args) {
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();
        people.stream()
                .filter((Person person) -> "Gamer".equalsIgnoreCase(person.getOccupation()))
                .forEach(System.out::println);


        /**
         * Chaining Predicates
         * the defaults method and/or on the Predicate Interface are used to Chain Predicates.
         * eg :
         * default Predicate and(Predicate other) {
         *     return (T t) -> test(t) && other.test(t);
         * }
         *
         */

        Predicate<Person> p1 = (Person p) -> "Gamer".equalsIgnoreCase(p.getOccupation());
        Predicate<Person> p2 = (Person p) -> "Student".equalsIgnoreCase(p.getOccupation());

        people.stream()
              .filter(p1.or(p2))
              .forEach(System.out::println);
    }
}