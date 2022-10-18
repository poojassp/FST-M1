package activities;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity5_3 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("title of the page is "+driver.getTitle());
        WebElement textinput=driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("the text filed is enambled "+textinput.isEnabled());

        WebElement enableinput=driver.findElement(By.xpath("//button[@id='toggleInput']"));
        enableinput.click();
        System.out.println("the text filed is enambled "+enableinput.isEnabled());

        driver.close();


    }

}