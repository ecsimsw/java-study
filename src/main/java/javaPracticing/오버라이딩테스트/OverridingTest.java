package javaPracticing.오버라이딩테스트;

public class OverridingTest {

    public static void main(String[] args) {
        Parent p1 = new Parent();
        Parent p2 = new Child();
        Child c1 = new Child();

        p1.foo();
        p2.foo();
        c1.foo();
    }
}


class Parent{
    void foo(){
        System.out.println("parent");
    }
}

class Child extends Parent{
    @Override
    void foo(){
        System.out.println("child");
    }
}
