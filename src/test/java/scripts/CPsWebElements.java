package scripts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CPsWebElements {
    //atributos
    private static WebDriver driver;
    private static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver2.exe";
    private WebDriverWait wait;

@BeforeEach
public void preCondiciones(){
    //Enlazar el webDriver al browser de nuestro sistema
    System.setProperty("webdriver.chrome.driver",rutaDriver);
    //Instanciar el webdriver
    driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,20);
    driver.manage().window().maximize();
}

@AfterEach
public void posCondiciones(){
    driver.close();
}

//CP01: Acceder a cuenta de Youtube con un usuario predeterminado
@Test
    public void CP01_AccederCtaYoutube() throws InterruptedException{
    //Entrar a la cuenta de Youtube de Lola Contreras (user de prueba)
    driver.get("https://www.youtube.com/");
    driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a")).click();
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("contreraslola766@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("a1b2C3%xY");
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

    String resultadoEsperado = "contreraslola766@gmail.com"; // usuario predeterminado
    driver.findElement(By.id("img")).click();
    String resultadoActual = driver.findElement(By.id("email")).getAttribute("title");
    Assertions.assertEquals(resultadoEsperado,resultadoActual);
}

//CP02: Buscar un video y darle like en Youtube
//Buscar un video en el explorador de música de Youtube y dar like
@Test
public void CP02_BuscarVideoYoutube() throws InterruptedException{
    //Entrar a la cuenta de Youtube de Lola Contreras (user de prueba)
    driver.get("https://www.youtube.com/");
    driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a")).click();
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("contreraslola766@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("a1b2C3%xY");
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
    Thread.sleep(2000);
    //NOTA: Bloquear a mano el alerta de "Mostrar notificaciones", no encontré manera de interactuar con los elementos de esa pop up
    //driver.switchTo().alert().dismiss(); //no funcionó
    driver.findElement(By.xpath("//*[@placeholder=\"Buscar\"]")).sendKeys("https://www.youtube.com/watch?v=g3YO2nhW8yg");
    driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon/span/div")).click();
    driver.findElement(By.xpath("//a[contains(@href,'watch?v=g3YO2nhW8yg&')]")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[31]/div[2]/div[1]/button")).click();

    String resultadoEsperado = "https://www.youtube.com/watch?v=g3YO2nhW8yg"; // video buscado
    String resultadoActual = driver.getCurrentUrl();
    Assertions.assertEquals(resultadoEsperado,resultadoActual);
}

//CP03: Acceder a cuenta de Youtube Music para el usuario de prueba
@Test
public void CP03_AccederCtaYoutubeMusic() throws InterruptedException {
    //Entrar a la cuenta de Youtube Music de Lola Contreras (user de prueba)
    driver.get("https://music.youtube.com/");
    driver.findElement(By.xpath("//*[@id=\"right-content\"]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("contreraslola766@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("a1b2C3%xY");
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
    Thread.sleep(2000);

    String resultadoEsperado = "https://music.youtube.com/"; // video buscado
    String resultadoActual = driver.getCurrentUrl();
    Assertions.assertEquals(resultadoEsperado,resultadoActual);
}

//CP04: Reproducir una canción de Mi Bilioteca en Youtube Music para el usuario de prueba
@Test
public void CP04_AccederCtaYoutubeMusic() throws InterruptedException {
    //Entrar a la cuenta de Youtube Music de Lola Contreras (user de prueba)
    driver.get("https://music.youtube.com/");
    driver.findElement(By.xpath("//*[@id=\"right-content\"]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("contreraslola766@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("a1b2C3%xY");
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
    driver.findElement(By.xpath("//*[@id=\"items\"]/ytmusic-guide-entry-renderer[3]/tp-yt-paper-item/yt-icon")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"chips\"]/ytmusic-chip-cloud-chip-renderer[2]/div/a/yt-formatted-string")).click();
    driver.findElement(By.xpath("//*[@id=\"contents\"]/ytmusic-responsive-list-item-renderer/div[2]/div[1]/yt-formatted-string/a")).click();
    Thread.sleep(2000);

    String resultadoEsperado = "https://music.youtube.com/watch?v=V9kJOxhWZAo&list=MLCT"; // canción de la biblioteca
    String resultadoActual = driver.getCurrentUrl();
    Assertions.assertEquals(resultadoEsperado,resultadoActual);
}

//CP05: Entrar a la cuenta de Google y buscar imagenes de tsoft
@Test
public void CP05_AccederCtaGoogle() throws InterruptedException {
    //Entrar a la cuenta de Google de Lola Contreras (user de prueba)
    driver.get("https://www.google.com/");
    driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("contreraslola766@gmail.com"); //usuario
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click(); //botón siguiente del usuario
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("a1b2C3%xY"); //password
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click(); //botón siguiente del password
    //driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a")).click(); //aplicaciones de Google... esta prueba no funcionó y cmmbié, la idea era abrir Gemini
    driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a")).click(); //Abrir Imagenes
    driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("tsoft"); //Busca imagen de tsoft en este ejemplo
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/button")).click(); //hacer clic en la lupa de buscar

    String resultadoEsperado = "tsoft - Buscar con Google"; // página con imagenes de tsoft
    String resultadoActual = driver.getTitle();
    Assertions.assertEquals(resultadoEsperado,resultadoActual);
 }
}
