package javaPracticing.스트림사용시주의점;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Stream연습1 {
    public static void main(String[] args) throws Exception{

        // list 추가 동시에 초기화. Arrays.asList()
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,1));

        System.out.println(streamToList(list.stream()));

        System.out.println(removeDuplicateWithStream(list).size());

        System.out.println(removeDuplicateWithSet(list).size());

        for(int i : biggerThanThreshold(list, 2)){
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i : sort(list)){
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i : sortReverse(list)){
            System.out.print(i + " ");
        }

    }

    // collect(Collectors.toList) : 자료형 변환
    public static List<Integer> streamToList(Stream<Integer> stream){
        return stream.collect(Collectors.toList());
    }

    // distinct : 중복 제거
    public static List<Integer> removeDuplicateWithStream(List<Integer> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<Integer> removeDuplicateWithSet(List<Integer> list){
        return new ArrayList(new HashSet(list));
    }

    // filter : 조건 불충족 인자 제거
    public static List<Integer> biggerThanThreshold(List<Integer> list, int threshold){
        return list.stream().filter(x -> x>= threshold).collect(Collectors.toList());
    }

    // sort : 정렬
    public static List<Integer> sort(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> sortReverse(List<Integer> list){
        return list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

}


class Stream연습2 {
    public static void main(String[] args) throws Exception{

        System.out.println(isAllMatch(1,3));

        System.out.println(isAnyMatch(0));

        System.out.println(countMatch(3));

        for(int i : concatStream("153", "456")){
            System.out.print(i + " ");
        }
    }

    static List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,1));

    // allMatch : 모두 일치하는지 확인
    public static boolean isAllMatch(int min, int max){
        return list.stream().allMatch(x-> x>= min && x<=max);
    }

    // anyMatch : 하나라도 일치하는지 확인
    public static boolean isAnyMatch(int min){
        return list.stream().anyMatch(x-> x==min);
    }

    public static Integer[] listToArray(){
        return list.toArray(new Integer[0]);
    }

    // count : 조건 부합 요소 개수 세기
    public static int countMatch(int max){
        return (int)list.stream().filter(x-> x<max).count();
    }

    // concat : stream 합치기
    // map : 요소를 특정 값으로 모두 변환시킴
    public static List<Integer> concatStream(String a, String b){
        Stream<Integer> streamA = Arrays.stream(a.split("")).map(Integer::parseInt);
        Stream<Integer> streamB = Arrays.stream(b.split("")).map(Integer::parseInt);

        return Stream.concat(streamA, streamB).collect(Collectors.toList());
    }

}
