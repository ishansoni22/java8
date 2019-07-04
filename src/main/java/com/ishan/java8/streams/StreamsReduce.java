package com.ishan.java8.streams;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Reduce functions are used for aggregations.
 * Is a terminal operation.
 * There are a few reduce method signatures on the {@link java.util.stream.Stream} interface.
 *
 * One of these functions takes in an Identity value for the accumulating function as the first parameter
 * and a {@link java.util.function.BinaryOperator} as the second argument and returns an Element that has
 * the same type as the Identity element. If the list is empty, the Identity element is returned.
 * Example - The Identity element for the sum operation is 0. The identity element for the multiplication
 * operator is 1.
 *
 * Another implementation takes just the {@link java.util.function.BinaryOperator} and returns an
 * {@link java.util.Optional}. Optional is a Monad/Wrapper. Optional may or may not have a value.
 * Since we do not pass in the Identity element in this signature, what to return when the list is
 * empty? - Optional (It may or may not have a value).
 * Example - The max operator has no Identity element.
 *
 * Optional.isPresent()
 * Optional.orElse("default value")
 * Optional.orElseGet({@link java.util.function.Supplier})
 * Optional.orElseThrow({@link Exception})
 *
 * Available reductions on {@link java.util.stream.Stream} -> max, min, count, sum, etc.
 *
 * Collectors
 * - Another type of reduction.
 * - Instead of aggregating elements, collectors puts these elements in a container.
 *
 */
public class StreamsReduce
{
    public static void main(String[] args) {
        /**
         * Print people who have age < 20 or have Engineer as occupation
         */
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();

        // Get the sum of ages of all the People

        int sumOfAges = people.stream()
              .map(Person::getAge)
              .reduce(0, (acc, curr) -> acc + curr);
        System.out.println("Sum of Ages : " + sumOfAges);


        // Get the maximum age

        Optional<Integer> max = people.stream()
                                      .map(Person::getAge)
                                      .max(Comparator.naturalOrder());

        System.out.println("Maximum age : " + max.orElse(-1));

        // Collect all ages in a List

        List<Integer> ages = people.stream()
                                   .map(Person::getAge)
                                   .collect(Collectors.toList());

        System.out.println("Age List" + ages);

        // Grouping

        Map<String, Long> occupationMap = people.stream()
                                             .collect(
                                                     Collectors.groupingBy(
                                                             Person::getOccupation,
                                                             Collectors.counting()
                                                     )
                                             );
        System.out.println(occupationMap);
    }
}