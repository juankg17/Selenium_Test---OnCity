package Selenium_Test;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.HomeForm;

import java.io.File;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailInvalido_Test {
    private String accionEmailInvalido = "UsuarioEmailInvalido";

    private static WebDriver driver;
    private static DriverManager driverManager;
    private HomeForm homeForm = new HomeForm(driver);

    @BeforeAll
    public static void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        String filePath = new File("./src/test/resources/form/Prueba.html").getAbsolutePath();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void usuarioMailInvalido() throws IOException, ParseException {
        homeForm.completarFormulario(accionEmailInvalido);
    }

    @Test
    @Order(2)
    public void presionaBotonEnviar() throws Exception {
        homeForm.clickBotonEnviar();
    }

    @Test
    @Order(3)
    public void mensajeErrorMailInvalido(){
        WebElement pageMsgErrorEmail = driver.findElement(homeForm.getMsgErrorEmailLocator());
        // Se valida que el mensaje recibido, sea el definido
        Assert.assertEquals(homeForm.getMsgErrorEmail(), pageMsgErrorEmail.getText());
    }

    @AfterAll
    public static void tearDown(){
        driverManager.quitDriver();
    }
}

