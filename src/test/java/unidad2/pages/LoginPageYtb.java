package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class LoginPageYtb extends ClaseBase {
    //Agrupar los localizadores
    By byTxtUsername = By.xpath("//*[@id=\"identifierId\"]"); //Cuenta de correo
    By byBtnNext = By.xpath("//*[@id=\"identifierNext\"]/div/button/span"); //Botón siguiente cuenta (email)
    By byPassword = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"); // Password
    By byBtnNextPass = By.xpath("//*[@id=\"passwordNext\"]/div/button/span"); // Botón siguiente password

    //Definir las acciones de la página
    public LoginPageYtb(WebDriver driver) {
        super(driver);
    }

    //Acciones
    public void iniciarSesion(String username,String pass){
        agregarTexto(esperaExplicita(byTxtUsername),username);
        click(esperaExplicita(byBtnNext));
        agregarTexto(esperaExplicita(byPassword),pass);
        click(esperaExplicita(byBtnNextPass));
    }
}
