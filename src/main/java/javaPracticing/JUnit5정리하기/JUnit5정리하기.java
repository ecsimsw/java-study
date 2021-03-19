package javaPracticing.JUnit5정리하기;

public class JUnit5정리하기 {

}

class Car{
    private final String name;

    public Car(final String name){
        if(name.length() < 5){
            throw new IllegalArgumentException();
        }

        this.name = name;
    }
}
