package scripts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CPsWebElements {
    //atributos
    private static WebDriver driver;
    private static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    private WebDriverWait wait;

@BeforeEach
public void preCondiciones(){
    //Enlazar el webDriver al browser de nuestro sistema
    System.setProperty("webdriver.chrome.driver",rutaDriver);
    //Instanciar el webdriver
    driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
    driver.manage().window().maximize();
}

@AfterEach
public void posCondiciones(){
    driver.close();
}

//Esta luego será otra precondición, debe ser llamada desde Precondiciones
@Test
public void CP00_CuentaGoogle() throws InterruptedException{
//Crear cuenta en Google
    driver.get("https://www.google.com/intl/es/account/about/");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//a[contains(text(),'Ir a la cuenta de Google')]")).click();
    Thread.sleep(1000);

    }

//CP01: Acceder a cuenta de Youtube con el nuevo correo url:https://www.youtube.com/
//CP02: Buscar un video y darle like en Youtube
//CP03: Acceder a cuenta de Youtube Music con el nuevo correo url: https://music.youtube.com/
//CP04: Reproducir una canción en Youtube Music
//CP05: Eliminar la cuenta de Google url:https://www.google.com/intl/es/account/about/

}
