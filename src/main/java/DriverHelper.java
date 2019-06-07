import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.Set;

public class DriverHelper {

    private WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab(Runnable newTabAction) {
        Set<String> windowHandlesBefore = driver.getWindowHandles();
        newTabAction.run();
        new WebDriverWait(driver, 5).until(
                new ExpectedCondition<Boolean>() {
                    @Nullable
                    @Override
                    public Boolean apply(@Nullable WebDriver input) {
                        try {
                            return driver.getWindowHandles().size() > 1;
                        } catch (WebDriverException ignored) {
                            return false;
                        }
                    }
                });
        Set<String> windowHandlesAfter = driver.getWindowHandles();
        windowHandlesAfter.removeAll(windowHandlesBefore);
        driver.switchTo().window(windowHandlesAfter.iterator().next());
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
