package com.ishan.java8.lambdas;

/**
 *
 * What is the type of a Lambda expression?
 * Answer : Functional Interface.
 *
 * What is a Functional Interface ?
 * Answer : An interface which has exactly one abstract method
 *
 * When you are writing Lambdas, create the Lambda syntax for that abstract method
 * lambda = (abstract method signature) -> {body}
 *
 * Eg, in class Lambda1, FileFilter has a single abstract method boolean accept(File file)
 * FileFilter is therefore a Functional Interface
 * (File file) -> file.getName().startsWith("App")
 *
 * Note : Prior to Java 8, interfaces could have only public abstract methods and constants(public static final)
 * , from Java 8, interfaces can have default and static methods too.
 *
 * Lambdas can be put in a variable. See line 46.
 *
 * Lambdas are not your standard objects. Lambdas are created without using the new keyword.
 * Lambdas are objects of a new kind [JVM Friendly]
 *
 */
public class Lambda2
{
    public static void main(String[] args)
    {
        // Old Syntax
        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Anon done");
                }
            }
        }.run();

        // New Syntax
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Lambda done");
            }
        };
        runnable.run();
    }
}