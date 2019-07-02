package com.ishan.java8.functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * New functional interfaces toolbox :- java.util.function
 * 4 main types of functional interfaces :
 *
 * 2. Consumer
 * {@link java.util.function.Consumer}
 * The single abstract method (accept) in the Consumer interface takes in
 * an object and does not return anything
 *
 *
 */
public class ConsumerInterface
{
    public static void main(String[] args) {
        /** Since Consumer is a Functional interface, we can create lambda expression
         *  and pass it to stuff that accepts a Consumer
         *
         *  The forEach method has been added to the java.lang.{@link Iterable} interface
         *  that takes in a Consumer.
         *  eg
         *  default void forEach(Consumer consumer) {
         *      for(T t : this) {
         *          consumer.accept(t);
         *      }
         *  }
         */

        List<String> list = Arrays.asList("Allu", "Coldzera", "Twist", "Stew", "Device");
        System.out.println(" Using lambdas ");
        list.forEach(name -> System.out.println(name));
        System.out.println(" Using method reference ");
        list.forEach(System.out::println);

        /**
         * Chaining Consumers
         * the default andThen method on Consumer signature : Takes in another Consumer and returns
         * a new Consumer that combines the 2 consumers
         * andThen(Consumer other) {
         *   return (T t) -> { accept(t); other.accept(t}
         * }
         *
         */
        Consumer<String> c1 = (String name) -> System.out.println(name + " is joining the game");
        Consumer<String> c2 = (String name) -> System.out.println(name + " joined the game");
        list.forEach(c1.andThen(c2));

    }
}