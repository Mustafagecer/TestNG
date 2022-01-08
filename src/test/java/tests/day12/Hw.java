package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Hw extends TestBase {
    @Test
    public void enableTest() throws InterruptedException {
        //1. Bir class olusturun : ExplicitlyWaitTest
        // 2. Bir metod olusturun : enableTest()
        // 3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");
        // 4. Will enable 5 seconds'in etkin olmadigini(enabled) test edin
        WebElement willNotEnable=driver.findElement(By.id("enableAfter"));
        Assert.assertTrue(!willNotEnable.isEnabled(),"will Enable is enable");
        // 5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
       Thread.sleep(6000);
        Assert.assertTrue(willNotEnable.isEnabled(),"will Enable is not enable");
        // 6. Bir metod olusturun : visibleTest()
        //7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin, ve gorunur oldugunu test edin

        WebElement visibleAfter5Second=driver.findElement(RelativeLocator.with(By.id("visibleAfter")).below(willNotEnable).below(willNotEnable));
        Assert.assertTrue(visibleAfter5Second.isEnabled());

    }
}
