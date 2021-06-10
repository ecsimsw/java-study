package javaPracticing.제네릭과와일드카드;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class 와일드카드테스트 {
    public static void main(String[] args) {

        ArrayList<Sports> arrList = new ArrayList<Sports>();
        arrList.add(new Sports());
        arrList.add(new Soccer());
        arrList.add(new Skating());

        Sports sports = arrList.get(0);
        Soccer soccer = (Soccer)arrList.get(1);
        System.out.println(sports);


        ArrayList<? extends Sports> arrList1 = new ArrayList<>();
        ArrayList<?> arrList2 = new ArrayList<>();
        ArrayList<? super Soccer> arrList3 = new ArrayList<>();

    }

    static void expectObject(List<?> testList, Object a){
        for(Object o : testList){
            System.out.println(o);
        }
    }

    static void expectChildsOfSports(List<? extends Sports> testList, Soccer a){
//        testList.add(new Soccer()); 컴파일 에러, list의 제네릭 타입이 soccer, 그리고 soccer가 Sports의 하위인걸 모름

        for(Sports s : testList){
            System.out.println(s);
        }

    }

    static void expectParentsOfSccore(List<? super Soccer> testList){
        testList.add(new Soccer());

//        for(Soccer s : testList){   컴파일 에러, list의 제네릭 타입을 모름
//            System.out.println(s);
//        }
    }
}

class Sports {
    @Override
    public String toString() {
        return "Sports";
    }
}

class Soccer extends Sports {}

class Skating extends Sports {}

class NonSports {}