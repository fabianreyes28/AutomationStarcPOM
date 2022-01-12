import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListCasos {
    private WebDriver driver;
    private LeerExcel leerExcel=new LeerExcel();


    private By tresPuntosInsertarTarjeta = By.xpath( "/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/accordion/div/ng-form/div/div[2]/div/div/div[3]/div[2]/ul/li[5]/span" );
    private By testValues = By.cssSelector( "a[ng-click='openTestValues()']" );
    //private By cajita2 = By.xpath( "/html/body/div[1]/div[2]/hot-table/div/div[1]/div/div/div/table/tbody/tr/td[2]" );
    private By cajita2 = By.xpath(  "//tbody/tr/td[contains(text(),'#GET_MENSAJE')]" );
    private By texarea_cajita2 = By.xpath(  "//textarea[@class='handsontableInput']" );
    //textarea[@class='handsontableInput']
    //private By cajita22 = By.cssSelector( "#ht_26ac8e6232251794 > div.ht_master.handsontable.innerBorderLeft > div > div > div > table > tbody > tr > td.current" );
    private By listDeCasos = By.cssSelector( "select[ng-model='sc.selectedSuite']" );

    private By btnSalvar = By.cssSelector( "button[ng-click='sc.saveValues()']" );

    public static int fila = 2;

    public ListCasos(WebDriver driver) {
        this.driver = driver;
    }

    public void recorriendoCasos() throws InterruptedException, IOException {

        new WebDriverWait( driver, 80 ).until( ExpectedConditions.elementToBeClickable( listDeCasos ) );

        Select seleccionar = new Select( driver.findElement( listDeCasos ) );
        Thread.sleep( 1000 );
        List<WebElement> llistaCompleta = seleccionar.getOptions();
        //System.out.println( llistaCompleta.size() );
        //System.out.println( llistaCompleta.get( 2 ).getText().length() );
        //System.out.println( llistaCompleta.get( 2 ).getText() );
       /*
        for (int i = 1; i < llistaCompleta.size();i++) {
            System.out.println( "Casos-->"+llistaCompleta.get( i ).getText() );
        }

        */

        for (int i = 1; i < llistaCompleta.size(); i++) {

        //--------leyendo el EXCEL----------//


            //Aquí poner la dirección del archivo excel de su computadora
            //o también pueden incluirlo como parte del proyecto, la ruta sería como la que usamos para el chromedriver.exe (ver en el método setUp arriba)
            String filepath = "C:\\Users\\hdi\\Desktop\\CURSOS\\Quality-Stream\\Casos Satarc POM\\" +
                    "src\\test\\resources\\Excel\\Control_Casos_Ventas.xlsx";

            //String searchText = leerExcel.getCellValue( filepath,"NCR-VENTAS",3,11 );
            //System.out.println( "leyendo excel: " + searchText );
            int f=2;

            //fila = j++;
            String searchText = leerExcel.getCellValue
                    ( filepath, "NCR-VENTAS", f+i, 11 );
            System.out.println( "leyendo excel: " + searchText );
            System.out.println( "fila del excel " + f+i );
            String NO= "NO";
            Boolean entrar= true;
            if (searchText.equals(NO)) {
                entrar=false;

            }

            while (entrar==true ){

                new WebDriverWait( driver, 80 ).
                        until( ExpectedConditions.elementToBeClickable( llistaCompleta.get( i ) ) ).click();

                System.out.println(llistaCompleta.get(i).getText());
                //Seleccionando cajas
                Thread.sleep( 1000 );
                //scroll
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript( "document.querySelector('body > div:nth-child(2) > div:nth-child(1) >" +
                        " div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) " +
                        "> div:nth-child(1)').scrollTop = 500" );


                new WebDriverWait( driver, 80 ).
                        until( ExpectedConditions.elementToBeClickable( tresPuntosInsertarTarjeta ) ).click();

                new WebDriverWait( driver, 80 ).
                        until( ExpectedConditions.elementToBeClickable( testValues ) ).click();


                ArrayList<String> newTab = new ArrayList( driver.getWindowHandles() );
                while (newTab.size() != 2) {
                    newTab = new ArrayList( driver.getWindowHandles() );
                }

                //System.out.println( "Cantidad de ventanas:" + newTab.size() );
                driver.switchTo().window( newTab.get( 1 ) );
                Thread.sleep( 1000 );


                //new WebDriverWait( driver, 80 ).until( ExpectedConditions.elementToBeClickable( cajita2 ) );
                // new WebDriverWait( driver, 80 ).until( ExpectedConditions.elementToBeClickable( cajita2 ) ).click();

                //System.out.println("aqui");
                Actions actions = new Actions( driver );
                // actions.moveToElement( driver.findElement( cajita2 ) ).doubleClick().perform();

                //actions.moveToElement( driver.findElement( cajita2 ) ).click().perform();

                new WebDriverWait( driver, 80 ).
                        until(ExpectedConditions.
                                visibilityOfElementLocated
                                        (By.xpath(  "//tbody/tr/td[contains(text(),'#GET_MENSAJE')]" )));

                driver.findElement( cajita2 ).click();

                actions.doubleClick( (driver.findElement(cajita2)) ).build().perform();
                //Thread.sleep( 3000 );
                new WebDriverWait( driver, 80 ).
                        until( ExpectedConditions.visibilityOf( (driver.findElement( texarea_cajita2 ))  ) );
                driver.findElement( texarea_cajita2 ).clear();

                //System.out.println( "leyendo excel: " + searchText );
                System.out.println( "leyendo excel: fila:" + f+i + ", columna:11 ==>>" + searchText );
                driver.findElement( texarea_cajita2 ).sendKeys( searchText );


                //------SE TERMINA DE LEER EL EXCEL------///
                // driver.findElement( texarea_cajita2 ).sendKeys( searchText );
                System.out.println("caso "+i);
                Thread.sleep( 3000 );
                driver.close();
                driver.switchTo().window( newTab.get( 0 ) );
                break;


            }














        }

    }
}
