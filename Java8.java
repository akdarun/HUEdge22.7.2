package main.doodle;

import java.util.*;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> even = nums.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        List<Integer> odd = nums.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        even.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        odd.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        Map<Boolean, List<Integer>> result = nums.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        even = result.get(true);
        odd = result.get(false);
        even.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        odd.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("FILTER EMPLOYEE NAMES STARTING WITH X");

        List<Employee> names = new ArrayList(Arrays.asList(new Employee("XANDER"), new Employee("PANO"), new Employee("MUSKY"), new Employee("XAVIE"), new Employee("XIREA"), new Employee("KARLOS")));
        List<String> filteredNames = names.stream().map(x -> x.getName()).filter(x -> x.startsWith("X")).collect(Collectors.toList());
        filteredNames.forEach(System.out::println);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>();
        Integer [] numbers = set.toArray(new Integer[set.size()]);

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Map<Integer, Integer> valueSortedTm = tm.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        valueSortedTm.entrySet().stream().forEach(e -> System.out.print(e.getKey() + " -- " + e.getValue()));
    }
}

class Employee {
    private String name;
    Employee(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
