package browserManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type){

        DriverManager driverManager = null;

        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            case CHROME_MAC:
                driverManager = new ChromeDriverMacManager();
            default:
                System.out.println("Invalid browser selected");
                break;
        }

        return driverManager;

    }
}
