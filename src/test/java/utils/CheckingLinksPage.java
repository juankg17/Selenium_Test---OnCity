package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pom.BasePage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckingLinksPage extends BasePage {
    //private WebDriver driver;

    public CheckingLinksPage (WebDriver driver){
        super(driver);
    }

    public boolean checkingPageLinks() throws Exception {
        List<WebElement> links = getElements(By.tagName("a"));
        String url = "";
        List<String> brokenLinks = new ArrayList<String>();
        List<String> okLinks = new ArrayList<String>();

        HttpURLConnection httpURLConnection = null;
        int responseCode = 200;
        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){
            url = it.next().getAttribute("href");
            if (url == null || url.isEmpty()){
                System.out.println(url + " url is not configured or it is empty");
                continue;
            }
            try{
                if(url.contains("http") || url.contains("https")) {
                    httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();

                    if (responseCode >= 400) {
                        System.out.println("Error broken link: -- " + url);
                        brokenLinks.add(url);
                    } else {
                        System.out.println("Valid link: -- " + url);
                        okLinks.add(url);
                    }
                }else {
                    System.out.println("La sintaxis de la url es invalida: " + url);
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Entro en catch " + url);
                throw new Exception("Entro en error");
            }
        }

        System.out.println("Valid links " + okLinks.size());
        System.out.println("Invalid links: " + brokenLinks.size());

        if (brokenLinks.size() > 0){
            System.out.println("***** ERROR --------------------- Broken Links");
            for (int i = 0; i < brokenLinks.size(); i++) {
                System.out.println(brokenLinks.get(i));
            }
            return false;
        }else {
            return true;
        }
    }
}
