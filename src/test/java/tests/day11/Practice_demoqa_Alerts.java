package tests.day11;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Practice_demoqa_Alerts extends TestBase {

    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(6000);
        System.out.println(driver.switchTo().alert().getText());

    }
}
