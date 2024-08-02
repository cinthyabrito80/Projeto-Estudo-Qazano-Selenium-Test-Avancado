package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import runner.RunCucumberTest;
import support.Utils;

import static support.Commands.*;
import static support.Utils.*;

public class CadastroPage extends RunCucumberTest {

    //-- formulário de cadastro
    private By valida_tela_cadastro = By.xpath("//*[text()='Cadastro de usuário']");
    private By inserir_nome = By.id("user");
    private By inserir_email = By.id("email");
    private By inserir_senha = By.id("password");
    private By btn_cadastrar = By.id("btnRegister");

    //-- Valida mensagem de sucesso no popup
    private By valida_popup_cadastro_sucesso = By.xpath("//*[text()='Cadastro realizado!']");
    private By btn_ok = By.xpath("//*[text()='OK']");


    public void validaTelaCadastro() {
        Utils.esperarElementoVisivel(valida_tela_cadastro,20);
        String textoElemento = getDriver().findElement(valida_tela_cadastro).getText();
        Assert.assertEquals("Cadastro de usuário",textoElemento);
    }

    public void inserirNome() {
        //Utils.esperarElementoVisivel(inserir_nome,20);
        //getDriver().findElement(inserir_nome).sendKeys(Utils.getName());
        fillField(inserir_nome, getName());
    }

    public void inserirEmail() {
        //Utils.esperarElementoVisivel(inserir_email,20);
        //getDriver().findElement(inserir_email).sendKeys(getEmail());
        fillField(inserir_email, getEmail());
    }

    public void inserirSenha() {
       //Utils.esperarElementoVisivel(inserir_senha,20);
       //getDriver().findElement(inserir_senha).sendKeys(getPassword());
        fillField(inserir_senha, getPassword());
    }

    public void botaoCadastrar() throws InterruptedException {
        System.out.println("#--------------------------------------------------------------#");
        try {
            System.out.println("********** Vai fazer fazer scroll e clicar no elemento: " + btn_cadastrar);
                WebElement element = getDriver().findElement(btn_cadastrar);
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].scrollIntoView(true)", element);
                Thread.sleep(2000);
                Assert.assertEquals("Não exibiu o botão",true, getDriver().findElement(btn_cadastrar).isDisplayed());
                getDriver().findElement(btn_cadastrar).click();
            System.out.println("********** Fez scroll e clicou no elemento: " + btn_cadastrar);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao encontrar o elemento: " + btn_cadastrar);
            new Exception(error);
        }
        System.out.println("#--------------------------------------------------------------#");
    }

    public void validaMenssagemCadastroSucesso() {
        checkMessage(valida_popup_cadastro_sucesso, "Cadastro realizado!");
        //Utils.esperarElementoVisivel(valida_popup_cadastro_sucesso,100);
        //String msgElemento = getDriver().findElement(valida_popup_cadastro_sucesso).getText();
        //Assert.assertEquals("Cadastro realizado!",msgElemento);
    }

    public void botaoOk() {
        //Utils.esperarElementoVisivel(btn_ok,20);
        clickElement(btn_ok);
    }
}
