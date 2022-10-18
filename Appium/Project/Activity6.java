package AppGooogleChrome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {

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
    public void correctsigninpopups() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.training-support.net/selenium");


        //cicking on get started button
        driver.findElement(MobileBy.xpath("//android.widget.Button[2][@text='Get Started!']")).click();



        //scroll and clicking on login
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();

        //clicking on signin
        driver.findElementByXPath("//android.view.View[1]/android.view.View[4]/android.widget.Button").click();

        //enter username
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
        //enter password
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
        //click on login
        driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.Button[@text='Log in']").click();

        System.out.println (driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText());
        Assert.assertEquals(driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText(), "Welcome Back, admin");


    }
    @Test
    public void incorrectsigninpopups() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.training-support.net/selenium");


        //cicking on get started button
        driver.findElement(MobileBy.xpath("//android.widget.Button[2][@text='Get Started!']")).click();



        //scroll and clicking on login
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();


        //clicking on signin
        driver.findElementByXPath("//android.view.View[1]/android.view.View[4]/android.widget.Button").click();

        //enter username
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("anusha");
        //enter password
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("abcxyz");
        //click on login
        driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View/android.widget.Button[@text='Log in']").click();

        System.out.println (driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText());
        Assert.assertEquals(driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText(), "Invalid Credentials");


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}