package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioAdicaoDeProdutosPage acessarFormularioAdicaoDeNovoProduto(){
        //vou para a tela de registro de produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioAdicaoDeProdutosPage(navegador);

    }

    public String capturarMensgemApresentada() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
