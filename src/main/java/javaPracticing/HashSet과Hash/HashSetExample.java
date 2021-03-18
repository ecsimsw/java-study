package javaPracticing.HashSet과Hash;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(17);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(9);
        hashSet.add(10);
        hashSet.add(11);
//        hashSet.add(12);
//        hashSet.add(13);
        hashSet.add(new Something_hashCodeIs11());
//        hashSet.add(new Something_hashCodeIs12());

        for (Object o : hashSet) {
            System.out.println(o);
//            System.out.println(o.hashCode());
//            System.out.println();
        }
    }
}

class Something_hashCodeIs11 {
    @Override
    public int hashCode() {
        return 11;
    }
}

class HashSetExample1 {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.add("8");
        hashSet.add("9");
        hashSet.add("10");
        hashSet.add("11");
        hashSet.add("12");
        hashSet.add("13");
        hashSet.add("22");

        for (Object o : hashSet) {
            System.out.println(o);
            System.out.println(o.hashCode());
            System.out.println();
        }
    }
}