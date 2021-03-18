package javaPracticing.자주사용되는스트림사용패턴;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MiddleOperation {
}

class Skip과limit {
    public static void main(String[] args) {
        IntStream ints;

        ints = IntStream.rangeClosed(1, 5);
        ints.limit(3)
                .forEach(System.out::println); // 1 2 3

        ints = IntStream.rangeClosed(1, 5);
        ints.skip(2)
                .forEach(System.out::println); // 3 4

        ints = IntStream.rangeClosed(1, 5);
        ints.skip(2)
                .limit(1)
                .forEach(System.out::println);  // 3

        ints = IntStream.rangeClosed(1, 5);
        ints.limit(1)
                .skip(2)
                .forEach(System.out::println);  // None
    }
}

class flatMap1 {
    public static void main(String[] args) {
        List<List<String>> list1 =
                Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));

        System.out.println(list1); // [[a], [b]]

        List<String> list2 = list1.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(list2); // [a, b]
    }
}

class flatMap2 {
    public static void main(String[] args) {
        String[][] name_nickName = new String[][]{
                {"kimjinhwan", "corgi"}, {"parkjisung", "park"},
                {"limseongbin", "beenzino"}, {"gwonjiyong", "gdragon"}};

        long numberOfInvalidName = Arrays.stream(name_nickName)
                .flatMap(Arrays::stream)
                .filter(name -> name.length() > 5)
                .count();

        System.out.println(numberOfInvalidName);
    }
}