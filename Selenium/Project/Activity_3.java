package liveproject;
//Goal: Print the url of the header image to the console

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_3 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        //System.out.println("Page title is: " + title);

        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img"));
        System.out.println("The url of the header image is " + element.getAttribute("src"));

        driver.close();
    }

}