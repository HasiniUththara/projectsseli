package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class BrowserManager {

    private final String BROWSER_TYPE= "chrom";
    private WebDriver driver;

    public  void setupBrowserDrivers(String BROWSER_TYPE) {


        switch (BROWSER_TYPE.toLowerCase()) {
            case "chrom","google-chrome", "chrom-headless" -> {
                WebDriverManager.chromedriver().setup();

            }case "firefox", "firefox-headless" -> {
                WebDriverManager.firefoxdriver().setup();

            }case "ie" -> {
                WebDriverManager.iedriver().setup();

            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();

            }
            case "opera" -> {
                WebDriverManager.operadriver().setup();

            }case "safari" ->{
                break;

            } default -> {
                System.exit(-1);
            }

        }
        }

        public  void launchBrowser(String BROWSER_TYPE) {

        switch (BROWSER_TYPE.toLowerCase()) {
            case "chrom" -> {
                driver = new ChromeDriver();
                break;

            }case "firefox", "firefox-headless" -> {
                driver = new FirefoxDriver();
                break;


            }case "ie" -> {
                driver = new InternetExplorerDriver();
                break;

            }
            case "edge" -> {
                driver = new EdgeDriver();
                break;

            }
            case "opera" -> {
                driver = new OperaDriver();
                break;

            }case "chrome-headless"->{
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);
                break;
            }case "safari" ->{
                driver = new SafariDriver();

            } default ->{
                System.exit(-1);
            }

        }
        }
     @Test
    public void testBrowsers(){
        setupBrowserDrivers(BROWSER_TYPE);
        launchBrowser(BROWSER_TYPE);
        driver.manage().window().maximize();
        //driver.navigate().refresh();
        //driver.navigate().back();
        //driver.navigate().forward();
        //driver.manage().window().minimize();


        driver.get("http://hrm.pragmatictestlabs.com/");
     }

}


//create git hub project
//login/add employee/positive and negative test cases
