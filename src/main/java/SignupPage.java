import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SIGNUP_FORM = By.cssSelector(".signup-form-container");

    public boolean isSignupPage() {
        return driver.findElements(SIGNUP_FORM).size() > 0;
    }
}
