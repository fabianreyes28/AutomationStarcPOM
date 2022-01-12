import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaSelectRequerimiento {
    private WebDriver driver;

    private By listSelectReq=By.cssSelector( "select[ng-model='sc.selectedRequirement']" );
    private By diebolDIspensador=By.xpath( "//*[@id=\"body\"]/div[1]/div[1]/div[2]/div/table/tbody/tr[3]/td/select/option[2]" );


    public ListaSelectRequerimiento(WebDriver driver) {
    this.driver=driver;
    }

    public void seleccionarRequerimiento() {
        new WebDriverWait( driver, 80 ).
                until( ExpectedConditions.elementToBeClickable( listSelectReq ) );

        new WebDriverWait( driver, 80 ).
                until( ExpectedConditions.elementToBeClickable( diebolDIspensador ) ).click();

    }
}
