import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {

    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "https://cenacolovinciano.vivaticket.it/?qubsq=d098a090-d9cb-40c6-83ac-7858b8914622&qubsp=91b93d59-939f-47ab-8946-699df59fe26b&qubsts=1555319007&qubsc=bestunion&qubse=vivaticketserver&qubsrt=Safetynet&qubsh=a77f7c67aa33a76447a1511b1cb43782";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @Test
    public void testInsurance() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);


        if (checkIfDisplayed(By.xpath("//SPAN[text()='1Prendi un nuovo posto in coda']")))
            System.out.println("1");

    }


    public boolean checkIfDisplayed(By by) {
        try {
            WebElement elem = driver.findElement(by);
            return elem.isDisplayed();
        } catch (NoSuchElementException nse) {
            System.out.println("2");
            return false;
        }
    }


    @After
    public void afterTest() {

    }
}
