package alerts;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickButtonJSAlert();
        alertPage.acceptJSAlert();
        Assertions.assertEquals(alertPage.getAlertResult(), "You successfully clicked an alert", "Result alert is incorrect");
    }
}
