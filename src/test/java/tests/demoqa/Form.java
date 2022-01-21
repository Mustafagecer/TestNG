package tests.demoqa;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Form extends TestBase {
    @Test
    public void test(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).click();
        Actions actions=new Actions(driver);
        Faker faker=new Faker();


    }

}
