package Selenium_Test;

import org.junit.jupiter.api.*;
import pom.SimplePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimplePage_Test extends TestBase{

    private SimplePage simplePage = new SimplePage(driver);

    @Test
    @Order(1)
    public void isSimplePageDisplayed() throws Exception {
        // Valida que se encuentre en la página SimplePage
        Assertions.assertEquals(simplePage.getSimplePageTitle(), simplePage.getTitle());
    }

    @Test
    @Order(2)
    public void completarFormulario(){
        simplePage.setInputNombre("Juan");
        simplePage.setInputEmail("pepe@gmail.com");
    }

    @Test
    @Order(3)
    public void clickBotonEnviar() throws Exception {
        simplePage.clickBotonSubmit();
    }

    @Test
    @Order(4)
    public void checkBoxBike() throws Exception {
        simplePage.clickBotonCheck(simplePage.getCheckBoxBike());
        simplePage.isSelected(simplePage.getCheckBoxBike());
    }

    @Test
    @Order(5)
    public void checkBoxCar() throws Exception {
        simplePage.clickBotonCheck(simplePage.getCheckBoxCar());
        simplePage.isSelected(simplePage.getCheckBoxCar());
    }

    @Test
    @Order(6)
    public void checkRadioButonMale() throws Exception {
        if (simplePage.isDisplayed(simplePage.getRadioMale())) {
            simplePage.click(simplePage.getRadioMale());
            simplePage.isSelected(simplePage.getRadioMale());
        }
    }

    @Test
    @Order(7)
    public void checRadioButonFemail() throws Exception {
        if (simplePage.isDisplayed(simplePage.getRadioFemail())) {
            simplePage.click(simplePage.getRadioFemail());
            simplePage.isSelected(simplePage.getRadioFemail());
        }
    }

    @Test
    @Order(8)
    public void checkRadioButonOther() throws Exception {
        if (simplePage.isDisplayed(simplePage.getRadioOther())) {
            simplePage.click(simplePage.getRadioOther());
            simplePage.isSelected(simplePage.getRadioOther());
        }
    }

    @Test
    @Order(9)
    public void clickSelectBoton() throws Exception {
        if(simplePage.isDisplayed(simplePage.getSelectBoton())){
            simplePage.click(simplePage.getSelectBoton());
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @Test
    @Order(10)
    public void validateSelectedOption() throws Exception {
        Assertions.assertEquals("Audi", simplePage.selectDropDownList());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Order(11)
    public void showValueTable() throws Exception {
        simplePage.mostrarValueTable();
    }

    @Test
    @Order(12)
    public void showAllValuesTable() throws Exception {
        simplePage.mostrarAllValuesTable();
    }

}
