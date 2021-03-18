package javaPracticing.스트림사용시주의점;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream사용시주의할점 {
}

class 재사용스트림문제 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 2);
        intStream.forEach(System.out::println);

        // stream has already been operated upon or closed
        intStream.forEach(System.out::println);
    }
}

class 닫힌범위 {
    public static void main(String[] args) {
        IntStream.range(1, 2).forEach(System.out::println); // 1

        IntStream.rangeClosed(1, 2).forEach(System.out::println); // 1 2
    }
}

class 연산횟수제한 {
    public static void main(String[] args) {
        IntStream.range(1, 5).limit(3).forEach(System.out::println);

        IntStream intStream = new Random().ints(3, 7).limit(5);
        intStream.forEach(System.out::println);

        intStream = new Random().ints(5, 3, 7);
        intStream.forEach(System.out::println);
    }
}

class 직접원하는값넣기 {
    public static void main(String[] args) {
        Stream.of(1, 3, 4, 5).forEach(System.out::println);

        Stream stream = Stream.builder().add(1).add(2).add(3).build();

        stream.forEach(System.out::println);
    }
}

class 헷갈리는동작순서_findFirst {
    public static void main(String[] args) {
        boolean hasOdd = Stream.of(2, 4, 6, 3, 7)
                .peek(i -> {
                    System.out.println(i);
                })
                .allMatch(i -> i % 2 == 0);
    }
}

class Stream은Loop가아니다 {
    public static void main(String[] args) {
        usingFindFirst();
    }

    public static void till99() {
        IntStream.range(1, 100).forEach(i -> {
            if (i > 50) {
                return;
            }
            System.out.println(i);
        });
    }

    public static void till99_() {
        IntStream.range(1, 10)
                .map(i -> {
                    System.out.println(i);
                    return i;
                })
                .forEach(System.out::println);
    }

    public static void usingFindFirst() {
        IntStream.range(1, 100)
                .takeWhile(i -> {
                    System.out.println(i); // 1 ~ 50
                    return i < 50;  // 50 -> false
                })
                .forEach(System.out::println); // 1 ~ 49
    }

    public static void usingLimit() {
        IntStream.range(1, 100)
                .filter(i -> {
                    System.out.println(i); // 1 ~ 51
                    return i > 50;
                })
                .findAny(); // true -> optional
    }
}

class findAny와findFirst {
    public static void main(String[] args) {

        int firstFirst = IntStream.of(2, 2, 4, 6, 8, 8, 2, 2, 3, 7, 8).parallel()
                .filter(i -> i % 2 != 0)
                .findFirst()
                .getAsInt();

        int findAny = IntStream.of(2, 2, 4, 6, 8, 8, 2, 2, 3, 7, 8).parallel()
                .filter(i -> i % 2 != 0)
                .findAny()
                .getAsInt();

        System.out.println(firstFirst + " " + findAny);
    }
}

class iterate와generate의차이 {
    public static void foo(String[] args) {
        Stream.iterate(1, i -> i += 1)
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        IntStream intStream = Stream.iterate(1, i-> i+=1)
//                .limit(5);

        IntStream intStream = Stream.iterate(1, i -> i += 1)
                .limit(5)
                .mapToInt(Integer::valueOf);

    }
}
