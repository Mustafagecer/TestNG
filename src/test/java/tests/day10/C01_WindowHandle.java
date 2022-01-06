package tests.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

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

            //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            //SwitchTo() ile window degistireceksek gidecegimiz windowun windowhandle degerine ihtiyacimiz var

            softAssert.assertEquals(driver.getTitle(),"The Internet","Gercekle beklenen sonuc uyusmuyor2");


            System.out.println("===========1. sayfanin Handle degeri========"+driver.getWindowHandle());

            String ilkSayfaninHandleDegeri=driver.getWindowHandle();
            //● Click Here butonuna basın.
            driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();

            Set<String> tumSayfalarinHanleDegerleri=driver.getWindowHandles();
            String ikinciSayfaHandleDegeri="";
            for (String each:tumSayfalarinHanleDegerleri
                 ) {
                if (!each.equals(ilkSayfaninHandleDegeri)){
                    ikinciSayfaHandleDegeri=each;
                }
                
            }

            System.out.println("===========2. sayfanin Handle degeri========"+ikinciSayfaHandleDegeri);
            driver.switchTo().window(ikinciSayfaHandleDegeri);

            //● Sayfadaki textin “New Window” olduğunu doğrulayın.

            System.out.println("Ikinci sayfa Basligi=============>"+driver.getTitle());
            softAssert.assertEquals(driver.getTitle(),"New Window");

            //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
            //driver.navigate().back(); ile bir onceki sayfaya donemeyiz, cunku acilan yeni sayfada back butonu aktif degil.
            //Ama Handle degeriyle geri gidebiliriz

            System.out.println("Ilk sayfaya geri dondu ve baslik soyle oldu: "+driver.switchTo().window(ilkSayfaninHandleDegeri).getTitle());

            String birinciSayfaninBasligi=driver.switchTo().window(ilkSayfaninHandleDegeri).getTitle();
            softAssert.assertEquals(birinciSayfaninBasligi,"The Internet","Birinci sayafanin basligi The Internet degil");

            softAssert.assertAll();
        }


    }
