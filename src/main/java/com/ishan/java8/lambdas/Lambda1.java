package com.ishan.java8.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * Question : What is a Lambda expression?
 * Answer : A Java Lambda expression is a function which can be created without
 * belonging to any class. It can be passed around as if it was an object and can
 * be executed on demand.
 *
 * Doubts : Is it a normal Object? Each object should be an instance of a class?
 *
 * Question : Why would you need a Lambda Expression ?
 * Answer :
 *  Reason 1 : To make instances of anonymous classes easier to write and read.
 *  Reason 2 : Create data processing pipelines using stream and monads
 */
public class Lambda1
{
    public static void main( String[] args )
    {
        File currDir = new File("./classes/com/ishan");
        System.out.println("Listing all files present : ");
        print(currDir.listFiles());

        // FILTERING FILES
        // Old Way : Using an anonymous inner class object
        System.out.println("Filtering the App java file using Anonymous inner class object");

        print(
                currDir.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().startsWith("App");
                    }
                })
             );

        // New Way : Using lambda expressions
        System.out.println("Filtering App java file using Lambda expressions");

        print(
                currDir.listFiles(
                        (File file) -> file.getName().startsWith("App")
                )
             );
    }

    private static void print(File files[])
    {
        Arrays.asList(files)
                .stream()
                .map(File::getName)
                .forEach(System.out::println);
    }
}