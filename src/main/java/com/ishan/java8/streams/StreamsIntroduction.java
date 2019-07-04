package com.ishan.java8.streams;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * Question : What is a Stream? What are its uses?
 * Answer : {@link java.util.stream.Stream} is a Typed interface.
 * Is not a collection even though it may look like one.
 * Is an object on which you can define operations (map, filter, reduce, flatMap).
 * Is an object that doesn't hold any data.
 * Is an object that doesn't change the data it processes.
 * Able to process data in one pass.
 * Efficiently process large amounts of data and can do so in parallel.
 * Create pipeline, to avoid unnecessary intermediate operations.
 *
 */
public class StreamsIntroduction
{
    public static void main(String[] args) {
        /**
         * Build a Stream using the stream() method added on the Collection interface.
         *
         */
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();
        Stream<Person> peopleStream = people.stream();
        peopleStream.forEach(System.out::println);
    }

}
