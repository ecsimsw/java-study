package javaPracticing;

class App1 {
    public static void main(String[] args){
       MyClass a = new MyClass(10);
       MyClass b = new MyClass(20);

       swap(a,b);

       System.out.println(a.value +" "+ b.value);
    }

    static void swap(int x, int  y){
        int temp =x;
        x =y;
        y =temp;
    }

    static void swap(MyClass x, MyClass y){
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
}

class MyClass{
    public Integer value;

    public MyClass(int x){
        value = x;
    }
}


class App2 {
    public static void main(String[] args) throws Exception{
        Integer a = 10;
        Integer b = 10;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

        a = -128;
        b = -128;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }

    static void changeClass(MyClass a){
        a.value = 20;
    }
    static void changeInteger(Integer a){
        a = 20;
    }
}


