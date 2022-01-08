package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Practice_demoqa_Elements extends TestBase {

    @Test
    public void textBox(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.xpath("(//*[@class=' mr-sm-2 form-control'])[1]")).sendKeys("Ali");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("aliveli@dsfdfsf.com")
                .sendKeys(Keys.TAB).sendKeys("sokak cadde")
                .sendKeys(Keys.TAB).sendKeys("Sehir Ulke")
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
    @Test
    public void webTables() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Ali")
                .sendKeys(Keys.TAB).sendKeys("Veli")
                .sendKeys(Keys.TAB).sendKeys("kirdokuzelli@example.com")
                .sendKeys(Keys.TAB).sendKeys("15")
                .sendKeys(Keys.TAB).sendKeys("1200")
                .sendKeys(Keys.TAB).sendKeys("Accountcy")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        Thread.sleep(5000);

        WebElement eklenenKisi=driver.findElement(By.xpath("(//div[@class='rt-tr -even'])[2]"));
        System.out.println(eklenenKisi.getText());

        Assert.assertTrue(eklenenKisi.getText().contains("1200"),"Eklenen kisinin maasi bulunamadi");

    }

    @Test
    public void radioButton(){
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.id("yesRadio")).click();




        }


    @Test
    public void signIn() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        signInButton.click();
        WebElement email =  driver.findElement(By.xpath("//input[@id='email_create']"));
        email.sendKeys("h.musti.27@gmail.com");
        WebElement createAccount = driver.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccount.click();
        driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).isDisplayed();
        WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        femaleRadioButton.click();
        Actions actions=new Actions(driver);

        actions.sendKeys(Keys.TAB).sendKeys("Mustafa")
                .sendKeys(Keys.TAB).sendKeys("Gecer")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("aliveli").sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN).sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN).sendKeys(Keys.TAB)
                .sendKeys("1989"+Keys.ENTER).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("TechPro").sendKeys(Keys.TAB)
                .sendKeys("Street Aveneu").sendKeys(Keys.TAB)
                .sendKeys("Street Aveneu").sendKeys(Keys.TAB)
                .sendKeys("New York").sendKeys(Keys.TAB)
                .sendKeys("New York").sendKeys(Keys.TAB)
                .sendKeys("36589").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("I'am testing you... :)").sendKeys(Keys.TAB)
                .sendKeys("+1 (917) 768-7466").sendKeys(Keys.TAB)
                .sendKeys("+1 (917) 768-7466").sendKeys(Keys.TAB)
                .sendKeys("Street Aveneu").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)


                .perform();



        Thread.sleep(5000);
    }
}
