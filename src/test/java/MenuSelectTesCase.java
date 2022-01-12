import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuSelectTesCase {
    private WebDriver driver;

    private By menu=By.cssSelector( "a[role='button']" );
    private By testCase=By.cssSelector( "a[href='/starc3/Suite']" );

    public MenuSelectTesCase(WebDriver driver) {
        this.driver=driver;
    }

    public void SelectMenu() throws InterruptedException {
        Thread.sleep( 2000 );

        new WebDriverWait(driver, 80).
                until( ExpectedConditions.elementToBeClickable(menu)).click();

        new WebDriverWait(driver, 80).
                until( ExpectedConditions.elementToBeClickable(testCase)).click();

    }
}
