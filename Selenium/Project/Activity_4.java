package liveproject;
//Goal: Read the second heading of the website and verify the text

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_4 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        String element = driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2")).getText();
        System.out.println("The  second header is " + element);

        Assert.assertEquals(element,"Quia quis non");


        driver.close();
    }

}