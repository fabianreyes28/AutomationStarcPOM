import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class MainAutomationTest {
    private WebDriver driver;
    IniciarSesionPage iniciarPage;
    MenuSelectVentas menuSelectVentas;
    MenuSelectTesCase menuSelectTesCase;
    ListaSelectProject listaSelectProject;
    ListaSelectRequerimiento listaSelectRequerimiento;
    ListaSelectEscenario listaSelectEscenario;
    ListCasos listCasos;


    @Before
    public void setUp() {
        System.setProperty( "webdriver.chrome.driver", "src/test/resources/WebDriver/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://starc.grupohdi.com/starc3/Login" );

    }

    @Test
    public void testStarc() throws InterruptedException, IOException {
        iniciarPage = new IniciarSesionPage(driver);
        iniciarPage.iniciarSesion();

        menuSelectVentas=new MenuSelectVentas( driver );
        menuSelectVentas.seleccionarLista();

        menuSelectTesCase=new  MenuSelectTesCase( driver );
        menuSelectTesCase.SelectMenu();

        listaSelectProject=new ListaSelectProject( driver );
        listaSelectProject.selectProject();

        listaSelectRequerimiento=new ListaSelectRequerimiento( driver );
        listaSelectRequerimiento.seleccionarRequerimiento();

        listaSelectEscenario=new ListaSelectEscenario( driver );
        listaSelectEscenario.seleccionarScenario();

        listCasos =new ListCasos( driver );
        listCasos.recorriendoCasos();







    }

    @After
    public void tearDown() {

        //driver.quit();
    }


}
