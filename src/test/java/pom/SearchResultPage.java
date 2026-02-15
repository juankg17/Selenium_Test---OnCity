package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage{

    private By resultContainerLocator = By.xpath("//div[@id='gallery-layout-container']/div");
    private By notebookLocator = By.xpath("//span[contains(@class, 'vtex-product-summary-2-x-productBrand') and contains(text(), 'Notebook Hp 15-Fd0155la Intel Core I5')]");

    public void mostrarResultados() throws Exception {
        List<WebElement> rows = getElements(resultContainerLocator);
        System.out.println("rows size: " + rows.size());
    }

    // Hace click en el producto buscado
    public void clickProducto() throws Exception {
        try {
            // 2. Esperar hasta que el elemento sea VISIBLE
            // Si no es clicable, al menos sabemos que existe y está renderizado.
            waitUntilVisibilityOfElement(notebookLocator);
            click(notebookLocator);
            System.out.println("Éxito: El elemento fue localizado y se intentó interactuar.");
        } catch (Exception e) {
            System.err.println("Error: El elemento no apareció en el tiempo esperado. Mensaje: " + e.getMessage());
        }
    }

    public SearchResultPage(WebDriver driver){
        super(driver);
    }
}
