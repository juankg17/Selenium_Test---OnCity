package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class CheckOutPage extends BasePage{

    private By finalCheckOutLocator = By.id("cart-to-orderform");
    private By preEmailLocator = By.id("client-pre-email");
    private String preEmailText = "prueba@gmail.com";
    private By btnContinuarEmail = By.id("btn-client-pre-email");
    private By inputNameLocator = By.id("client-first-name");
    private By inputLastnameLocator = By.id("client-last-name");
    private By inputDocument = By.id("client-document");
    private By inputPreNumber = By.id("client-phone1");
    private By inputNumber = By.id("client-phone3");
    private By btnContinuarEntrega = By.id("go-to-shipping");
    private By inputCalleLocator = By.id("ship-street");
    private By inputNumCalleLocator = By.id("ship-number");
    private By inputNameDestLocator = By.id("ship-receiverName");
    private By selectProvBtn = By.id("ship-state");
    private By selectCityBtn = By.id("ship-city");
    private By btnElijaFecha = By.id("scheduled-delivery-choose-Llega-en 24 hrs");
    private By dateToSelect = By.xpath("//div[@aria-label='day-20']");
    private By btnContinuarPago = By.id("btn-go-to-payment");
    //private By btnFinalizarCompra = By.xpath("//span[normalize-space()='Finalizar Compra']");
    private By btnFinalizarCompra = By.xpath("//button[contains(@class, 'jsSubmitFakeButton')]");

    public void clickFinalizarCompra() throws Exception {
        takeScreenshot("CHECKOUT");
        waitUntilVisibilityOfElement(btnFinalizarCompra);

        waitUntilElementToBeClickable(btnFinalizarCompra);

        // 4. Click con JS como respaldo si el click normal es interceptado
        try {
            if (getElements(btnContinuarEmail).size() > 0){
                ingresarPreEmail(getPreEmailText());
            }
            click(btnFinalizarCompra);
            System.out.println("✅ Click en Finalizar Compra realizado.");
        } catch (Exception e) {
            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnFinalizarCompra);
            System.out.println("✅ Click en Finalizar Compra realizado vía JS.");
        }
        //click(btnFinalizarCompra);
    }

    public void clickFinalCheckOut() throws Exception {
        waitUntilVisibilityOfElement(finalCheckOutLocator);
        click(finalCheckOutLocator);
    }

    public void clickContinuarPago() throws Exception {
        waitUntilVisibilityOfElement(btnContinuarPago);
        click(btnContinuarPago);
    }

    public void clickBtnElijaFecha() throws Exception {
        waitUntilVisibilityOfElement(btnElijaFecha);
        click(btnElijaFecha);
    }

    public void selectDate() throws Exception {
        waitUntilVisibilityOfElement(dateToSelect);
        //click(dateToSelect);
        List<WebElement> allDates = getElements(By.xpath("//div[@class='react-datepicker__week'][5]//div[not(contains(@class, 'disabled'))]"));

        // now we will iterate all values and will capture the text. We will select when date is 28
        for(WebElement ele:allDates)
        {
            String date=ele.getText();
            System.out.println("Afuera del if - Date: " + date);

            // Si encontró al menos una fecha disponible hace click
            if(!allDates.isEmpty()){
                click(ele);
                break;
            }
            // once date is 20 then click and break
            /*if(date.equalsIgnoreCase("20"))
            {
                ele.click();
                System.out.println("Date: " + date + " is enable");
                break;
            }*/
        }

    }

    public By getSelectProvBtn(){ return selectProvBtn;}
    public By getSelectCityBtn(){return selectCityBtn;}

    public void ingresarInputcalle(String _inputCalle){
        waitUntilVisibilityOfElement(inputCalleLocator);
        type(_inputCalle, inputCalleLocator);
    }

    public void ingresarInputNumCalle(String _inputNumCalle){
        waitUntilVisibilityOfElement(inputNumCalleLocator);
        type(_inputNumCalle, inputNumCalleLocator);
    }

    public void ingresarInputNameDest(String _inputNameDest){
        waitUntilVisibilityOfElement(inputNameDestLocator);
        type(_inputNameDest, inputNameDestLocator);
    }

    public String getPreEmailText(){
        return preEmailText;
    }

    public void ingresarNombre(String _inputName){
        waitUntilVisibilityOfElement(inputNameLocator);
        type(_inputName, inputNameLocator);
    }

    public void ingresarLastName(String _inputLastName){
        waitUntilVisibilityOfElement(inputLastnameLocator);
        type(_inputLastName, inputLastnameLocator);
    }

    public void ingresarDocument(String _inputDocumento){
        waitUntilVisibilityOfElement(inputDocument);
        type(_inputDocumento,inputDocument);
    }

    public void ingresarPreNumber(String _inputPreNumber){
        waitUntilVisibilityOfElement(inputPreNumber);
        type(_inputPreNumber,inputPreNumber);
    }

    public void ingresarNumber(String _inputNumber){
        waitUntilVisibilityOfElement(inputNumber);
        type(_inputNumber,inputNumber);
    }

    public void ingresarPreEmail(String _preEmailText){
        waitUntilVisibilityOfElement(preEmailLocator);
        type(_preEmailText, preEmailLocator);
    }

    public void clickbtnContinuarEmail() throws Exception {
        waitUntilVisibilityOfElement(btnContinuarEmail);
        click(btnContinuarEmail);
    }

    public void clickbtnContinuarEntrega() throws Exception {
        waitUntilVisibilityOfElement(btnContinuarEntrega);
        click(btnContinuarEntrega);
    }

    public void selectDropDownList(String _inputProv, By _locator) throws Exception {
        WebElement dropDownList = getElement(_locator);
        List<WebElement> options = dropDownList.findElements(By.tagName("option"));

        for (int i = 0; i < options.size(); i++) {
            //System.out.println("option: " + getText(options.get(i)));
            //System.out.println("_inputProv: " + _inputProv);
            if(getText(options.get(i)).equals(_inputProv)){
                //System.out.println("Entro al if --- ");
                waitUntilVisibilityOfElement(_locator);
                click(options.get(i));
                break;
            }
        }

        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()){
                selectedOption = getText(options.get(i));
                break;
            }
        }
    }

    public CheckOutPage(WebDriver driver){
        super(driver);
    }
}
