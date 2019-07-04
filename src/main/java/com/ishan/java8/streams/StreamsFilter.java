package com.ishan.java8.streams;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * The filter method defined on the {@link java.util.stream.Stream} interface takes in a
 * {@link Predicate} and returns a Stream [Stream filter(Predicate)].
 * This new Streams holds nothing. The call to the filter method is Lazy. [Intermediate Operation]
 */
public class StreamsFilter
{
    public static void main(String[] args) {
        /**
         * Print people who have age < 20 or have Engineer as an occupation
         */
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();

        Predicate<Person> filter1 = (Person p) -> p.getAge() < 20;
        Predicate<Person> filter2 = (Person p) -> "Engineer".equalsIgnoreCase(p.getOccupation());

        people.stream()
              .filter(filter1.or(filter2))
              .forEach(System.out::println);

    }
}