package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Amazon extends TestBase {
    @Test
    public void test(){
        driver.get("https://amazon.com");

        driver.findElement(By.id("nav-hamburger-menu")).click();
        driver.findElement(By.xpath("(//*[@class='hmenu-item'])[4]")).click();
       


        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("why?"+Keys.ENTER);
    }
}
