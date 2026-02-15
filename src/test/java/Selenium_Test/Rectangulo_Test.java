package Selenium_Test;

import utils.Rectangulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Rectangulo_Test {

    @DisplayName("Prueba CSV")
    @ParameterizedTest
    @CsvFileSource(resources = "/excelfiles/Rectan.csv", numLinesToSkip = 1)
    public void test(int sum1, int sum2){
        Rectangulo r = new Rectangulo(sum1,sum2);
    }

    @Test
    public void mostrar(){
        System.out.println("Rectangulo Test");
    }
}
