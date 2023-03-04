package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeEdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeEdicaoDeProdutoPage(WebDriver navegador){
        this.navegador=navegador;
    }
    public String capturarMensgemApresentada() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
