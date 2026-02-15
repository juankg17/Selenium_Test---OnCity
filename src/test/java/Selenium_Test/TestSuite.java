package Selenium_Test;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class TestSuite {

    @Nested
    @Order(1)
    @Disabled
    class TestCases extends Selenium_Test.TestCases {
    }

    @Nested
    @Order(2)
    class Rectangulo_Test extends Selenium_Test.Rectangulo_Test {}

    @Nested
    @Order(3)
    @Disabled
    class EmailInvalidoTest extends EmailInvalido_Test{}

}

