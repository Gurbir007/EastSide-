package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssueReport {

    WebDriver driver;
    WebDriverWait wait;

    public IssueReport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//a[@role='button'][.//h6[normalize-space(.)='Reports']]")
    WebElement reportMenu;

    @FindBy(xpath = "//div[@role='button'][.//span[contains(text(), 'Enter / Insert Report Data')]]")
    WebElement enterReport;

    @FindBy(xpath = "//div[@role='button'][.//span[normalize-space(.)='Issue Report']]")
    WebElement issueReportBtn;

    @FindBy(name = "dateOfComplaint")
    WebElement dateOfComplaint;

    @FindBy(name = "dateOfJob")
    WebElement dateOfJob;

    @FindBy(name = "quoteNumber")
    WebElement quoteNumber;

    @FindBy(name = "estimator")
    WebElement estimator;

	@FindBy(id = "mui-component-select-fencers")
    WebElement fencerDropdown;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "suburb")
    WebElement suburb;

    @FindBy(name = "contact")
    WebElement contact;

    @FindBy(id = "mui-component-select-fencerType")
    WebElement fencerTypeDropdown;

    @FindBy(name = "metres")
    WebElement metres;

    @FindBy(xpath = "//textarea[@name='issue']")
    WebElement issue;

    @FindBy(name = "issueRef")
    WebElement issueRef;

    @FindBy(xpath = "//textarea[@name='solution']")
    WebElement solution;

    @FindBy(name = "extraPayToFencer")
    WebElement extraPayToFencer;

    @FindBy(name = "assignedTo")
    WebElement assignedTo;

    @FindBy(id = "mui-component-select-status")
    WebElement statusDropdown;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;

    By dropdownOptions = By.xpath("//ul[@role='listbox']/li");

    public void enterIssueReport(String doc, String doj, String qn, String esti, String addr,
                                 String sub, String con, String met, String is,
                                 String ref, String sol, String ext, String ass) {

        smoothClick(reportMenu);
        smoothClick(enterReport);
        smoothClick(issueReportBtn);

        enterDate(dateOfComplaint, doc);
        enterDate(dateOfJob, doj);

        smoothType(quoteNumber, qn);
        smoothType(estimator, esti);
        			
        smoothType(address, addr);
        smoothType(suburb, sub);
        smoothType(contact, con);

        selectDropdown(fencerTypeDropdown, 1);

        smoothType(metres, met);
        smoothType(issue, is);
        smoothType(issueRef, ref);
        smoothType(solution, sol);
        smoothType(extraPayToFencer, ext);
        smoothType(assignedTo, ass);

        selectDropdown(statusDropdown, 1);

        smoothClick(saveBtn);
        pause(1000);
    }

    private void smoothClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        pause(300);
    }

    private void smoothType(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        typeSlow(element, text);
        pause(300);
    }

    private void typeSlow(WebElement element, String text) {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            pause(60);
        }
    }

    private void enterDate(WebElement element, String date) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
        pause(300);
    }

    private void selectDropdown(WebElement dropdown, int index) {
        smoothClick(dropdown);
        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownOptions));
        options.get(index).click();
        pause(300);
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
