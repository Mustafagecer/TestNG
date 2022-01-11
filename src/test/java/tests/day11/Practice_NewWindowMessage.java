package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Practice_NewWindowMessage extends TestBase {

    @Test
    public void NewWindowMessageHandle(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.xpath("(//*[@type='button'])[3]")).click();

        String firstWindowHandleNumber=driver.getWindowHandle();
        String secondWindowHandleNumber="";

        for (String each:driver.getWindowHandles()){
            if(!each.equals(firstWindowHandleNumber)){
                secondWindowHandleNumber=each;
            }
        }

        System.out.println(firstWindowHandleNumber+"    "+secondWindowHandleNumber);

        driver.switchTo().window(secondWindowHandleNumber);
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("sample"),"Galiba bir sorun var");
    }

}
