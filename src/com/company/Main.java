package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args)
    {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, " IT"),
                new Employee("Ashley", "Green", 7600, " IT"),
                new Employee("Matthew", "Indigo", 3587.5, " Sales"),
                new Employee("James", "Indigo", 4700.77, " Marketing"),
                new Employee("Luke", "Indigo", 6200, " IT"),
                new Employee("Jason", "Blue", 3200, " Sales"),
                new Employee("Wendy", "Brown", 4236.4, " Marketing")};

        //λήψη προβολής List των Employees
        List<Employee> list = Arrays.asList(employees);
        //εμφάνιση όλων των Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nEmployees earnings $4000-$6000 per month sorted by salary:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream()
                .filter(fourToSixThousand)
                .findFirst()
                .get());

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf("%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        System.out.printf("%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);




    }
}
