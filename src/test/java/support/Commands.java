package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

public class Commands extends RunCucumberTest {

    public static void esperarElementoVisivel(By element, int tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(),tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(),tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(),tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public static void clickElement(By element){
        System.out.println("#--------------------------------------------------------------#");
        try {
            System.out.println("********** Vai clicar no elemento: " + element);
            waitElementBeClickable(element, 5);
            getDriver().findElement(element).click();
            System.out.println("********** Clicou no elemento: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
            System.out.println(error);
            getDriver().quit();
        }
        System.out.println("#--------------------------------------------------------------#");
    }

    public static void fillField(By element, String value){
        System.out.println("#--------------------------------------------------------------#");
        try {
            System.out.println("********** Vai preencher o campo: " + element);
            waitElementBeVisible(element, 5);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("********** Preencheu o campo: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
            System.out.println(error);
            getDriver().quit();
        }
        System.out.println("#--------------------------------------------------------------#");
    }

    public static void checkMessage (By element, String expectedMessage){
        String actualMessage = "";
            System.out.println("#--------------------------------------------------------------#");
            System.out.println("********** Vai validar a mensagem: " + expectedMessage);
            waitElementBeVisible(element, 5);
            actualMessage = getDriver().findElement(element).getText();
            //validação de erro a abaixo
            Assert.assertEquals("Erro ao validar mensagem! ", expectedMessage, actualMessage);
            System.out.println("********** Validou e mensagem: " + expectedMessage);

    }
}
