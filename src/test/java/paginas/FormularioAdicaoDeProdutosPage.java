package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class FormularioAdicaoDeProdutosPage {

    private WebDriver navegador;

    public FormularioAdicaoDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioAdicaoDeProdutosPage informarNomeDoProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public FormularioAdicaoDeProdutosPage informarValorDoProduto(String produtoValor){

            navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);
            return this;


    }

    public FormularioAdicaoDeProdutosPage informarCorDoProduto(String produtoCor){
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCor);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioComErro(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new FormularioDeEdicaoDeProdutoPage(navegador);

    }
}
