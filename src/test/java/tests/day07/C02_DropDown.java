package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    //Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //dropdown i locate et
        WebElement dropDown=driver.findElement(By.id(("dropdown")));


        //Select classini kullanarak bir obje olustur
        //parametre olarak locate etttigimiz webelementi yaz

        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        Select select=new Select(dropDown);
        //istedigin option i select objesi kullaanarak sec
        select.selectByIndex(1);
        System.out.println("Birinci secenek secildi: "+select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("ikinci eleman secildi: "+select.getFirstSelectedOption().getText());

    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText() );

        //getFirstSelectedOption methodu en son yazilan elemani getirir
        select.selectByVisibleText("Option 1");
        select.selectByVisibleText("Option 2");
        System.out.println("Option 2 gelirse dogru------------>"+select.getFirstSelectedOption().getText());

        //	4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> allOption= select.getOptions();

        System.out.println("Tüm secenekler listesi");
        for (WebElement each:allOption
        ) {
            System.out.println(each.getText());
        }
        //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println(allOption.size());
        if (allOption.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        }









    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
