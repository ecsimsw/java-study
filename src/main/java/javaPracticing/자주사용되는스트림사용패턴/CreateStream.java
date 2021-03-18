package javaPracticing.자주사용되는스트림사용패턴;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
}

class ArraysToStream {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};

        Stream<String> stream;
        stream = Arrays.stream(arr);
        stream = Arrays.stream(arr, 1, 3); // 1~2의 요소.
    }
}

class CollectionsAndEmpty {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 2, 4, 5, 5);

        Stream<Integer> integerStream = ints.stream();
        IntStream intStream = ints.stream().mapToInt(Integer::valueOf);

        if (ints == null || ints.isEmpty()) {
            integerStream = Stream.empty();
        }
    }
}

class Builder와Concat {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 2, 4, 5, 5);

        Stream objectStream = Stream.concat(
                ints.stream(),
                Stream.builder().add(4).add(5).build()
        );

        Stream<Integer> integerStream = Stream.concat(
                ints.stream(),
                Stream.<Integer>builder().add(4).add(5).build()
        );
    }
}

class Generate과iterate {
    public static void main(String[] args) {
        Stream<Integer> oneStream = Stream.generate(() -> 1);

        Stream<Integer> evenStream = Stream.iterate(2, i -> i += 2);
    }
}

class range와rangeClosed {
    public static void main(String[] args) {
        IntStream.range(1, 5); // 1,2,3,4
        IntStream.rangeClosed(1, 5); // 1,2,3,4,5
    }
}