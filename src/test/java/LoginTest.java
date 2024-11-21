import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void checkLogin(){
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        boolean elementOnPage = driver.findElement(By.cssSelector("[value='Register']")).isDisplayed();

        driver.findElement(By.name("first_name")).sendKeys("Lex");
        driver.findElement(By.name("last_name")).sendKeys("Lutor");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        boolean successElement = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed();

        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"))
                .getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a/img"))
                .click();
        boolean check = driver.findElement(By.cssSelector("[value='Login']")).isDisplayed();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value='Login']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://sharelane.com/cgi-bin/main.py", "URL после логина не совпадает!");


    }
    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
