package QuaraTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuaraMain {

    private static final Logger logger = LoggerFactory.getLogger(QuaraMain.class);
    public static WebDriver driver;
    public static Properties prop = new Properties();

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            logger.error("Failed to load properties file", e);
        }

        String browserName = prop.getProperty("browser");
        String website = prop.getProperty("website");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        // Launching the web browser
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Enter correct browser!");
            return;
        }

        try {
            driver.get(website);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='q-box qu-flex--auto']/following::button")));
            loginButton.click();

            // Click on the Login option
            WebElement loginOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Login']")));
            loginOption.click();

            // Enter login credentials
            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
            login.sendKeys(email);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
            passwordField.sendKeys(password);

            // Click on the submit button
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Login')]")));
            submitButton.click();

            WebElement searchBox = wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Quora']"))));
            searchBox.sendKeys("Testing");

            WebElement testClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='q-text qu-color--gray_light']")));
            testClick.click();

            WebElement resultCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='q-box qu-borderBottom qu-pt--small qu-pb--small qu-bg--raised']//div[@class='q-text qu-dynamicFontSize--regular qu-medium qu-color--gray_dark qu-passColorToLinks']")));
            System.out.print("Verifying the Displayed: " + resultCheck.getText());

            WebElement profileClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='q-box qu-borderRadius--circle qu-borderAll qu-borderColor--darken']")));
            profileClick.click();

            WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Logout')]")));
            logout.click();

            WebElement signEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign up with email')]")));
            signEmail.click();

            WebElement enterUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='profile-name']")));
            enterUserName.sendKeys("iamTHOR2");

            WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='q-box qu-px--medium qu-pt--small qu-pb--medium']//input[@id='email']")));
            enterEmail.sendKeys("abc@abc");

            WebElement show = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='q-text qu-dynamicFontSize--small qu-color--red_error']")));

            WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Next')]")));

            if (show.isDisplayed() != false) {
                TakesScreenshot ts = ((TakesScreenshot) driver);

                File file = ts.getScreenshotAs(OutputType.FILE);

                File saveFile = new File("C:\\Users\\2319695\\OneDrive - Cognizant\\Desktop\\image1.jpg");

                FileHandler.copy(file, saveFile);
            } else {
                next.click();
            }

        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}