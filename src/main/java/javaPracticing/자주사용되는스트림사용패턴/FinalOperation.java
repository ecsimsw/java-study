package javaPracticing.자주사용되는스트림사용패턴;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FinalOperation {
}

class CalculatingIntStream {
    public static void main(String[] args) {
        IntStream.of(1, 3, 5, 7, 9).min().getAsInt(); // 1
        IntStream.of(1, 3, 5, 7, 9).max().getAsInt(); // 9

        IntStream.of().min().orElseGet(() -> 0); // 0
        IntStream.of().max().orElseGet(() -> 0); // 0

        IntStream.of(1, 3, 5, 7, 9).sum(); // 25
        IntStream.of(1, 3, 5, 7, 9).count(); // 5
    }
}

class Calculating {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 3, 9, 10, 4, 5, 7)
                .stream()
                .collect(Collectors.toList());

        Set<Integer> intSet = Arrays.asList(1, 3, 9, 10, 4, 5, 7)
                .stream()
                .collect(Collectors.toSet());

        Arrays.asList(1, 3, 9, 10, 4, 5, 7)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]")); // [1,3,9,10,4,5,7]

        Arrays.asList("1", "3", "9", "10", "4", "5", "7")
                .stream()
                .collect(Collectors.averagingInt(Integer::parseInt));  // 5.571428571428571

        Arrays.asList("1", "3", "9", "10", "4", "5", "7")
                .stream()
                .collect(Collectors.summingInt(Integer::parseInt));  // 39
    }
}

class Grouping {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("kim", 20),
                new Person("park", 24),
                new Person("lee", 35),
                new Person("yang", 13),
                new Person("choi", 9),
                new Person("song", 17)
        );

        Map<Integer, List<Person>> collect1 = people.stream()
                .collect(Collectors.groupingBy(p -> p.age));

        // {17=[song], 35=[lee], 20=[kim], 24=[park], 9=[choi], 13=[yang]}


        Map<Boolean, List<Person>> collect2 = people.stream()
                .collect(Collectors.partitioningBy(p -> p.age > 20));

        // {false=[kim, yang, choi, song], true=[park, lee]}
    }

    static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}