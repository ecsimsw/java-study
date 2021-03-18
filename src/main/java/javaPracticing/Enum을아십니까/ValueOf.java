package javaPracticing.Enum을아십니까;

import java.util.Arrays;

enum TestEnum {
    A(1), B(2), C(3);

    private int value;

    TestEnum(final int i) {
        this.value = i;
    }

    public static TestEnum of(int i) {
        return Arrays.stream(TestEnum.values())
                .filter(test -> test.value == i)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("없음");
                });
    }
}

public class ValueOf {
    public static void main(String[] args) {
        System.out.println(TestEnum.of(1).equals(TestEnum.A));
        System.out.println(TestEnum.of(5));
    }
}