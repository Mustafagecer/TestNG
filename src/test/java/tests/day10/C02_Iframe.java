package tests.day10;

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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C02_Iframe {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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

        driver.switchTo().frame(0);
        WebElement textArea=driver.findElement(By.xpath("//*[@id='tinymce']"));
        //Yukaridaki Webelemnt baska bir siteden alindigi icin direkt olarak xpath gibi locatarlarla bulunamaz
        //Onun icin switchTo().framei kullaniriz
        //frame methodu index methoduylacok hizli bulablir
        textArea.clear();
        textArea.sendKeys("Merhaba");
        Thread.sleep(2000);

        //Biraz once textArea yi bulmak icin switchTo() methoduyla baska bir sayfaya gectik.
        //Tekrar bu sayfada birseyler yapmak istiyorsak tekrar geri donmeliyiz

        driver.switchTo().defaultContent();

        //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //		dogrulayin ve  konsolda yazdirin.
        WebElement isnenWebElementi=driver.findElement(By.linkText("Elemental Selenium"));

        System.out.println(isnenWebElementi.getText());
        //Dogrulama SoftAssertion ile yapilir
        SoftAssert softAssert=new SoftAssert();


        softAssert.assertTrue(isnenWebElementi.isDisplayed(),"istenen webelementine ulasilamiyor");


        softAssert.assertAll();



    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
