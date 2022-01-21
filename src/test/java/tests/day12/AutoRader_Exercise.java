package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class AutoRader_Exercise extends TestBase {
    @Test
    public void autotraderAutomation() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.autotrader.co.uk/?refresh=true");
        Thread.sleep(3000);

        WebElement iframe=driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@title='Accept All']")).click();

        WebElement postCode=driver.findElement(By.xpath("//*[@name='postcode']"));
        WebElement postcode= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postcode")));
        postCode.sendKeys("PO16 7GZ");
        Thread.sleep(4000);
        WebElement distance= driver.findElement(By.xpath("//select[@id='distance']"));
        distance.click();
        Select select = new Select(distance);
        select.selectByIndex(3);
        WebElement make= driver.findElement(By.id("make"));
        new Select(make).selectByIndex(4);
        WebElement model= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("model")));
        Thread.sleep(2000);

        new Select(model).selectByIndex(2);
        driver.findElement(By.xpath("(//label)[5]")).click();



    }

}
