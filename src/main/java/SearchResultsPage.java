import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SEARCH_RESULTS_HEADER = By.xpath("//h4");
    private By FOUND_SONG_LINK = By.xpath("//a[contains(@class, 'TableHead')]");

    public String getSearchResultHeaderText() {
        return driver.findElement(SEARCH_RESULTS_HEADER).getText();
    }

    public List<WebElement> getFoundSongs() {
        return driver.findElements(FOUND_SONG_LINK);
    }
}
