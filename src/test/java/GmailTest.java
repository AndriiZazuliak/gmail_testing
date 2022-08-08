import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class GmailTest {
    private static final String HOME_URL = "https://www.google.com/";

    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //open home page
        driver.get(HOME_URL);
        //open email account
        WebElement elementEnter = driver.findElement(By.xpath("//a[contains(@href,'accounts.google.com')]"));
        elementEnter.click();

        // input email
        WebElement enterEmail = driver.findElement(By.xpath("//input[@type='email']"));
        enterEmail.sendKeys("tester.aqa@gmail.com", Keys.ENTER);

        // input password
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        WebElement enterPassword = driver.findElement(By.cssSelector("input[type='password']"));
        enterPassword.sendKeys("aqa+test", Keys.ENTER);

        // open gmail page
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'mail')][@class='gb_d']")));
        WebElement openEmail = driver.findElement(By.xpath("//a[contains(@href,'mail')][@class='gb_d']"));
        openEmail.click();

        // create mail form
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='z0']/div[@role='button']")));
        WebElement createMailForm = driver.findElement(By.xpath("//div[@class='z0']/div[@role='button']"));
        createMailForm.click();

        // wait the mail form appears
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Message']")));
        // fill recipients
        driver.findElement(By.name("to")).sendKeys("andrijzaz@gmail.com");
        // fill topic
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Very important mail");

        // fill message
        WebElement messageElement = driver.findElement(By.className("editable"));
        messageElement.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        // send mail
        driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));

        // close driver
        driver.quit();
    }
}
