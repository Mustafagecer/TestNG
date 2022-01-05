package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
    // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
    //● https://the-internet.herokuapp.com/windows adresine gidin.

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

    String actualText=driver.findElement(By.tagName("h3")).getText();
    String expectedText="Opening a new window";
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualText,expectedText,"Gercekle beklenen sonuc uyusmuyor");

    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        softAssert.assertEquals(driver.getTitle(),"The Internet","Gercekle beklenen sonuc uyusmuyor2");

    //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();

    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        softAssert.assertEquals(driver.getTitle(),"New Window","Yeni acilan sayfasin Basligi New Window degil");
        softAssert.assertAll();

    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
}}
