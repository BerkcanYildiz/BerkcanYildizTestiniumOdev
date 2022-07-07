package com.example.KitapYurdu.Driver;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class BaseTest {

    public  WebDriver driver;

    @BeforeEach
    public void StartingChrome() throws CsvValidationException, IOException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kitapyurdu.com/");
    }
    @AfterEach
    public void After(){ driver.quit();}
}
