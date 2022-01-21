package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class HepsiBurada extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        WebElement searchBox= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        searchBox.sendKeys("kulaklık"+ Keys.ENTER);
        driver.findElement(By.xpath("(//*[@data-test-id='dropdown-toggle'])[2]")).click();
//        Select select = new Select(dropdown);
//        select.selectByIndex(3);
        driver.findElement(By.linkText("Artan Fiyat")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='searchbox-searchInput']")).sendKeys("sony");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='markalar']")).click();
        Thread.sleep(2000);
        String sonyUrl= driver.getCurrentUrl();

        WebElement listOfSony=driver.findElement(By.xpath("//*[@data-test-id='product-card-image-container']"));

    }
}
