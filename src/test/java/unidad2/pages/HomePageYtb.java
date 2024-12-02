package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePageYtb extends ClaseBase {
    //Agrupar los localizadores
    By byBtnAcceder = By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a");

    //Definir las acciones de la página
    public HomePageYtb(WebDriver driver) {
        super(driver);
    }

    //Acciones
    public void AccederCtaYoutube() {click(esperaExplicita(byBtnAcceder)); }
}