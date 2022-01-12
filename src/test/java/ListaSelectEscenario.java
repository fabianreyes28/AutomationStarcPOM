import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.util.List;

public class ListaSelectEscenario {
    private WebDriver driver;


    //private By listScenario=By.cssSelector( "select[ng-model='sc.selectedScenario']" );
    private By listScenario=By.xpath( "//select[@ng-model='sc.selectedScenario']" );

    private By crediAgil=By.xpath( "//*[@id=\"body\"]/div[1]/div[1]/div[2]/div/table/tbody/tr[5]/td/select/option[2]" );

    public ListaSelectEscenario(WebDriver driver) {
        this.driver=driver;
    }


    public void seleccionarScenario() throws IOException, InterruptedException {
        new WebDriverWait(driver, 80).until( ExpectedConditions.elementToBeClickable(listScenario));
        new WebDriverWait(driver, 80).until(ExpectedConditions.elementToBeClickable(crediAgil)).click();

       /* Select seleccionar=new Select( driver.findElement(listScenario) );
        List<WebElement> listaCompleta= seleccionar.getOptions();
        System.out.println(listaCompleta.size());
        System.out.println(listaCompleta.get( posi ).getText());

        */


    }
}
