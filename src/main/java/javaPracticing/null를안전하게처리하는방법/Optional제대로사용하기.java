package javaPracticing.null를안전하게처리하는방법;

import java.util.Optional;

public class Optional제대로사용하기 {
    public static void main(String[] args) {

        // 1. .isPresent(), .get()은 잘못 만들어진 함수다.
        // 결국 null 확인 후, 반환하는 코드로 밖에 안된다.
        // orElse(), orElseGet(), orElseThrow 를 사용한다.

        Optional<Integer> sampleOptional = Optional.of(null);
        if(sampleOptional.isPresent()){
            sampleOptional.get();
        }

        // 2. null 보다 기본 값을 사용하자.
        int test = sampleOptional.orElse(null); // NPE :: 컴파일 시점에서는 잡을 수 없다.
        test = sampleOptional.orElse(0); // 리스트라면 Collections.emptyList();

        // 3. Optional 로 null 을 참조하지 말자.
        Optional<Integer> optionalInteger = null; // optional 변수가 null 인지 확인하고, 내부가 null 인지 확인하고...

        // 4. of와 ofNullable 를 구분하자. -> 반드시 x가 null 일 수 있는 경우에만 ofNullable 를 사용한다.
        Optional.ofNullable(null);
        Optional.of(null);

        // 5. Optional 을 필드, 매개 변수, 제네릭 타입으로 쓰지 말아라
        // someFunction(Optional<Integer> i)

        // 6. Optional 은 정말 필요한 곳에서만 사용한다.
    }
}
