package tests.day09;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
public class C03_HW_Iframe {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    //    ● Bir class olusturun: C02_IframeTest
    //    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //    ● Bir metod olusturun: iframeTest
    //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
    //		○ Text Box’a “Merhaba Dunya!” yazin.
    //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //		dogrulayin ve  konsolda yazdirin.

    @Test

    public void iframeTest() throws InterruptedException {
        WebElement baslikYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYaziElementi.isEnabled(),"baslik erisilebilir degil");
        System.out.println(baslikYaziElementi.getText());




    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }
}



