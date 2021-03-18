package javaPracticing.스트림사용시주의점;

interface Ifunction{
    int add(int a, int b);

    default int sub(int a, int b){
        return a-b;
    }

    static int mul(int a, int b){
        return a*b;
    }
}

class PracticingLamda {
    public static void main(String[] args) {

        int x = 10;
        int y = 20;
        System.out.println(add(x,y,(a,b) -> a+b));

        Ifunction ifunction1 = (a,b) -> a+b;

        // 람다식은 결국 익명 클래스.
        // new Object(int a, int b){ return a+b;}
        // 와 같은 것
        // 그래서, ifuntion1과 ifunction2는 사실 같다.

        Ifunction ifunction2 = new Ifunction() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        System.out.println(ifunction1.add(x,y));

        System.out.println(ifunction1.sub(x,y));

        System.out.println(Ifunction.mul(x,y));
    }

    static int add(int x, int y,Ifunction addFunction){
        return addFunction.add(x,y);
    }
}
