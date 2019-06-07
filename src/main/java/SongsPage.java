import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SongsPage {

    private WebDriver driver;

    public SongsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SEARCH_FIELD = By.cssSelector("input[class^='SearchInput']");
    private By SEARCH_SUBMIT_BUTTON = By.cssSelector("button.submitBtn");
    private By START_NOW_BUTTTON = By.xpath("//a[text()='Start now']");
    private By DOWNLOAD_YOUSICIAN_BUTTON = By.xpath("//a[text()='Download Yousician']");
    private By DOWNLOAD_ON_GOOGLE_PLAY_BUTTON = By.xpath("//a[contains(@href, 'google_play')]");
    private By DOWNLOAD_ON_APP_STORE_BUTTON = By.xpath("//a[contains(@href, 'apple')]");

    public void search(String query) {
        driver.findElement(SEARCH_FIELD).sendKeys(query);
        driver.findElement(SEARCH_SUBMIT_BUTTON).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^='Search__Container']")));
    }

    public void startNow() {
        new DriverHelper(driver).switchToNewTab(() -> driver.findElement(START_NOW_BUTTTON).click());
    }

    public void downloadYousician() {
        WebElement button = driver.findElement(DOWNLOAD_YOUSICIAN_BUTTON);
        new DriverHelper(driver).scrollTo(button);
        button.click();
    }

    public void downloadOnGooglePlay() {
        WebElement button = driver.findElement(DOWNLOAD_ON_GOOGLE_PLAY_BUTTON);
        new DriverHelper(driver).scrollTo(button);
        new DriverHelper(driver).switchToNewTab(() -> button.click());
    }

    public void downloadOnAppStore() {
        WebElement button = driver.findElement(DOWNLOAD_ON_APP_STORE_BUTTON);
        new DriverHelper(driver).scrollTo(button);
        new DriverHelper(driver).switchToNewTab(() -> button.click());
    }
}
