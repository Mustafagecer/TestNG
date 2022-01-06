package tests.day08;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
public class C04_SoftAssert_HepsiBurada {
    // Yeni bir Class Olusturun : D11_SoftAssert1
    //“https://www.hepsiburada.com/” Adresine gidin
    //Basliginin “Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com" icerdigini dogrulayin
    //search kutusuna araba yazip arattirin
    //bulunan sonuc sayisini yazdirin
    //sonuc yazisinin "araba" icerdigini dogrulayin
    //Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get("https://www.hepsiburada.com/");
        //Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        SoftAssert softAssert=new SoftAssert();

        //Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        System.out.println(driver.getTitle());
        String expectedResult="Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualResult=driver.getTitle();

        softAssert.assertTrue(actualResult.contains(expectedResult),"Sonuclar uyusmuyor");

        //search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+Keys.ENTER);

        //bulunan sonuc sayisini yazdirin
        WebElement sonuclar=driver.findElement(By.xpath("//*[@id='SearchResultSummary']"));
        System.out.println(sonuclar.getText());

        //sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(sonuclar.getText().contains("araba"),"=========Sonuclar textinde araba kelimesi yok=======");

        //Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(sonuclar.getText().contains("oto"),"Sonuc yazisi oto kelimesi iceriyor");


        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
