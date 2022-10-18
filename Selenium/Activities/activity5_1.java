package activities;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity5_1 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("title of the page is "+driver.getTitle());
        boolean disp=driver.findElement(By.xpath("//label[@class='willDisappear']")).isDisplayed();

        System.out.println(disp);
        driver.findElement(By.id("toggleCheckbox")).click();
        boolean disp2=driver.findElement(By.xpath("//label[@class='willDisappear']")).isDisplayed();
        System.out.println(disp2);
        driver.close();
    }

}