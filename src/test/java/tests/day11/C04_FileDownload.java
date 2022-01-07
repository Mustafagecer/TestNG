package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void downloadTest(){

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[@href='download/upload.txt']")).click();
    }
    @Test
    public void isExist(){
        String pathAutomatic=System.getProperty("user.name")+"\\Downloads\\upload.txt";


        Assert.assertTrue(Files.exists(Paths.get(pathAutomatic)),"Pathler uyusmuyor");
    }
}
