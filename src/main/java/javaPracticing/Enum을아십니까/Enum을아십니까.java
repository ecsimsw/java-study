package javaPracticing.Enum을아십니까;

class Typesafe한_자바의Enum {
    public static void main(String[] args) {
//        UserInputButton input = getUserInput();
//
//        if(input == 0){
//            // Typesafe하지 않는, 0은 매직 넘버
//        }
//
//        if(input == MyErrorCode.IllegalArgumentException){
//            // Typesafe하지 않는, 비논리적
//        }
//
//        if(input == UserInputButton.Yes){
//            // Typesafe한
//        }
    }

    enum DayOfWeek {
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    enum Numbers {
        One,
        Two,
        Three,
        Four,
        Five
    }

    enum UserInputButton {
        Yes, No
    }
}


enum Vehicle {
    BUS(1500), AIRPLANE(30000), TAXI(30000);

    private int fee;

    Vehicle(int fee) {
        this.fee = fee;
    }

    int calculateAmount(int person) {
        return fee * person;
    }
}

enum VehicleType {
    BUS(1500) {
        @Override
        int calculateAmount(int person) {
            return person * fee;
        }
    },
    AIRPLANE(300000) {
        @Override
        int calculateAmount(int person) {
            int additionalFee = 30000;
            return person * fee + additionalFee * person;
        }
    },
    TAXI(30000) {
        @Override
        int calculateAmount(int person) {
            return fee;
        }
    };

    //    private  int price;    Non-static field 'price' cannot be referenced from a static context -> 익명클래스라
    protected int fee;

    VehicleType(int fee) {
        this.fee = fee;
    }

    abstract int calculateAmount(int person);
}

public class Enum을아십니까 {
    public static void main(String[] args) {


        System.out.println(Vehicle.BUS.calculateAmount(3));
    }
}

