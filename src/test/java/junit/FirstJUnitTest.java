package junit;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class FirstJUnitTest {
    @BeforeAll
    static void beforeAll() {
            System.out.println("Этот метод beforeAll()");
    }

    @BeforeEach
    void beforech(){
        System.out.println("    Этот метод @BeforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("    Этот метод @AfterEach");
    }
    @Test
    void firstTest() {
        System.out.println("        Это firstTest()");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("        Это secondTest()");
        Assertions.assertTrue(3 > 2);
    }

}
