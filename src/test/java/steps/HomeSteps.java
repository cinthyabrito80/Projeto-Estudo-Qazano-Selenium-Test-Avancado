package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Suspendable;
import pages.HomePage;
import runner.RunBase;
import runner.RunCucumberTest;
import support.ScreenshotUtils;

import java.sql.SQLOutput;

public class HomeSteps extends RunCucumberTest {

    HomePage homepage = new HomePage();

    @Dado("que estou no site QazanoShop")
    public void que_estou_no_site_QazanoShop() {
        //getDriver(Browser.CHROME);
        //System.out.println(System.getProperty("nome"));
        homepage.acassarSiteQazanoShop();
    }

    @After
    public static void takeScreenshot(Scenario scenario) {
        ScreenshotUtils.addScreenshotOnScenario(scenario);
    }

}
