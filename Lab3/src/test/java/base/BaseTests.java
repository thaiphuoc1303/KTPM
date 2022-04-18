package base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTests {
    private WebDriver driver;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.sendKeys("tomsmith");
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[contains(text(), 'Login')]")).click();
        driver.navigate().back();
        List<WebElement> inputList = Collections.singletonList(driver.findElement(By.tagName("input")));
        System.out.println(inputList.size());
        for (WebElement element:inputList){
            System.out.println("Element: " + element.getAttribute("name"));
        }
        for (int i = 0; i < inputList.size(); i++){
            System.out.println("Element: "+ inputList.get(i).getAttribute("name"));
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}
