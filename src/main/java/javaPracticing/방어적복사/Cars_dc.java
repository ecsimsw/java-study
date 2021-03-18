package javaPracticing.방어적복사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class App {
    public static void main(String[] args) {

        // set carList

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(0));

        int before = 0;
        int after = 0;
        // test unmodifiableList Immutable

        Cars_ul cars_ul = new Cars_ul(carList);
        before = cars_ul.getSize();

        carList.remove(0);
        after = cars_ul.getSize();

        System.out.println("is changed in unmodifiableList");
        System.out.println(before == after);


        // test defensive copy immutable

        Cars_dc cars_dc = new Cars_dc(carList);
        before = cars_dc.getSize();

        carList.add(new Car(0));
        after = cars_dc.getSize();

        System.out.println("is changed in defensive copy");
        System.out.println(before == after);


        // make runtime error in defensive copy

        Collections.unmodifiableList(carList).add(new Car(0));
    }
}

class Cars_dc {
    private final List<Car> cars;

    public Cars_dc(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public int getSize() {
        return cars.size();
    }
}

class Cars_ul {
    private final List<Car> cars;

    public Cars_ul(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public int getSize() {
        return cars.size();
    }
}

class Car {
    final int position;

    public Car(int position) {
        this.position = position;
    }
}