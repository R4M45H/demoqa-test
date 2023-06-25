package junit;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class FirstJUnitTest {
    @BeforeAll
    static void beforeAll() {
            System.out.println("���� ����� beforeAll()");
    }

    @BeforeEach
    void beforech(){
        System.out.println("    ���� ����� @BeforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("    ���� ����� @AfterEach");
    }
    @Test
    void firstTest() {
        System.out.println("        ��� firstTest()");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("        ��� secondTest()");
        Assertions.assertTrue(3 > 2);
    }

}
