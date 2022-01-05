package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        System.out.println(driver.getTitle());
    }
}
