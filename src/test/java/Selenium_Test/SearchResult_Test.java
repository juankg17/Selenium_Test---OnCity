package Selenium_Test;

import org.junit.jupiter.api.*;
import pom.CheckOutPage;
import pom.HomePage;
import pom.ProductPage;
import pom.SearchResultPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchResult_Test extends TestBase{

    private HomePage homePage = new HomePage(driver);
    private SearchResultPage searchResultPage = new SearchResultPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private CheckOutPage checkOutPage = new CheckOutPage(driver);

    @Test
    @Order(1)
    public void isHomePageDisplayed() throws Exception {
        Assertions.assertEquals(homePage.getHomeTitle(),homePage.getTitle());
    }

    @Test
    @Order(2)
    public void searchProduct() throws InterruptedException {
        homePage.takeScreenshot("HOME_START");
        homePage.searchProduct(homePage.getProductoSearch());
        homePage.takeScreenshot("HOME_Finish");
    }

    @Test
    @Order(3)
    public void clickBuscarProducto() throws Exception {
        homePage.clickSearchBoton();
    }

    @Test
    @Order(4)
    @Disabled
    public void mostrarResultados() throws Exception {
        searchResultPage.mostrarResultados();
    }

    @Test
    @Order(5)
    public void clickProductoEncontrado() throws Exception {
        searchResultPage.clickProducto();
    }

    @Test
    @Order(6)
    public void clickBotonAddCart() throws Exception {
        productPage.clickBotonAddCart();
    }

    @Test
    @Order(7)
    public void clickCheckOut() throws Exception {
        productPage.clickCheckOut();
    }

    @Test
    @Order(8)
    public void clickFinalCheckOut() throws Exception {
        checkOutPage.clickFinalCheckOut();
    }

    @Test
    @Order(9)
    public void ingresarPreEmail(){
        checkOutPage.ingresarPreEmail(checkOutPage.getPreEmailText());
    }

    @Test
    @Order(10)
    public void clickbtnContinuarEmail() throws Exception {
        checkOutPage.clickbtnContinuarEmail();
    }

    @Test
    @Order(11)
    public void ingresarDatosComprador(){
        checkOutPage.ingresarNombre("Pepe");
        checkOutPage.ingresarLastName("Gonzalez");
        checkOutPage.ingresarDocument("37987456");
        checkOutPage.ingresarPreNumber("11");
        checkOutPage.ingresarNumber("45854525");
    }

    @Test
    @Order(12)
    public void clickContinuarEntrega() throws Exception {
        checkOutPage.clickbtnContinuarEntrega();
    }

    @Test
    @Order(13)
    public void ingresarDatosEntrega() throws Exception {
        checkOutPage.ingresarInputcalle("Fray Justo");
        checkOutPage.ingresarInputNumCalle("4000");
        checkOutPage.ingresarInputNameDest("Pepe Lopez");
        checkOutPage.selectDropDownList("Ciudad Autónoma de Buenos Aires", checkOutPage.getSelectProvBtn());
        checkOutPage.selectDropDownList("Ciudad Autónoma de Buenos Aires", checkOutPage.getSelectCityBtn());
        checkOutPage.clickBtnElijaFecha();
        checkOutPage.selectDate();
        checkOutPage.clickContinuarPago();
    }

    @Test
    @Order(14)
    public void clickFinalizarCompra() throws Exception {
        checkOutPage.clickFinalizarCompra();
    }

}
