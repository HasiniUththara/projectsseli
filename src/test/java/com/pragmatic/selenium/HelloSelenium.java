package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {

    public static void main(String[] args){

        //setup the browser driver
        WebDriverManager.chromedriver().setup();
        //create an instant of the web browser
        WebDriver driver = new ChromeDriver();
        //navigate to the login page
        driver.get("http://119.235.1.59:8010/");
    }
}
