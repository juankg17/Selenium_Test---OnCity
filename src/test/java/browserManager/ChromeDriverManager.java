package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver(){

        //System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        //driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();

        // Detectamos si estamos en el Pipeline de GitLab
        // GitLab siempre define la variable CI=true
        String isCI = System.getenv("CI");

        if ("true".equalsIgnoreCase(isCI)) {
            // Configuración para el Servidor (GitLab)
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            // ESTO ES CLAVE: Engañamos a la web para que crea que es un Windows real
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            System.out.println("Ejecutando en modo HEADLESS (CI detectado)");
            driver = new ChromeDriver(options);
        } else {
            // Configuración para tu MAC (Local)
            System.out.println("Ejecutando en modo LOCAL con interfaz gráfica");
            // Aquí puedes agregar opciones locales si quieres, como maximizar
            options.addArguments("--start-maximized");
            //System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver(options);
        }

    }
}