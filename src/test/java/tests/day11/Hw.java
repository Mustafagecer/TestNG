package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Hw extends TestBase {

    @Test
    public void homeWork() throws InterruptedException {


    //Yeni Class olusturun ActionsClassHomeWork
    // 1- "http.//webdriveruniversity.com/Actions"sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
    // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement firstHover=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(firstHover).click().perform();
        Thread.sleep(1000);


    // 3- Link 1" e tiklayin
        WebElement link1=driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.click(link1).perform();

    // 4- Popup mesajini yazdirin
        System.out.println("Pop mesaji=========>"+driver.switchTo().alert().getText());
        // 5- Popupti tamam diyerek kapatin
        driver.switchTo().alert().accept();
    // 6- "Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        Thread.sleep(3000);
    // 7-"Click and hold" kutusunda cikan yazıyı' yazdirin
        System.out.println(clickAndHold.getText());
    // 8- "Double click me" butonunu cilt tiklayin
        WebElement doubleClick=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();

    }
}
