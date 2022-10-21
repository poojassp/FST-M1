package liveproject;
//Goal: Read the title of the website and verify the text


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_1 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Alchemy Jobs – Job Board Application",title);
        driver.close();
    }

}
