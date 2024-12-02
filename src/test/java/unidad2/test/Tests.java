package unidad2.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import unidad2.pages.*;
import unidad2.utils.DataDriven;
import unidad2.utils.Propertiesdriven;

import java.util.ArrayList;

public class Tests {
    //Instanciar objetos de las page's
    private WebDriver driver;
    ArrayList<String> data;
    private String CP;
    //Yotube
    private HomePageYtb homePageYtb;
    private LoginPageYtb loginPageYtb;
    private SearchVideoYtb searchVideoYtb;
    //Yotube Music
    private HomePageYtbMusic homePageYtbMusic;
    private LoginPageYtbMusic loginPageYtbMusic;
    private ReproCancionYtbMusic reproCancionYtbMusic;
    //Google
    private HomePageGoogle homePageGoogle;
    private LoginPageGoogle loginPageGoogle;
    private SearchImagesGoogle buscarImagenes;

    public void Precondiciones_Youtube()
    {
        homePageYtb = new HomePageYtb(driver);
        loginPageYtb = new LoginPageYtb(homePageYtb.getDriver());
        homePageYtb.cargarSitio(Propertiesdriven.obtenerProperty("url1"));
        homePageYtb.maximizarBrowser();
    }

    public void Precondiciones_YoutubeMusic(){
        homePageYtbMusic = new HomePageYtbMusic(driver);
        loginPageYtbMusic = new LoginPageYtbMusic(homePageYtbMusic.getDriver());
        homePageYtbMusic.cargarSitio(Propertiesdriven.obtenerProperty("url2"));
        homePageYtbMusic.maximizarBrowser();
    }

    public void Precondiciones_Google(){
        homePageGoogle = new HomePageGoogle(driver);
        loginPageGoogle = new LoginPageGoogle(homePageGoogle.getDriver());
        homePageGoogle.cargarSitio(Propertiesdriven.obtenerProperty("url3"));
        homePageGoogle.maximizarBrowser();
    }

    @BeforeEach
    public void preCondiciones(){
        //preparo el driver y las page's
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        data = new ArrayList<String>();
    }

    @AfterEach
    public void posCondiciones(){
    }

    //CP01: Acceder a cuenta de Youtube con un usuario predeterminado
    @Test
    public void CP01_AccederCtaYoutube(){
        //Entrar a la cuenta de Youtube de Lola Contreras (user de prueba)
        Precondiciones_Youtube();
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP01"));
        homePageYtb.AccederCtaYoutube();
        loginPageYtb.iniciarSesion(data.get(1),data.get(2));
    }

    //CP02: Buscar un video en el explorador de música de Youtube
    @Test
    public void CP02_BuscarVideoYoutube(){
        //Entrar a la cuenta de Youtube de Lola Contreras (user de prueba)
        Precondiciones_Youtube();
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP02"));
        homePageYtb.AccederCtaYoutube();
        loginPageYtb.iniciarSesion(data.get(1),data.get(2));
        searchVideoYtb.SearchVideo(data.get(3)); //AQUI EL PROBLEMA
    }

    //CP03: Acceder a cuenta de Youtube Music para el usuario de prueba
    @Test
    public void CP03_AccederCtaYoutubeMusic() {
        //Entrar a la cuenta de Youtube Music de Lola Contreras (user de prueba)
        Precondiciones_YoutubeMusic();
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP03"));
        homePageYtbMusic.AccederCtaYoutubeMusic();
        loginPageYtbMusic.iniciarSesion(data.get(1),data.get(2));
    }

    //CP04: Reproducir una canción de Mi Bilioteca en Youtube Music para el usuario de prueba
    @Test
    public void CP04_ReproducirCancionYoutubeMusic() {
        //Entrar a la cuenta de Youtube Music de Lola Contreras (user de prueba)
        Precondiciones_YoutubeMusic();
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP04"));
        homePageYtbMusic.AccederCtaYoutubeMusic();
        loginPageYtbMusic.iniciarSesion(data.get(1),data.get(2));
        reproCancionYtbMusic.ReproCancion(); //AQUI EL PROBLEMA
    }

    //CP05: Entrar a la cuenta de Google y buscar imagenes de Tsoft
    @Test
    public void CP05_AccederCtaGoogle() {
        //Entrar a la cuenta de Google de Lola Contreras (user de prueba)
        Precondiciones_Google();
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP05"));
        homePageGoogle.IniciarSesionGoogle();
        loginPageGoogle.iniciarSesion(data.get(1),data.get(2));
        buscarImagenes.BuscarImagenes(data.get(3)); //AQUI EL PROBLEMA
    }
}
