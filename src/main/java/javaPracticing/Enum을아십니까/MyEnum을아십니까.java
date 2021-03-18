package javaPracticing.Enum을아십니까;

class MyEnum을아십니까 {
    public static void main(String[] args) {
        MyVehicleType bus = MyVehicleType.BUS;
        System.out.println(bus.equals(MyVehicleType.AIRPLANE));
        System.out.println(MyVehicleType.BUS.name());
        System.out.println(MyVehicleType.BUS.ordinal());
        System.out.println(MyVehicleType.AIRPLANE.ordinal());

        System.out.println("a.ordinal : " + A.a.ordinal());
    }
}

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    private static int index = 0;
    private int ordinal;
    private String name;

    protected MyEnum(String name) {
        this.name = name;
        ordinal = index++;
    }

    protected String name() {
        return name;
    }

    protected int ordinal() {
        return ordinal;
    }

    @Override
    public boolean equals(Object object) {
        return object == this;
    }

    // values()와 valueOf()는 컴파일러에 의해 생성된다.

    @Override
    public int compareTo(T o) {
        return this.ordinal - o.ordinal();
    }
}

class A extends MyEnum {
    public static final A a = new A("a");

    A(String name) {
        super(name);
    }
}

abstract class MyVehicleType extends MyEnum {
    public static final MyVehicleType BUS = new MyVehicleType("BUS", 1500, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return person * price;
        }
    };
    public static final MyVehicleType AIRPLANE = new MyVehicleType("AIRPLANE", 500000, () -> System.out.println("FLYING")) {
        @Override
        int calculateFee(int person) {
            int additionalFee = 30000;
            return person * price + additionalFee * person;
        }
    };
    public static final MyVehicleType TAXI = new MyVehicleType("TAXI", 30000, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return price;
        }
    };

    protected int price;
    protected Runnable go;

    MyVehicleType(String name, int price, Runnable go) {
        super(name);
        this.price = price;
        this.go = go;
    }

    abstract int calculateFee(int person);

    void run() {
        go.run();
    }
}