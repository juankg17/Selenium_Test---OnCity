package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private By botonAddCartLocator = By.xpath("//span[contains(@class, 'vtex-add-to-cart-button-0-x-buttonText') and contains (text(), 'Sumalo al carrito')]");
    private By checkOutLocator = By.id("proceed-to-checkout");

    // Click en el boton agregar producto al carrito
    public void clickBotonAddCart() throws Exception {
        waitUntilVisibilityOfElement(botonAddCartLocator);
        click(botonAddCartLocator);
    }

    // Hace click en el checkOut (Finalizar Compra)
    public void clickCheckOut() throws Exception {
        waitUntilVisibilityOfElement(checkOutLocator);
        click(checkOutLocator);
    }

    public ProductPage(WebDriver driver){
        super(driver);
    }
}
