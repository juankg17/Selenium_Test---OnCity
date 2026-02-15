package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private String homeTitle = "On City – Comprá Online con Envío Rápido y Retiro Gratis en Tienda";
    private String productoSearch = "Notebook Hp 15-Fd0155la Intel Core I5";
    private By searchTextLocator = By.xpath("(//input[@id='downshift-0-input'])");
    private By botonSearchTextLocator = By.xpath("//button[@aria-label='Buscar Productos']");
    private By notebookLocator = By.xpath("//span[contains(@class, 'vtex-product-summary-2-x-productBrand') and contains(text(), 'Notebook Hp 15-Fd0155la Intel Core I5')]");
    private By botonAddCartLocator = By.xpath("//span[contains(@class, 'vtex-add-to-cart-button-0-x-buttonText') and contains (text(), 'Sumalo al carrito')]");
    private By checkOutLocator = By.id("proceed-to-checkout");
    private By finalCheckOutLocator = By.id("cart-to-orderform");

    // Devuelve el título de la home
    public String getHomeTitle(){
        return homeTitle;
    }

    // Devuelve el producto buscado
    public String getProductoSearch(){
        return productoSearch;
    }

    // Busca el producto
    public void searchProduct(String _searchProduct) throws InterruptedException {
        waitUntilVisibilityOfElement(searchTextLocator);
        type(_searchProduct, searchTextLocator);
    }

    // Hace click en buscar
    public void clickSearchBoton() throws Exception {
        click(botonSearchTextLocator);
    }

    // Hace click en el producto buscado
    public void clickProducto() throws Exception {
        try {
            // 2. Esperar hasta que el elemento sea VISIBLE
            // Si no es clicable, al menos sabemos que existe y está renderizado.
            waitUntilVisibilityOfElement(notebookLocator);
            click(notebookLocator);
            //System.out.println("Éxito: El elemento fue localizado y se intentó interactuar.");
        } catch (Exception e) {
            System.err.println("Error: El elemento no apareció en el tiempo esperado. Mensaje: " + e.getMessage());
        }
    }

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

    public void clickFinalCheckOut() throws Exception {
        waitUntilVisibilityOfElement(finalCheckOutLocator);
        click(finalCheckOutLocator);
    }

    public HomePage(WebDriver driver){
        super(driver);
    }
}
