import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SeleniumUITest {

    public void login() {
//        LoginBase lb = new LoginBase();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\win10\\IdeaProjects\\AutomationTestingJAVA\\src\\main\\java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://nbai.io/dashboard/#/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='loginUserLog']")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //login
        driver.findElement(By.xpath("/html/body")).click();
//        String loginPage = lb.getBaseUrl();


    }

}

