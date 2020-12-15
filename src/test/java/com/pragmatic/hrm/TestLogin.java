package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestLogin{

    private WebDriver webDriver;

    @BeforeMethod
    private WebDriver BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        //WebDriver
        webDriver = new ChromeDriver();
        webDriver.get("http://hrm.pragmatictestlabs.com/");
        return webDriver;
    }

    @AfterMethod

    public void afterMethod(){

        webDriver.close();
    }

    @Test
    public void testValidUserLogin(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        webDriver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //click the login button
        webDriver.findElement(By.id("btnLogin")).click();


        //verify the welcome message
        Assert.assertEquals(webDriver.findElement(By.id("welcome")).getText(),"Welcome Admin");


    }

    @Test
    public void testValidUserLoginWithEnterKeyPress(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        webDriver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321" + Keys.ENTER);


        //verify the welcome message
        Assert.assertEquals(webDriver.findElement(By.id("welcome")).getText(),"Welcome Admin");



    }
    @Test
    public void testValidUserLoginWithSubmitMethod(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        webDriver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        webDriver.findElement(By.id("txtPassword")).submit();


        //verify the welcome message
        Assert.assertEquals(webDriver.findElement(By.id("welcome")).getText(),"Welcome Admin");



    }


@Test
    public void testUserLoginWithBlankUserNameAndBlankPassword(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).clear();

        //type the password
        webDriver.findElement(By.id("txtPassword")).clear();
        webDriver.findElement(By.id("txtPassword")).submit();


        //verify the error message
        Assert.assertEquals(webDriver.findElement(By.id("spanMessage")).getText(),"Username cannot be empty");

    }
@Test
    public void testUserLoginWithBlankUserName(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).clear();

        //type the password
        webDriver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        webDriver.findElement(By.id("txtPassword")).submit();


        //verify the error message
        Assert.assertEquals(webDriver.findElement(By.id("spanMessage")).getText(),"Username cannot be empty");

    }

@Test
    public void testUserLoginWithBlankPassword(){



        //type the user name
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).click();
        webDriver.findElement(By.id("txtPassword")).submit();


        //verify the error message
        Assert.assertEquals(webDriver.findElement(By.id("spanMessage")).getText(),"Password cannot be empty");

    }






}
