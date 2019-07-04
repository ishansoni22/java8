package com.ishan.java8.streams;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The map method defined on the {@link java.util.stream.Stream} interface takes in
 * a {@link java.util.function.Function} and returns a Stream
 * [Stream map(Function)]. This new Streams holds nothing. The call to the map method is
 * Lazy. [Intermediate Operation]
 */
public class StreamsMap
{
    public static void main(String[] args) {
        /**
         * Print out the names of every person
         */
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();

        people.stream()
              .map(Person::getName)
              .forEach(System.out::println);

        /**
         * Compose Functions
         * The compose function on the Function interface takes in a Function and
         * returns a function that composes the 2 Functions
         *
         * Function compose(Function before) {
         *     return (V v) -> {apply(before.apply(v))};
         * }
         *
        */
        Function<Person, String> function1 = (Person person) -> person.getName().toLowerCase();
        Function<String, String> function2 = (String name) -> {
            String firstChar = name.substring(0, 1);
            String restChars = name.substring(1, name.length());
            return firstChar.toUpperCase() + restChars;
        };

        people.stream()
              .map(function1.andThen(function2)).forEach(System.out::println);
    }
}