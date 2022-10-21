package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs’");
        driver.findElement(By.linkText("Post a Job")).click();
        driver.findElement(By.xpath("//*[@id=\"create_account_email\"]")).sendKeys("ee@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"job_title\"]")).sendKeys("Automation tester");
        driver.findElement(By.xpath("//*[@id=\"job_location\"]")).sendKeys("Banglore");
        //driver.findElement(By.xpath("//*[@id=\"job_type\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"job_description_ifr\"]")).sendKeys(" Hi this is pooja");
        driver.findElement(By.xpath("//*[@id=\"application\"]")).sendKeys("shree@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"company_name\"]")).sendKeys("IBM");
        driver.findElement(By.xpath("//*[@id=\"company_website\"]")).sendKeys("Google.com");
        driver.findElement(By.xpath("//*[@id=\"company_tagline\"]")).sendKeys("one of the best IT company");
        //WebElement logo = driver.findElement(By.id("company_logo"));
        //logo.click();
        driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click();
        //driver.findElement(By.linkText("Jobs")).click();



    }
}
