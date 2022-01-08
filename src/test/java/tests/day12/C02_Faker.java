package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();



        //3. “firstName” giris kutusuna bir isim yazin
        Thread.sleep(2000);

        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        Actions actions=new Actions(driver);
        actions.sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password(8,10)).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("May").sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31))).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1930,2021))).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE)




                .perform();

        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini
        //test edin.
        //13. Sayfayi kapatin
    }
}
