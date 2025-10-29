package pages;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {
    WebDriver driver;
    WebDriverWait wait;

    By clinet = By.xpath("//a[@href='/clients']");
    By Addclient = By.xpath("//button[normalize-space()='Add New Client']");

    By Fullname = By.id("name");
    By Email = By.id("email");
    By BillingAddres = By.name("billingAddress");
    By Phone = By.id("phone");

    By Name = By.id("secondaryContacts.0.name");
    By SecEMail = By.id("secondaryContacts.0.email");
    By SecondaryAddres = By.name("secondaryContacts.0.address");
    By SecondaryPhone = By.id("secondaryContacts.0.phone");

    By Tittle = By.id("jobAddresses.0.title");
    By JobAddress = By.name("jobAddresses.0.address");
    By Save = By.xpath("//button[text() = 'Save']");

    public Client(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openClientForm() {
        wait.until(ExpectedConditions.elementToBeClickable(clinet)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Addclient)).click();
    }

    public void AddNewClient(String name, String email, String billingaddres, String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Fullname)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(email);

        WebElement billingField = wait.until(ExpectedConditions.elementToBeClickable(BillingAddres));
        billingField.click();
        billingField.sendKeys(billingaddres);

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
        );
        options.get(3).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Phone)).sendKeys(number);
    }

    public void SecondarAddres(String name2, String email2, String address2, String nuber2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SecEMail)).sendKeys(email2);

        WebElement secAddress = wait.until(ExpectedConditions.elementToBeClickable(SecondaryAddres));
        secAddress.click();
        secAddress.sendKeys(address2);

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
        );
        options.get(3).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(SecondaryPhone)).sendKeys(nuber2);
    }

    public void Jobdetail(String tille, String jobaddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Tittle)).sendKeys(tille);

        WebElement jobAddr = wait.until(ExpectedConditions.elementToBeClickable(JobAddress));
        jobAddr.click();
        jobAddr.sendKeys(jobaddress);

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
        );
        options.get(3).click();

        wait.until(ExpectedConditions.elementToBeClickable(Save)).click();
    }
}


