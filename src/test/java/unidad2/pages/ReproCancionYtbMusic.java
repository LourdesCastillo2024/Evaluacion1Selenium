package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class ReproCancionYtbMusic extends ClaseBase {

    //Agrupar los localizadores
    By byReproCancion = By.xpath("//*[@id=\\\"items\\\"]/ytmusic-guide-entry-renderer[3]/tp-yt-paper-item/yt-icon"); //Buscar canción en la biblioteca
    By byVar = By.xpath("//*[@id=\\\"chips\\\"]/ytmusic-chip-cloud-chip-renderer[2]/div/a/yt-formatted-string");
    By byVar2 = By.xpath("//*[@id=\\\"contents\\\"]/ytmusic-responsive-list-item-renderer/div[2]/div[1]/yt-formatted-string/a");

    //Definir las acciones de la página
    public ReproCancionYtbMusic(WebDriver driver) {
        super(driver);
    }

    //Acciones
    public void ReproCancion(){
        click(esperaExplicita(byReproCancion));
        click(esperaExplicita(byVar));
        click(esperaExplicita(byVar2));
    }
}
