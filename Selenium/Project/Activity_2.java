package liveproject;
//Goal: Read the heading of the website and verify the text


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        String heading = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/h1")).getText();
        System.out.println("Page heading is: " + heading);

        Assert.assertEquals(heading,"Welcome to Alchemy Jobs");

        driver.close();
    }

}