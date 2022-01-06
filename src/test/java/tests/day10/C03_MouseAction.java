package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C03_MouseAction extends TestBase {
    @Test
    public void test(){

        //1- Yeni bir class olusturalim: C03_MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));

        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.

        String alertYazisi=driver.switchTo().alert().getText();

        System.out.println(alertYazisi);

        Assert.assertTrue(alertYazisi.equals("You selected a context menu"),"Yazi girilen textiicermiyor");

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim

        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String ilkSayfaninHandleKodu=driver.getWindowHandle();
        String ikinciSayfaninHandleKodu="";

        for (String each:driver.getWindowHandles()
             ) {
            if(!each.equals(ilkSayfaninHandleKodu)){
                ikinciSayfaninHandleKodu=each;
            }

        }
        driver.switchTo().window(ikinciSayfaninHandleKodu);

        WebElement elementalSeleniumWebElementi=driver.findElement(By.tagName("h1"));

        System.out.println(elementalSeleniumWebElementi.getText());
        Assert.assertEquals(elementalSeleniumWebElementi.getText(),"Elemental Selenium");



    }

}
