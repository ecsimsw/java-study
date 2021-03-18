package javaPracticing.Enum을아십니까;

/*
    enumType은 compareTo가 가능하다. 그리고 같은 enum이라도 정의한 enum 타입이 다르면 컴파일 에러를 만든다.

    enum A{}
    enum B{}

    A.compareTo(B); 는 에러를 낸다.


    abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
        private int ordinal;

        // 생략

        @Override
        public int compareTo(T o) {
            return this.ordinal - o.ordinal();
        }
    }

    이렇게 구현한 위 MyEnum 클래스는 MyEnum이기만 하면 다른 자식 타입이어도 compareTo가 가능하다.
 */

class compareTo문제에대한고민 {
    public static void main(String[] args) {
        System.out.println(TestChildA.one.compareTo(TempChildB.one));

        System.out.println(TestChildA.one.ordinal());
        System.out.println(TempChildB.one.ordinal());

        System.out.println();
    }
}

abstract class TempSuperClass<T extends TempSuperClass<T>> implements Comparable<T> {
    private static int index = 0;
    private int ordinal;

    protected TempSuperClass(String name) {
        ordinal = index++;
    }

    public int ordinal() {
        return ordinal;
    }

    @Override
    public int compareTo(T o) {
        if (this.getClass() != o.getClass()) {
            throw new ClassCastException();
        }

        return this.ordinal - o.ordinal();
    }
}

class TestChildA extends TempSuperClass {
    public static final TestChildA one = new TestChildA("one");
    public static final TestChildA two = new TestChildA("two");

    public TestChildA(String name) {
        super(name);
    }
}

class TempChildB extends TempSuperClass {
    public static final TempChildB one = new TempChildB("one");
    public static final TempChildB two = new TempChildB("two");

    public TempChildB(String name) {
        super(name);
    }
}
