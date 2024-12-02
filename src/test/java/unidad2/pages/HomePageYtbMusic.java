package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePageYtbMusic extends ClaseBase {
    //Agrupar los localizadores
    By byBtnAcceder = By.xpath("//*[@id=\"right-content\"]/a");

    //Definir las acciones de la página
    public HomePageYtbMusic(WebDriver driver) {super(driver);
    }

    //Acciones
    public void AccederCtaYoutubeMusic() {click(esperaExplicita(byBtnAcceder)); }
}
