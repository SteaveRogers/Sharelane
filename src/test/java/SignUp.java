import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp {


    @Test
    public void checkPositiveSignUp() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Timofei");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Borodich");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("test@test.by");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        boolean elementOnPage = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed();
        Assert.assertTrue(elementOnPage);
        driver.quit();
    }
    @Test
    public void checkNegativeSignUp() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Timofei");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Borodich");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("test@test.by");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        String errorMessage = driver.findElement(By.cssSelector(".error_message")).getText();

        Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email was previously used");
        driver.quit();
    }
}
