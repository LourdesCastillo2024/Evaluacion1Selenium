package unidad2.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class SearchVideoYtb extends ClaseBase {

    //Agrupar los localizadores
    By bySearchVideo = By.xpath("//*[@placeholder=\"Buscar\"]"); //Buscar, ruta del video
    By byLupa = By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon/span/div"); //lupa
    By byPlay = By.xpath("//a[contains(@href,'watch?v=g3YO2nhW8yg&')]"); //play
    By byPausa = By.xpath("//*[@id=\"movie_player\"]/div[31]/div[2]/div[1]/button"); //pausa

    //Definir las acciones de la página
    public SearchVideoYtb(WebDriver driver) {
        super(driver);
    }

    //Acciones
    public void SearchVideo(String video) {
        agregarTexto(esperaExplicita(bySearchVideo),video);
        click(esperaExplicita(byLupa));
        click(esperaExplicita(byPlay));
        click(esperaExplicita(byPausa));
    }




    }

