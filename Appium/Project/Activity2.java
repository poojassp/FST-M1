package AppGoogleTasksAndKeep;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {

    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void createnote()  {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();

        //add title
        MobileElement title=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/editable_title\")"));
        title.sendKeys("title is State");
        //add descripton

        MobileElement description= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")"));
        description.sendKeys("Karanataka") ;


        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")));


        //assertion
        String title1 = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_title\")")).getText();
        Assert.assertEquals(title1, "title is State");
        String desc = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_text_description\")")).getText();
        Assert.assertEquals(desc, "Karanataka");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}