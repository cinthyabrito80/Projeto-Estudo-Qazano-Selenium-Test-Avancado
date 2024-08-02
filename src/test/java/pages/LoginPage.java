package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumberTest;
import support.Utils;

import static support.Commands.*;

public class LoginPage extends RunCucumberTest {

    //-- formulário de login
    private By valida_tela_login = By.cssSelector("#login_area > div > div > div > div > h3");
    private By inserir_email_login = By.id("user");
    private By inserir_senha_login = By.id("password");
    private By btn_login = By.id("btnLogin");

    //-- Valida mensagem de sucesso no popup
    private By valida_popup_login_sucesso = By.xpath("//*[text()='Login realizado']");
    private By btn_ok = By.xpath("//*[text()='OK']");



    public void validaTelaLogin() {
        checkMessage(valida_tela_login, "Login");
        //Utils.esperarElementoVisivel(valida_tela_login,10000);
        //String textoElemento = getDriver().findElement(valida_tela_login).getText();
        //Assert.assertEquals("Login",textoElemento);
    }


    public void inserirNome(String email) {
        //Utils.esperarElementoVisivel(inserir_email_login,20);
        //getDriver().findElement(inserir_email_login).sendKeys(email);
        fillField(inserir_email_login, email);
    }

    public void inserirSenha(String senha) {
        //Utils.esperarElementoVisivel(inserir_senha_login,20);
        //getDriver().findElement(inserir_senha_login).sendKeys(senha);
        fillField(inserir_senha_login, senha);
    }

    public void botaoLogin() throws InterruptedException {
        clickElement(btn_login);
    }

    public void validaMenssagemLoginSucesso() {
        checkMessage(valida_popup_login_sucesso, "Login realizado");
        //Utils.esperarElementoVisivel(valida_popup_login_sucesso,100);
        //String msgElemento = getDriver().findElement(valida_popup_login_sucesso).getText();
        //Assert.assertEquals("Login realizado",msgElemento);
    }

    public void botaoOk() {
        clickElement(btn_ok);
    }
}
