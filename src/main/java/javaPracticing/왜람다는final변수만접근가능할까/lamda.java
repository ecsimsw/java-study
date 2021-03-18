package javaPracticing.왜람다는final변수만접근가능할까;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class test {
    private static int index = 0;

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car(), new Car(), new Car());
        setCarsNumber(cars);

        cars.stream()
                .forEach(Car::printNumber);
        ;
    }

    private static void setCarsNumber(List<Car> cars) {
        MyInteger heapValue2 = new MyInteger(1);
        cars.stream()
                .forEach(car -> car.setNumber(heapValue2.value++));
    }

    private static Supplier getExpression() {
        MyInteger heapValue2 = new MyInteger(1);
        return () -> heapValue2.value++;
    }
}

class MyInteger {
    public int value = 1;

    public MyInteger(int value) {
        this.value = value;
    }
}

class Car {
    int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public void printNumber() {
        System.out.println(number);
    }
}