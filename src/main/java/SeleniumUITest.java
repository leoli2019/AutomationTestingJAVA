import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SeleniumUITest {

    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver","C:\\Users\\win10\\IdeaProjects\\AutomationTestingJAVA\\src\\main\\java\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://nbai.io/dashboard/#/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='loginUserLog']")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();
        //login
        driver.findElement(By.xpath("/html/body")).click();
//        String loginPage = lb.getBaseUrl();


    }

}

