package com.zf.mo.stream;

import java.util.Arrays;
import java.util.List;

public class DemoStream {


    private static class Person{

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("战三", 10),
                new Person("李四", 15),
                new Person("王五", 24)
        );

        Integer integer = people.stream().map(e -> e.getAge()).reduce(Integer::sum).get();
        System.out.println(integer);

    }
}
