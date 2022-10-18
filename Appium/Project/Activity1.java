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

public class Activity1 {

    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);


    }
    @Test(priority=1)
    public void addfirsttask() {
        //click on add task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
        //entering  first task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")));
        MobileElement firsttask= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")"));
        firsttask.sendKeys("Complete Activity with Google Tasks");
        //save
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();

        //assert
        String firsttaskText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")")).getText();
        Assert.assertEquals(firsttaskText, "Complete Activity with Google Tasks");


    }

    @Test(priority=2)
    public void addsecondtask() {
        //click on add task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
        //entering  first task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")));
        MobileElement secondtask= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")"));
        secondtask.sendKeys("Complete Activity with Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();


        //assert
        String secoondtaskText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")")).getText();
        Assert.assertEquals(secoondtaskText, "Complete Activity with Google Keep");

    }




    @Test(priority=3)
    public void addthirdtask() {
        //click on add task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
        //entering  first task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")));
        MobileElement thirdtask= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")"));
        thirdtask.sendKeys("Complete the second Activity Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
        //assert
        String thirdtaskText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")")).getText();
        Assert.assertEquals(thirdtaskText, "Complete the second Activity Google Keep");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
