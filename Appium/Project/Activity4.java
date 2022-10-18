package AppGooogleChrome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4  {

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
    public void todolisttest() throws InterruptedException  {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.training-support.net/selenium");
        //cicking on get started button
        driver.findElement(MobileBy.xpath("//android.widget.Button[2][@text='Get Started!']")).click();

        //scroll and clicking on todo list
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).	flingForward().scrollIntoView(textContains(\"To-Do List\"))")).click();

        WebElement todolist=  driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.EditText[@class='android.widget.EditText']");
        todolist.click();

        todolist.sendKeys("Add tasks to list");
        WebElement addtask=driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button"));
        addtask.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View[@text='Add tasks to list']")));



        //2nd list
        todolist.click();
        todolist.sendKeys("Get number of tasks");
        addtask.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View[@text='Get number of tasks']")));





//3rd list
        todolist.click();
        todolist.sendKeys("Clear the list");
        addtask.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View[@text='Clear the list']")));



        //clicking on each tasks to strike them out
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[1]/android.view.View[@text='Add more tasks to this list.']").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View[@text='Add tasks to list']")));

        WebElement firsttask=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View[@text='Add tasks to list']");
        firsttask.click();



        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View[@text='Get number of tasks']")));
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View[@text='Get number of tasks']").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View[@text='Clear the list']")));
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View[@text='Clear the list']").click();

        //clicking on clear button
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3][@class='android.view.View']")));
        driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3][@class='android.view.View']").click();





// Assert.assertNull(firsttask);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
