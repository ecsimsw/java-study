package javaPracticing.Optional정리하기;

import java.util.Optional;

public class Optional정리하기 {
}

class Optional생성하기 {
    public static void main(String[] args) {
        Optional<String> opStr1 = Optional.of("111");
        Optional<String> opStr2 = Optional.of(null); // NullPointerException

        Optional<String> opStr3 = Optional.ofNullable("111");
        Optional<String> opStr4 = Optional.ofNullable(null);

        Optional<String> opStr5 = Optional.<String>empty();
    }
}

class value가져오기 {
    public static void main(String[] args) {
        Optional<String> opStr1 = Optional.ofNullable("something");
        System.out.println(opStr1.get());
        System.out.println(opStr1.orElse("empty"));
        System.out.println(opStr1.orElseGet(String::new));

        Optional<String> opStr2 = Optional.ofNullable(null);
//        System.out.println(opStr2.get()); // NoSuchElementException
        System.out.println(opStr2.orElse("empty"));
        System.out.println(opStr2.orElseGet(String::new));
        opStr2.orElseThrow(IllegalArgumentException::new);
    }
}

class Name {
    private final String name;

    public Name(final String name) {
        if (name.length() <= 3) {
            new IllegalArgumentException();
        }

        this.name = name;
    }
}

class Optional처리하기 {
    public static void main(String[] args) {
        Optional<String> opStr1 = Optional.ofNullable("something");
        Name validName = opStr1.filter(s -> s.length() > 3)
                .map(Name::new)
                .orElseThrow(IllegalArgumentException::new);
    }
}
