package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePageGoogle extends ClaseBase {
    //Agrupar los localizadores
    By byBtnIniciarSesion = By.xpath("//*[@id=\"gb\"]/div/div[2]/a");

    //Definir las acciones de la página
    public HomePageGoogle(WebDriver driver) {
        super(driver);
    }

    //Acciones
    public void IniciarSesionGoogle() {click(esperaExplicita(byBtnIniciarSesion)); }
}
