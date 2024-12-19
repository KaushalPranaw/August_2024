package Java8Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestEmp {
    public static void main(String[] args) {
        // Creating Address objects
        Address address1 = new Address();
        address1.setPincode(110001);
        address1.setStreet("123, Main Street");
        address1.setState("Delhi");
        address1.setCity("New Delhi");
        address1.setCountry("India");

        Address address2 = new Address();
        address2.setPincode(560001);
        address2.setStreet("456, MG Road");
        address2.setState("Karnataka");
        address2.setCity("Bangalore");
        address2.setCountry("India");

        Address address3 = new Address();
        address3.setPincode(400001);
        address3.setStreet("789, Beach Road");
        address3.setState("Maharashtra");
        address3.setCity("Mumbai");
        address3.setCountry("India");

        // Creating Employee objects
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("John Doe");
        emp1.setSalary(50000.0);
        emp1.setAddress(address1);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("John Doe");
        emp2.setSalary(75000.0);
        emp2.setAddress(address2);

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Alice Johnson");
        emp3.setSalary(60000.0);
        emp3.setAddress(address3);

        // Creating a list of employees
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3);

        // Example of filtering employees with salary greater than 55000
        /*employees.stream().filter(e -> e.getSalary() > 55000)
                .forEach(System.out::println);
        System.out.println();*/

        // Example of mapping employee names to a list
        /*employees.stream().map(Employee::getName)
                .forEach(System.out::println);
        System.out.println();*/

        // Example of sorting employees by salary
        /*employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);*/

        // Example of getting the average salary
        /*double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);*/

        //How would you group employees by city and
        // then filter groups with more than one employee?

        var group = employees.stream().collect(Collectors.groupingBy(e -> e.getAddress().getCity()));
        //System.out.println(group);
        var filteredGroups = group.entrySet().stream().filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //System.out.println(filteredGroups);

        // How would you find the employee with the second-highest salary?
        var secondHighest = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(1)
                .findFirst()
                .get();
        //System.out.println(secondHighest);

        //How would you partition employees into two groups:
        // those earning more than 60,000 and those earning 60,000 or less?

        var parts = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        //System.out.println(parts.get(true));
        //System.out.println(parts.get(false));

        //How would you find the highest-paid employee from each state?
        var res = employees.stream().collect(Collectors.toMap(
                e -> e.getAddress().getState(),
                e -> e,
                (existing, replacement) -> existing.getSalary() > replacement.getSalary() ? existing : replacement
        ));
        //System.out.println(res);

        //How can you find the total salary of employees in each city?
        var res1 = employees.stream().collect(Collectors.groupingBy(e -> e.getAddress().getCity(),
                Collectors.summingDouble(Employee::getSalary)));
        //System.out.println(res1);

        //7. How can you filter out duplicate employees based on their name?
        var result=employees.stream().collect(Collectors.collectingAndThen(
                Collectors.toMap(Employee::getName,
                        e -> e,
                        (existing, replacement) -> existing), map -> map.values().stream().toList()));
        System.out.println(result);


    }
}
