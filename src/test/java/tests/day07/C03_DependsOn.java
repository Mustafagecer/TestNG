package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03_DependsOn {
    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //	1. Test : Amazon ana sayfaya gittiginizi test edin
    //	2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
    //	3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin


    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    //	1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void amazonCheck(){
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }

    //	2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin

    @Test (dependsOnMethods = "amazonCheck")
    public void nutella() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        Thread.sleep(3000);
        WebElement sonuclar=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonuclar.getText());

        Assert.assertTrue(sonuclar.getText().contains("nutella"));

    }
    @Test //(dependsOnMethods = "nutella")


     // eger 3 test veya daha fazlasi birbirine dependsOn ile baglandiysa
    // 3.yu calistirmak istedigimizde zincir reaksiyon calisip 1.ye GITMEZ
    public void urunFiyati() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();
        Thread.sleep(2000);
        WebElement urunFiyat= driver.findElement(By.xpath("(//*[@class='a-text-left a-size-base'])[2]"));

        System.out.println("Fiyat================>"+urunFiyat.getText());
        Assert.assertEquals(urunFiyat.getText(),"33.5 Ounce");
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
