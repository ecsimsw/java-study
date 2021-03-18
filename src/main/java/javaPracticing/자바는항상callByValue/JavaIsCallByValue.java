package javaPracticing.자바는항상callByValue;


class 객체변화Example {
    public static void main(String[] args) throws Exception {
        Person p = new Person(10);

        System.out.println("before : " + p.age);

        changePerson(p);

        System.out.println("after : " + p.age);
    }

    private static void changePerson(Person p) {
        p = new Person(50);
    }
}


class 상태변화Example {
    public static void main(String[] args) throws Exception {
        Person p = new Person(10);

        System.out.println("before : " + p.age);

        getOlder(p);

        System.out.println("after : " + p.age);
    }

    private static void getOlder(Person p) {
        p.age++;
    }
}

class Person {
    Integer age = 0;

    public Person(Integer age) {
        this.age = age;
    }
}

/*
    before : true
    in function : true
    after : true
 */

class SwapExample {
    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 20;

        System.out.println("before : " + a + " " + b);

        swap(10, 20);

        System.out.println("after : " + a + " " + b);
    }

    private static void swap(int a, int b) {
        int temp = b;
        b = a;
        a = temp;

        System.out.println("in function : " + a + " " + b);
    }
}