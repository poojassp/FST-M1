package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Activity6_1 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("title of the page is "+driver.getTitle());
        WebElement checkbox=driver.findElement(By.xpath("//input[@class='willDisappear']"));
        WebElement togglebutton=driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        togglebutton.click();

        //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        togglebutton.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));

        driver.close();


    }

}