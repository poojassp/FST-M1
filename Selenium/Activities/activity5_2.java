package activities;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity5_2 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("title of the page is "+driver.getTitle());
        WebElement disp=driver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("the check box is selected" +disp.isSelected());
        disp.click();
        System.out.println("the check box is selected" +disp.isSelected());


        driver.close();
    }

}