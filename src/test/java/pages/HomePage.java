package pages;

import org.openqa.selenium.By;
import runner.RunCucumberTest;
import static support.Commands.clickElement;

public class HomePage extends RunCucumberTest {

    private String URL = "https://automationpratice.com.br/";
    private By logo_home = By.xpath("//*[@href='index.html']");
    private By link_login = By.xpath("//*[text()=' Login']");
    private By link_cadastro = By.xpath("//*[text()=' Cadastro']");


    public void acassarSiteQazanoShop() {
        getDriver(System.getProperty("browser")).get(URL);
    }

    public void acessarLogin() {
        clickElement(link_login);
    }

    public void acessarCadastro() {

        clickElement(link_cadastro);
    }

}
