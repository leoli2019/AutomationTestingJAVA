import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumUITest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp () {

        LoginBase lb = new LoginBase();
        String baseUrl = lb.getBaseUrl();
        String userName = lb.getUserName();
        String password = lb.getPassword();
        String expectedTitle = "Orion | Nebula AI Cloud";
        String actualTitle = "";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown () {
//        WebDriver driver = new ChromeDriver();
        SeleniumUITest td = new SeleniumUITest();
        driver.close();
    }

    @Test
    public void testExamples () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://nbai.io/dashboard/#/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='loginUserLog']")).click();

    }

    public static void main(String[] args) {
        LoginBase lb = new LoginBase();
        String baseUrl = lb.getBaseUrl();
        String userName = lb.getUserName();
        String password = lb.getPassword();
        String expectedTitle = "Orion | Nebula AI Cloud";
        String actualTitle = "";

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
        //                System.setProperty("webdriver.chrome.driver","C:\\Users\\win10\\IdeaProjects\\AutomationTestingJAVA\\src\\main\\java\\chromedriver.exe");

        driver.get("https://nbai.io/dashboard/#/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='loginUserLog']")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // launch Fire fox and direct it to the Base URL

        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driver.findElement(By.xpath("/html/body")).click();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/input")).sendKeys(userName);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElement(By.xpath('//*[@id="m_login_signin_submit"]')).click();
        driver.findElement(By.cssSelector("#m_login_signin_submit")).click();



    }

}