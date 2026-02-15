package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SimplePage extends BasePage{

    private By inputNombreLocator = By.id("et_pb_contact_name_0");
    private By inputEmailLocator = By.id("et_pb_contact_email_0");
    private By botonSubmitLocator = By.name("et_builder_submit_button");
    private String simplePageTitle = "Simple HTML Elements For Automation - Ultimate QA";
    private By checkBoxBike = By.xpath("//input[@value='Bike']");
    private By checkBoxCar = By.xpath("//input[@value='Car']");
    private By radioMale = By.cssSelector("input[value='male']");
    private By radioFemail = By.cssSelector("input[value='female']");
    private By radioOther = By.cssSelector("input[value='other']");
    private By tableNoIdLocator = By.xpath("//div[2]//div[5]//div[1]//table//tbody/tr");

    private By selectBoton = By.xpath("//div[contains(@class,'et_pb_blurb_description')]//select");


    public By getInputNombreLocator(){return inputNombreLocator;}
    public By getInputEmailLocator(){return inputEmailLocator;}
    public By getBotonSubmitLocator(){return botonSubmitLocator;}
    public By getCheckBoxBike(){return checkBoxBike;}
    public By getCheckBoxCar(){return checkBoxCar;}
    public By getRadioMale(){return radioMale;}
    public By getRadioFemail(){return radioFemail;}
    public By getRadioOther(){return radioOther;}
    public By getSelectBoton(){return selectBoton;}
    public String getSimplePageTitle(){return simplePageTitle;}

    public void setInputNombre(String input){ type(input, inputNombreLocator);}
    public void setInputEmail(String input){ type(input, inputEmailLocator);}
    public void clickBotonSubmit() throws Exception { this.click(botonSubmitLocator);}
    public void clickBotonCheck(By locator) throws Exception { this.click(locator);}

    // Busca en un dropDownList un valor específico, lo marca y devuelve el valor seleccionado
    public String selectDropDownList() throws Exception {
        WebElement dropDownList = getElement(selectBoton);
        List<WebElement> options = dropDownList.findElements(By.tagName("option"));

        for (int i = 0; i < options.size(); i++) {
            System.out.println("Options : " + getText(options.get(i)));
            if (getText(options.get(i)).equals("Audi")){
                click(options.get(i));
            }
        }

        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()){
                selectedOption = getText(options.get(i));
            }
        }

        return selectedOption;
    }

    // Muestra el valor de un tag de tabla para una determinada condición
    public void mostrarValueTable() throws Exception {
        List<WebElement> rows = getElements(tableNoIdLocator);
        String searchPrice = "";
        String searchCondition = "Quality Assurance Engineer";

        System.out.println("rows.size: " + rows.size());
        // Itera sobre tabla dinámica
        for (int i = 2; i <= rows.size(); i++) {
            //WebElement searchRow = getElement(By.xpath("//div[5]//div[1]//table[1]/tbody/tr["+i+"]//td[1]"));
            WebElement searchRow = getElement(By.xpath("//div[2]//div[5]//div[1]//table//tbody/tr["+i+"]//td[1]"));
            if (searchRow.getText().equals(searchCondition)){
                searchPrice = getElement(By.xpath("//div[5]//div[1]//table[1]/tbody/tr["+i+"]//td[3]")).getText();
                break;
            }
        }

        if (!searchPrice.isEmpty()){
            System.out.println("El salario para " + searchCondition + " es: " + searchPrice);
        }

    }

    // Muestra todos los valores de una tabla
    public void mostrarAllValuesTable() throws Exception {
        List<WebElement> rows = getElements(tableNoIdLocator);
        int colCount = getElements(By.xpath("//div[2]//div[5]//div[1]//table//tbody//th")).size();

        System.out.println("rows.size: " + rows.size());
        // Itera sobre tabla dinámica
        for (int i = 2; i <= rows.size(); i++) {
            for (int j = 1; j <= colCount; j++) {
                System.out.print(getElement(By.xpath("//div[5]//div[1]//table[1]/tbody/tr["+i+"]//td["+j+"]")).getText());
                if (j != colCount){
                    System.out.print(" - ");
                }
            }
            System.out.println();
            if (i != rows.size()){
                System.out.println("-----");
            }

        }
    }

    public SimplePage(WebDriver driver){super(driver);}
}
