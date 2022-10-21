package liveproject;
//Goal: Navigate to the “Jobs” page on the site.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity_5 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

       driver.findElement(By.linkText("Jobs")).click();
       String title = driver.getTitle();
       System.out.println(title);
       // WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).


       driver.close();
    }

}
