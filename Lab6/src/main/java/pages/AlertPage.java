package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private  By buttomJSAlert = By.xpath("//button[contains(text(), 'Click for JS Alert')]");

    public AlertPage(WebDriver driver) {
        this.driver =driver;
    }
    public void clickButtonJSAlert(){
        driver.findElement(buttomJSAlert).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlertResult() {
        return driver.switchTo().alert().getText();
    }
}
