package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //Yeni bir class olusturalim: D14_MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim


        WebElement draggableWebElementi=driver.findElement(By.id("draggable"));
        WebElement droppableWebElementi=driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggableWebElementi,droppableWebElementi).perform();
        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        System.out.println(droppableWebElementi.getText());
        Assert.assertEquals(droppableWebElementi.getText(),"Dropped!","Drop yazisi Dropped! yazisina donusmedi");



    }
}
