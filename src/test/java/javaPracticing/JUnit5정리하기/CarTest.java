package javaPracticing.JUnit5정리하기;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.annotation.Testable;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeAll
    static void setCarBeforeAll(){
        System.out.println("before all");
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.MICROSECONDS)
    void timeOut1() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.MICROSECONDS)
    void timeOut2() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
        }
    }


    @Disabled
    @Test
    void test1(){
        System.out.println("test1");
    }

    @Test
    void test2(){
        System.out.println("test2");
    }
}