package com.ishan.java8.functional.interfaces;

import com.ishan.java8.utils.DataUtils;
import com.ishan.java8.utils.Person;

import java.util.List;

/**
 *
 * New functional interfaces toolbox :- java.util.function
 * 4 main types of functional interfaces :
 *
 * 4. Function
 * {@link java.util.function.Function}
 * The single abstract method (apply) in the Function interface takes in
 * an object and returns an object
 *
 *
 */
public class FunctionInterface
{
    public static void main(String[] args) {
        DataUtils du = new DataUtils();
        List<Person> people = du.getPersonData();

          people.stream()
                .map((Person::getName))
                .forEach(System.out::println);
    }
}