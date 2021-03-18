package javaPracticing.제네릭과와일드카드;

class App {
    public static void main(String[] args) {
        Parent<MyClass> p1 = new Parent<>();
        Parent<MyClass> p2 = new Child<>();
        Child<MyClass> p3 = new Child<>();

        p1.print(new MyClass());
        p2.print(new MyClass());
        p3.print(new MyClass());
    }
}

class Parent<T> {
    public T print(T arg) {
        System.out.println("1");
        return arg;
    }
}

class Child<T> extends Parent<T> {
    public T print(T arg) {
        System.out.println("2");
        return arg;
    }
}

class MyClass {

}

class Reify {
    public static void main(String[] args) {
        Object[] objArr = new Integer[1];
        objArr[0] = "Hello World";
    }
}

/*
## 배경

오늘 지난 번 수업 때 제네릭을 배우고 여러가지 실험? 연습을 해보고 싶었어요.

그러다가 `어 이상한데` 라는 말이 나왔던 부분이 있었고, '다른 분들은 헷갈리지 마세요'의 엄청난 정보 글은 못되지만,,,

말이나 생각만으로 오답 정리를 하는 것보다 글로 정리하면, 나아가 다른 사람들을 위해 글로 정리하면, 보다 확실하게 공부할 수 있지 않을까 라는 생각에서 자답을 남깁니다.

## 시작

아래 이상한 코드의 출력 값을 예상해보세요.

```java
class App {
    public static void main(String[] args) {
        Parent<MyClass> p1 = new Parent<>();
        Parent<MyClass> p2 = new Child<>();
        Child<MyClass> p3 = new Child<>();

        p1.print(new MyClass());
        p2.print(new MyClass());
        p3.print(new MyClass());
    }
}

class Parent<T> {
    public T print(T arg) {
        System.out.println("1");
        return arg;
    }
}

class Child<T extends MyClass> extends Parent {
    public T print(T arg) {
        System.out.println("2");
        return arg;
    }
}
```

답은 1,1,2예요.

출력이 왜 1,2,2 가 아니라 1,1,2 인지 한번에 보이시나요?

저는 바로 못 찾았었거든요. 그 얘기를 쓰고 싶어요.

제가 생각한 정답은, 또는 제가 헷갈린 이유는 T print(T arg)가 Parent의 것과 Child의 것이 같다고,

```java
// 위 코드와 전혀 다른 코드입니다.

class Parent {
    public MyClass print(MyClass arg) {
        System.out.println("1");
        return arg;
    }
}

class Child extends Parent {
    public MyClass print(MyClass arg) {
        System.out.println("2");
        return arg;
    }
}
```

즉 위처럼 제네릭 타입 T로 MyClass가 위치할 것만 생각해서, 이걸 오버라이딩 될 거라고 생각했어요.

사실은 Parent의 T와 Child의 T는 전혀 다른 T에, 전혀 다른 메소드인데 말이죠..

## 서로 다른 T?

조금 너무 실험용 코드처럼 보여서 나름대로 예제를 생각해봤어요.

Parent는 Number의 하위 타입만을 인자로 printNumber()를 호출하려고 하고 있어요.

Chile는 Parent를 상속하여 printNumber()를 재정의하고 싶어요.

아래 코드에서 Child는 getNumber에 String을 받았는데 이게 컴파일 에러를 만들진 않을까요?

Child가 Parent를 상속했는데, getNumber는 숫자만 받아야하는거 아닌가요?

```java
class Practice {
    public static void main(String[] args) {
        Child<String> child = new Child<>();
        child.getNumber("hello");
    }
}

class Parent<T extends Number> {
    public T getNumber(T number) {
        return number;
    }
}

class Child<T> extends Parent {
    public T getNumber(T number) {
        return number;
    }
}
```

정답은 No예요. 위 코드는 컴파일 에러가 나지 않아요. 앞서 말한 것처럼 Parent T와 Child의 T가 전혀 다른 T기 때문에 문제가 없는 코드예요.

앞서 말했 듯 마치 재정의인 것 같지만 전혀 다른 T에, 둘은 전혀 다른 메소드예요.

그럼 원래 원했던 대로, Child의 T가 Parent의 T와 같은 제네릭 타입의 제한을 받도록 하려면 어떻게 해야할까요?

즉 Child가 getNumber를 올바르게 재정의하려면 어떻게 해야할까요.

Child에서도 똑같이 Parent의 T와 같은 제한을 직접 줘야할까요? 아래처럼요?

```java
// 이 코드는 잘못된 코드입니다.

class Parent<T extends Number> {
    public T printNumber(T args) {
        return args;
    }
}

class Child<T extends Number> extends Parent {
    public T printNumber(T args) {
        return args;
    }
}
```

## 올바르게 메소드 재정의 하기 :: 제한 물려 주기

정답은 이렇게 extends Parent<T>를 상속하면 Child의 제네릭 타입도 Number의 하위 타입으로 제한이 돼요.

이전 extends Parent와 달리 Child는 제네릭 타입을 Number의 하위 타입 (ex, Integer) 만으로 제한돼요.

```java
class Parent<T extends Number> {
    public T printNumber(T args) {
        return args;
    }
}

class Child<T extends Integer> extends Parent<T> {
    public T printNumber(T args) {
        return args;
    }
}
```

결국 정리하자면 재정의처럼 보이지만 사실 그렇지 않았던 서로 같은 이름의 전혀 다른 메소드가 헷갈리게 만든거예요.

그래서 아래가 바로 올바른 print 재정의예요.

우리가 원했던 것처럼 1,2,2를 잘 출력하는 것을 확인할 수 있어요.

```java
class App {
    public static void main(String[] args) {
        Parent<MyClass> p1 = new Parent<>();
        Parent<MyClass> p2 = new Child<>();
        Child<MyClass> p3 = new Child<>();

        p1.print(new MyClass());  // 1
        p2.print(new MyClass());  // 2
        p3.print(new MyClass());  // 2
    }
}

class Parent<T> {
    public T print(T arg) {
        System.out.println("1");
        return arg;
    }
}

class Child<T extends MyClass> extends Parent<T> {
    public T print(T arg) {
        System.out.println("2");
        return arg;
    }
}
```

## PLUS :: 타입 소거

Both methods have same erasure, yet neither overrides the other

앞에서 잘못된 재정의 예시로 아래 코드가 기억나시나요?

```java
// 이 코드는 잘못된 코드입니다.

class Parent<T extends Number> {
    public T printNumber(T args) {
        return args;
    }
}

class Child<T extends Number> extends Parent {
    public T printNumber(T args) {
        return args;
    }
}
```

이 코드는 사실 정상 동작하지 않는 코드예요.

앞서 extends Parent<T>를 붙여야만 printNumber를 같은 메소드로 인지하고 정상 재정의된다고 말했는데,

역설적이게도 위 코드에서 두 printNumber()는 컴파일 시점에만 다른 메소드로 인지되고, 런타임 시점에서는 또 서로 다른 메소드임을 인지할 수 없게 돼요.

이걸 타입 소거(erasure)이라고 하는데, 컴파일 시점에서만 타입의 안전성이 보장되고, 런타임 시점에서는 타입을 소거하기 때문이예요.

좀 더 쉽게, 런타임에서는 T가 소거되어 Child와 Parent의 printNumber()을 다르다고 구분할 수 없으니, 이런 코드는 안됩니다! 하고 컴파일 시점에서 금지시키는 거예요.

까다롭고 불편하다고 생각할 수 있는데, 타입 소거의 반대, 실체화의 코드를 보면 또 생각이 달라질거예요.

실체화(reify)의 대표적인 예시로 배열이 있어요.

아래 예시보면 우리는 이게 큰일 날 코드인걸 알아요. Integer 공간에 문자열을 넣으려고 한다니!

근데 이 코드는 컴파일 시점에선 문제가 없어요.

실체화는 소거와 반대로 런타임 시점에서 그 타입이 결정되기 때문에 런타임 시점에서나 아래 코드가 문제가 있다는 것을 알게 되는거죠.

```java
class Reify{
    public static void main(String[] args) {
        Object[] objArr = new Integer[1];
        objArr[0] = "Hello World";
    }
}
```

지금 이 코드는 두 줄짜리지만, 클래스가 많아지고 실수로 잘못된 타입을 배열에 넣는 코드를 마구 짠 후,

컴파일 시점에선 모르던 문제가 런타임 시점에서 발견된다면...

이렇게 보면 또 귀찮고 깐깐하지만 컴파일 시점에서 타입을 확실히 확인해주는 제네릭이 고마워 지는 거 같아요.

어후 자야지.
 */