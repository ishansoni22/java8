package com.ishan.java8.utils;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public List<Person> getPersonData() {
        List<Person> persons = new ArrayList<>();

        Person p1 = new Person();
        p1.setId(1L);
        p1.setName("Ishan Soni");
        p1.setOccupation("Engineer");

        Person p2 = new Person();
        p2.setId(2L);
        p2.setName("Divyan Soni");
        p2.setOccupation("Student");

        Person p3 = new Person();
        p3.setId(3L);
        p3.setName("Stewie 2K");
        p3.setOccupation("Gamer");

        Person p4 = new Person();
        p4.setId(4L);
        p4.setName("S1mple");
        p4.setOccupation("Gamer");

        Person p5 = new Person();
        p5.setId(5L);
        p5.setName("Mr. Xyz");
        p5.setOccupation("Engineer");

        persons.add(p1);persons.add(p2);persons.add(p3);persons.add(p4);persons.add(p5);

        return persons;
    }

}