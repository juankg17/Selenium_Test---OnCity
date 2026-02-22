package pom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
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
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // 2. Ahora sí, usamos el 'element' (no el 'locator') en el JavaScript
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", element);
        } catch (Exception e) {
            System.out.println("No se pudo dar foco con JS, intentando normal...");
        }
        element.clear();
        element.sendKeys(input);*/
        driver.findElement(locator).clear(); // Limpiamos el textbox para evitar concatenar texto
        driver.findElement(locator).sendKeys(input);
    }

    public void takeScreenshot(String name) {
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // La ruta debe coincidir con lo que pusimos en el YAML
            String path = "target/surefire-reports/screenshot_" + name + ".png";
            FileUtils.copyFile(scrFile, new File(path));
            System.out.println("Screenshot guardada en: " + path);
        } catch (Exception e) {
            System.out.println("No se pudo tomar la captura: " + e.getMessage());
        }
    }
}
