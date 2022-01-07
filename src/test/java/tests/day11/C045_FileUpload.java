package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C045_FileUpload extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim

        //Yuklemek istediginiz dosyayi secelim.
        String pathOfFile="C:\\Users\\Acer\\Desktop\\1.JPG";

        WebElement chooseFileButonu=driver.findElement(By.id("file-upload"));
        chooseFileButonu.sendKeys(pathOfFile);

        Thread.sleep(2000);
        WebElement uploadButonu=driver.findElement(By.id("file-submit"));
        uploadButonu.click();
        Thread.sleep(2000);

        WebElement theTextOfFileUploaded=driver.findElement(By.tagName("h3"));


        Assert.assertEquals(theTextOfFileUploaded.getText(),"File Uploaded!","dosya yuklenemedi");


    }
}
