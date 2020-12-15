package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class JavascriptPopupsExample {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/Alerts.html");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void testBasicAlert(){
        driver.findElement(By.xpath("//*[@id=\"cid_16\"]/div/div/button")).click();
        //verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage,"This Is Simple Alert");

        driver.switchTo().alert().accept();

        //verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation,"Alert is gone.");
     }

     @Test
    public void testConfirmationOk(){
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();
        //verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage,"Press a button!");

        //click the OK/Yes button
        driver.switchTo().alert().accept();

        //verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation,"Confirmed.");
     }

     @Test
    public void testConfirmationCancel(){
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();
        //verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage,"Press a button!");

        //click the OK/Yes button
        driver.switchTo().alert().dismiss();

        //verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation,"Rejected!");
     }

     @Test
    public void testPrompt(){
         String name = "Hasini";
         driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();

         //verify the text
         String strMessage = driver.switchTo().alert().getText();
         Assert.assertEquals(strMessage,"Please enter your name");

         //Type Text
         driver.switchTo().alert().sendKeys(name);


        //click the OK/Yes button
        driver.switchTo().alert().accept();

        //verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, name);
     }


     @Test
    public void testTimingAlert(){

         driver.findElement(By.xpath("//button[contains(text(),'Timing Alert')]")).click();

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.alertIsPresent());

        //click the OK/Yes button
        driver.switchTo().alert().accept();

        //verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation,"0");
     }


}
