import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SongsPageTest {

    private WebDriver driver;
    private SongsPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new SongsPage(driver);
        driver.get("https://yousician.com/songs");
    }

    @Test
    public void searchTest() {
        page.search("song");
        Assertions.assertThat(new SearchResultsPage(driver).getSearchResultHeaderText()).isEqualTo("SEARCH RESULTS FOR “SONG”");
        Assertions.assertThat(new SearchResultsPage(driver).getFoundSongs().size()).isGreaterThan(1);
    }

    @Test
    public void startNowTest() {
        page.startNow();
        Assert.assertTrue(new SignupPage(driver).isSignupPage());
    }

    @Test
    public void downloadYousicianTest() {
        String expectedUrl = "https://app.yousician.com/account/profile#/download?pid=yousician-songs&af_sub1=home_page&af_ad=link_download_yousician_position_footer";
        page.downloadYousician();
        Assertions.assertThat(expectedUrl).isEqualTo(driver.getCurrentUrl());
    }

    @Test
    public void downloadOnAppStoreTest() {
        String expectedUrl = "https://itunes.apple.com/us/app/yousician/id959883039?pid=yousician-songs&af_sub1=home_page&af_ad=button_download_from_app_store_position_footer";
        page.downloadOnAppStore();
        Assertions.assertThat(expectedUrl).isEqualTo(driver.getCurrentUrl());
    }

    @Test
    public void downloadOnGooglePlayTest() {
        String expectedUrl = "https://play.google.com/store/apps/details?id=com.yousician.yousician&pid=yousician-songs&af_sub1=home_page&af_ad=button_download_from_google_play_position_footer";
        page.downloadOnGooglePlay();
        Assertions.assertThat(expectedUrl).isEqualTo(driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
