package javaPracticing.null를안전하게처리하는방법;

public class Null을안전하게다루는방법 {
    public static void main(String[] args) {
        API에가급적Null을사용하지않는다();
        null의범위를지역에제한해라();
        초기화를명확히해라();
        여담엘비스연산자논의();
    }

    private static void API에가급적Null을사용하지않는다() {
        /*
         1. API 에 가급적 null 을 사용하지 않는다.
            - null에 유연한 메소드가 아닌, 명시적으로 기능을 분리할 수 있는 방법을 찾아라

         1-1. null을 반환하지 말아라
            - 반환값이 반드시 있어야 하는데 처리 결과가 없는 경우 예외를 터트리는 방법도 고려해라.
            - null이 아닌 기본값으로 표시할 순 없는지 고민하라 (정수라면 0, 리스트라면 빈 리스트 등)
            - 정 안될 경우 Optional 반환해라.

         1-2. null을 인자로 받지 말아라
            - 연사자 오버로딩으로 null을 받는 함수를 숨기자.
         */
    }

    private static void null의범위를지역에제한해라() {
        /*
         2. 메서드와 클래스를 작게 만들어라 (null의 범위를 캡슐화해라)
            - 상태(null)를 메소드 안에 숨기는 식으로 개발하면, NPE 또는 기타 사이드 이펙트를 줄일 수 있을 것이다.
            - 설계가 잘된 코드에선 null위험도 적다. null에 안전한 코드가 좋은 코드, 역으로 좋은 코드를 짜면 null에 안전하다.
         */
    }

    private static void 초기화를명확히해라() {
        /*
         3. 초기화를명확히해라
         */
    }

    private static void 여담엘비스연산자논의() {
        /*
         여담. 자바에서도 코틀린의 엘비스 연산자, assertion 도입에 대한 논의가 있었다고 한다.

         person?.getName()?.split(",")?.length 와 같은 형태 꼴은

         - 디미터 법칙을 무시하고, 오히려 null 사용을 부추긴다.
         - 이런 꼴이 필요한 설계는 좋은 설계가 아니다. 좋지 못한 설계를 열어주는 것과 같다.
         - Optional를 사용해라

         는 이유로 채택되지 못했다.
         */
    }
}
