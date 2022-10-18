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

public class Activity3 {

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
    public void noteReminder()  {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();

        //add title
        MobileElement title=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/editable_title\")"));
        title.sendKeys("Appium session");
        //add descripton
        MobileElement description= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")"));
        description.sendKeys("complete all Activitis") ;

        //reminder
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/menu_switch_to_list_view\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/menu_switch_to_list_view\")")).click();



        //clicking on pick date and time
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Pick a date & time']")));
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Pick a date & time']")).click();

        //clicking on dropdown

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/time_spinner\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/time_spinner\")")).click();
        //select after noon

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[1][@text='Afternoon']")));
        driver.findElement(MobileBy.xpath("//android.widget.TextView[1][@text='Afternoon']")).click();

        //save
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/save\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/save\")")).click();

        //back
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")));


        //assertion
        String title1 = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_title\")")).getText();
        Assert.assertEquals(title1, "Appium session");
        String desc = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_text_description\")")).getText();
        Assert.assertEquals(desc, "complete all Activitis");
        String rem =  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/reminder_chip_text\")")).getText();
        Assert.assertEquals(rem, "Today, 1:00 PM");



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}