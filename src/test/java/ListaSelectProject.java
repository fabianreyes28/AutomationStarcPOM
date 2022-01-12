import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaSelectProject {
    private WebDriver driver;

    private By listproject=By.cssSelector( "select[ng-model='sc.selectedSystem']" );
    private By project=By.xpath( "//*[@id=\"cboSystem\"]/option[2]" );


    public ListaSelectProject(WebDriver driver) {
        this.driver=driver;

    }

    public void selectProject() {
        new WebDriverWait(driver, 80).
                until( ExpectedConditions.elementToBeClickable(listproject));

        new WebDriverWait(driver, 80).
                until(ExpectedConditions.elementToBeClickable(project)).click();



    }
}
