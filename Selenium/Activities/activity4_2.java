package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4_2 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println("title of the page is "+driver.getTitle());
        WebElement firstname=  driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastname=  driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement Email=  driver.findElement(By.xpath("//input[@id='email']"));
        WebElement Contactnum=  driver.findElement(By.xpath("//input[@id='number']"));
        firstname.sendKeys("POOJA");
        lastname.sendKeys("SP");
        Email.sendKeys("pooja@gmail.com");
        Contactnum.sendKeys("7869577987");

        //driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.findElement(By.xpath("//input[@class='ui green button']")).click();

        driver.close();
    }

}
