package Selenium_Test;

import org.junit.jupiter.api.*;
import pom.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePage_Test extends TestBase{

    private HomePage homePage = new HomePage(driver);

    @Test
    @Order(1)
    public void isHomePageDisplayed() throws Exception {
        Assertions.assertEquals(homePage.getHomeTitle(),homePage.getTitle());
    }

    @Test
    @Order(2)
    public void searchProduct() throws InterruptedException {
        homePage.searchProduct(homePage.getProductoSearch());
    }

    @Test
    @Order(3)
    public void clickBuscarProducto() throws Exception {
        homePage.clickSearchBoton();
    }

    @Test
    @Order(4)
    public void clickProductoEncontrado() throws Exception {
        homePage.clickProducto();
    }

    @Test
    @Order(5)
    public void clickBotonAddCart() throws Exception {
        homePage.clickBotonAddCart();
    }

    @Test
    @Order(6)
    public void clickFinalizarCompra() throws Exception {
        homePage.clickCheckOut();
    }

    @Test
    @Order(7)
    public void clickFinalCheckOut() throws Exception {
        homePage.clickFinalCheckOut();
    }
}
