package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try{
            driver.findElement(element).click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento " + element);
        }
    }

    public void click(WebElement element) throws Exception {
        try{
            element.click();
        }catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento " + element);
        }
    }

    public boolean isDisplayed(By element) throws Exception {
        try{
            return driver.findElement(element).isDisplayed();
        }catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento " + element);
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento " + element);
        }
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento " + element);
        }
    }

    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el titulo del driver");
        }
    }

    public void isSelected(By locator) throws Exception {
        try{
            driver.findElement(locator).isSelected();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public WebElement getElement(By locator) throws Exception {
        try{
            return driver.findElement(locator);
        }catch (Exception e){
            throw new Exception("No se pudo obtener el elemento " + locator);
        }
    }

    public List<WebElement> getElements(By locator) throws Exception {
        try{
            return driver.findElements(locator);
        } catch (Exception e) {
            throw new Exception("No se pudieron obtener los elementos " + locator);
        }
    }

    // Agrega tiempo y espera hasta que el elemento este visible
    public void waitUntilVisibilityOfElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Espera a que el elemento sea clickeable
    public void waitUntilElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void type(String input, By locator){
        waitUntilVisibilityOfElement(locator);
        waitUntilElementToBeClickable(locator);
        try {
            BasePage.this.click(locator);
        } catch (Exception e) {
            // Si el click normal falla, usamos JavaScript para forzar el foco
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", locator);
        }

        driver.findElement(locator).sendKeys(input);
    }
}
