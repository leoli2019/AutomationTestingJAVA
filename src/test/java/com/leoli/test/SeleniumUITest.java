package com.leoli.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import com.leoli.login.LoginBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumUITest {

    private WebDriver driver;
//    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String userName;
    private String password;
    private int timeout = 3000;
    private int interval = 500;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));
//        System.out.println(os);
        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else if(os.equalsIgnoreCase("Windows"))
            System.setProperty("webdriver.chrome.drive", "src/test/resources/drivers/chromedriver.exe");

        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();

        LoginBase lb = new LoginBase();
        userName = lb.getUserName();
        password = lb.getPassword();
        baseUrl = lb.getBaseUrl();
        System.out.println(userName + password +baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Setup done");
    }

    @Test
    public void testUpLoadScript() throws InterruptedException {

        driver.get(baseUrl);
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).sendKeys(userName);
        String expectedTitle = "Orion | Nebula AI Cloud";
        String loginTitle = driver.getTitle();
//        System.out.println(loginTitle+expectedTitle);
        try{
            assertEquals("Wrong login page",expectedTitle,loginTitle);
        }catch (Error e){
            verificationErrors.append(e.toString());
        }
        Thread.sleep(3000);

//        if (loginTitle.contentEquals(expectedTitle)) {
//            System.out.println("Login Page Test Passed!");
//        } else {
//            System.out.println("Login Page Test Failed");
//        }
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
        driver.findElement(By.xpath("//*[@id=\"serviceType\"]/option[2]")).click();

//        new Select(driver.findElement(By.id("serviceType"))).selectByVisibleText("Micro");
        driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"time\"]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"m_modal_price\"]/div/div/div[3]/button[1]")).click();

        driver.close();
    }
    @After
    public void tearDown() {
        driver.quit();
        System.out.println("TearDown done");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }

    }

    }

