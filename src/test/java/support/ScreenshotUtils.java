package support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenshotUtils {
    public static void addScreenshotOnScenario(Scenario scenario){
        System.out.println("#--------------------------------------------------------------#");
        System.out.println("Teste executado: " + scenario.getName());
        System.out.println("Status " + scenario.getStatus());
        System.out.println("Tag: " + scenario.getSourceTagNames());
        System.out.println("#--------------------------------------------------------------#");

        if (scenario.isFailed()) {
            // Verifica se o WebDriver é uma instância de TakesScreenshot
            if (getDriver() instanceof TakesScreenshot) {
                // Tirar a captura de tela
                byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                // Adicionar a captura de tela ao relatório
                scenario.attach(screenshot, "image/png", "index");
            }
        }

    }
}
