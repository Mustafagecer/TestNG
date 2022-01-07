package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class practice_demoqa_forms extends TestBase {
    @Test
    public void formTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Ali");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("Veli")
                .sendKeys(Keys.TAB).sendKeys("aliveli@example.com")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys("015906724650")
                .sendKeys(Keys.TAB).sendKeys("01 Jan 1989"+Keys.ENTER)
                .sendKeys(Keys.ESCAPE)
                .sendKeys(Keys.TAB).sendKeys("Maths"+Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();

        WebElement chooseFile=driver.findElement(By.id("uploadPicture"));
        String pathOfFile="C:\\Users\\Acer\\Desktop\\1.JPG";

        chooseFile.sendKeys(pathOfFile);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Sokak cadde Sehir");
                actions.sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
               /* .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .sendKeys("C:\\Users\\Acer\\Desktop\\1.JPG").click()
                .sendKeys(Keys.TAB).sendKeys("Ali Veli")
                .sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER)



                 */

    }

}
