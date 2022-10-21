package liveproject;
//Goal: Search for a job and apply for it

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity_6 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        driver.findElement(By.linkText("Jobs")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[7]/a/div[1]/h3"));



        //driver.close();
    }

}
