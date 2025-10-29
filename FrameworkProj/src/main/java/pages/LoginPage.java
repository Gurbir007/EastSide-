package pages;


import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailField = By.id("email-login");
    By passwordField = By.id("-password-login");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);
    }
}