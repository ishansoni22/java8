package com.ishan.java8.streams;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;
import java.util.function.Function;

/**
 * The flatMap method defined on the {@link java.util.stream.Stream} interface takes in
 * a {@link Function} that takes in an object and returns a stream of objects.
 * The flatMap function then flattens this stream of streams of objects into a single stream.
 * This new Stream holds nothing. Call to the flatMap method is
 * Lazy. [Intermediate Operation]
 */
public class StreamsFlatMap
{
    public static void main(String[] args) {
        /**
         * Print out all hobbies
         */
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();

        people.stream()
              .flatMap((Person p) -> p.getHobbies().stream())
              .distinct()
              .forEach(System.out::println);
    }
}