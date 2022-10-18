package activities;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    public void test() {
        WebElement UN=  driver.findElement(By.id("username"));
        UN.sendKeys("admin");
        WebElement Password=driver.findElement(By.id("password"));
        Password.sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String confrm=driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(confrm);
        Assert.assertEquals("Welcome Back, admin", confrm);

    }


    @AfterClass
    public void afterClass() {
        driver.close();

    }

}