package Selenium_Test;

import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pom.HomeForm;
import utils.ReadExcelFile;

import java.io.File;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases extends TestBase{
    private String accionOk = "UsuarioOk";
    private String accionEmailInvalido = "UsuarioEmailInvalido";
    private String accionPassNoCoincidentes = "UsuarioPassNoCoincidentes";
    private String accionUsuarioEdadInvalida = "UsuarioEdadInvalida";
    private ReadExcelFile readExcelFile;

    //private static WebDriver driver;
    //private static DriverManager driverManager;
    private HomeForm homeForm = new HomeForm(driver);

    /*@BeforeAll
    public static void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        String filePath = new File("./src/test/resources/form/Prueba.html").getAbsolutePath();
        driver.get(filePath);
        driver.manage().window().maximize();
    }*/

    @Test
    @Order(1)
    public void completarFormularioTest(){
        homeForm.completarFormulario(accionOk);
    }

    @Test
    @Order(2)
    public void presionaBotonEnviar() throws Exception {
        homeForm.clickBotonEnviar();
    }

    @Test
    @Order(3)
    public void seMuestraMensajeExitoso(){
        WebElement pageMsgOkLocator = driver.findElement(homeForm.getMsgOkLocator());
        // Guardamos el mensaje recibido en pantalla luego de registrar un usuario
        String msgOk = pageMsgOkLocator.getText();
        // Se valida que el mensaje recibido en pantalla luego de registrar un usuario, sea el definido como Ok
        Assert.assertTrue(msgOk.contains(homeForm.getMsgOk()));
    }

    /*@AfterAll
    public static void tearDown(){
        driverManager.quitDriver();
    }*/

}
