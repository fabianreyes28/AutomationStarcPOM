import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuSelectVentas {
    private WebDriver driver;

    private By opcionVentas=By.cssSelector("option[value='923']");
    private By btnOk =By.id( "btnSignIn" );

    public MenuSelectVentas(WebDriver driver) {
        this.driver=driver;
    }

    public void seleccionarLista() throws InterruptedException {
        //click( lista );
        new WebDriverWait(driver, 80).
                until( ExpectedConditions.elementToBeClickable(opcionVentas)).click();
        Thread.sleep( 2000 );
        new WebDriverWait(driver, 80).
                until( ExpectedConditions.elementToBeClickable(btnOk)).click();

    }
}
