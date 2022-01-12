import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IniciarSesionPage {
    private WebDriver driver;

    private By userName = By.id( "txtUser" );
    private By passwordd = By.id( "txtPassword" );
    private By btnLogin = By.id( "btnAuthenticate" );

    public IniciarSesionPage(WebDriver driver) {
        this.driver=driver;
    }

    public void iniciarSesion() throws InterruptedException {

        driver.findElement( userName ).sendKeys( "freyes" );
        driver.findElement( passwordd ).sendKeys( "Hdicolombia2021*++" );
        driver.findElement( btnLogin ).click();
    }
}
