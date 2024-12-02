package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class SearchImagesGoogle extends ClaseBase {
        //Agrupar los localizadores
        By byOpenImages = By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"); //Abrir Imagenes
        By bySearchImage = By.xpath("//*[@id=\"APjFqb\"]"); //Busca imagen de tsoft en este ejemplo
        By byLupa = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/button"); //hacer clic en la lupa de buscar


        //Definir las acciones de la página
        public SearchImagesGoogle(WebDriver driver) {
                super(driver);
        }

        //Acciones
        public void BuscarImagenes(String variable){
                click(esperaExplicita(byOpenImages));
                agregarTexto(esperaExplicita(bySearchImage),variable);
                click(esperaExplicita(byLupa));
        }
}
