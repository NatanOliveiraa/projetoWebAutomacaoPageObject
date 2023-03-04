package modulos.produtos;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){

        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\e2etr\\Documents\\ideaProject\\projetoWebAutomacao\\drivers\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizar o browser
        this.navegador.manage().window().maximize();

        //Definir um tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }
    @DisplayName("Nao e permitido registarar produto com valor zero")
    @Test
    public void testProdutoComValorIgualAZero() {
        String mensagemApresentada = new LoginPage(navegador)
               .informarUsuario("admin")
               .informarSenha("admin")
               .submeterFormularioLogin()
               .acessarFormularioAdicaoDeNovoProduto()
               .informarNomeDoProduto("Macbook Pro")
               .informarValorDoProduto("000")
               .informarCorDoProduto("Branco")
               .submeterFormularioComErro()
               .capturarMensgemApresentada();

        //validar que a mensagem de erro seja informada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @DisplayName("Nao e permitido registrar produto com valor superior a 7 mil")
    @Test
    public void testProdutoComValorMaiorQueSeteMil(){
        String validarMensagem = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioLogin()
                .acessarFormularioAdicaoDeNovoProduto()
                .informarNomeDoProduto("Ultrabook")
                .informarValorDoProduto("700001")
                .informarCorDoProduto("Branco")
                .submeterFormularioComErro()
                .capturarMensgemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",validarMensagem);
    }

    @DisplayName("Produto Registrado com sucesso")
    @Test
    public void testProdutoRegistradoComSucesso(){
        String validarMensagem = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioLogin()
                .acessarFormularioAdicaoDeNovoProduto()
                .informarNomeDoProduto("Ultrabook")
                .informarValorDoProduto("500000")
                .informarCorDoProduto("Branco")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensgemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso",validarMensagem);
    }
    @AfterEach
    public void afterEach(){
        //Fechar o navegador
        navegador.quit();
    }

}
