package com.leoli.test;

import com.leoli.login.LoginBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumUITest {

//    @Before
//    public void setUp () {
//        System.out.println("Setup done");
//    }



    @Test
    public void testUpLoadScript() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/mikeli/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginBase lb = new LoginBase();
        String baseUrl = lb.getBaseUrl();
        String userName = lb.getUserName();
        String password = lb.getPassword();
        System.out.println(userName + password +baseUrl);

        driver.get(baseUrl);
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).sendKeys(userName);
        String expectedTitle = "Orion | Nebula AI Cloud";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle+expectedTitle);

        Thread.sleep(3000);

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Login Page Test Passed!");
        } else {
            System.out.println("Login Page Test Failed");
        }
//        WebDriverWait wait = new WebDriverWait(Driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"m_login_signin_submit\"]")).click();

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Machine Learning"))));
        Thread.sleep(3000);
        driver.findElement((By.linkText("Machine Learning"))).click();

        Thread.sleep(3000);

        driver.findElement(By.id("serviceType")).click();
//        driver.findElement(By.V("Micro")).click();
        // driver.find_element_by_id("2").click()
        // driver.find_element_by_id("3").click()

        Select dropdown = new Select(driver.findElement(By.id("serviceType")));
        dropdown.selectByValue("Micro");

//        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).sendKeys(userName);
//        driver.findElement(By.name("password")).clear();
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.cssSelector("#m_login_signin_submit")).click();

        driver.close();
    }
//    @After
//    public void tearDown () {
////        WebDriver driver = new ChromeDriver();
////        driver.quit();
//        System.out.println("TearDown done");
//    }

    }

