package stepDefinitions;

import io.cucumber.messages.types.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    static WebDriver driver = new FirefoxDriver();
   // static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}
