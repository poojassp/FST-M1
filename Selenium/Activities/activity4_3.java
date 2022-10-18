package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4_3 {

    public static void main(String[] args) {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("title of the page is "+driver.getTitle());
        String thiredheader=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header text is " +thiredheader);

        String fifthHcolor = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("fifth header color is " +fifthHcolor);

        String violetbuttoncls = driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class");
        System.out.println("violet button classs are " +violetbuttoncls);

        String gerybutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("The grey button's text is: " + gerybutton);

        driver.close();


    }

}
