package activities;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
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

public class Activity6 {
    //AndroidDriver <MobileElement> driver;
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

        wait = new WebDriverWait(driver, 10);

    }
    @Test
    public void test()  {
        driver.get("https://www.training-support.net/selenium/lazy-loading");


        // Count the number of images shown on the screen
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath("//android.view.View/android.view.View/android.widget.Image")));



        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        // Assertion before scrolling
        Assert.assertEquals(numberOfImages.size(), 2);

        // Scroll to Helen's post
        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"helen\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"helen\"))"));

        //   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath("//android.view.View/android.view.View/android.widget.Image")));
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());



        // Assertion after scrolling
        Assert.assertEquals(numberOfImages.size(),2 );
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}