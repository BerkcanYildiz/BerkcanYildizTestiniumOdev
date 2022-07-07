package com.example.KitapYurdu;
import com.example.KitapYurdu.Driver.BaseTest;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Methods extends BaseTest {

    public WebElement we;
    FluentWait<WebDriver> wait;

    public void DataReadFromCsv(String id) throws IOException, CsvValidationException, InterruptedException {
        String csvPath = "src/test/resources/TestData.csv";
        CSVReader csvReader;
        String[] csvCell;
        csvReader = new CSVReader(new FileReader((csvPath)));
        csvCell = csvReader.readNext();
        String text1 = csvCell[0];
        we = driver.findElement(By.id(id));
        we.click();
        we.sendKeys(text1);
        Thread.sleep(1000);
        we.sendKeys(Keys.ENTER);
    }
    public void clickBy(By by) throws InterruptedException {
        we= driver.findElement(by);
        we.click();
        Thread.sleep(1000);
    }
    public void RandomItem() throws  InterruptedException{
        List<WebElement> allProducts = driver.findElements(By.xpath("//a[@class=\"pr-img-link\"]"));
        Random r = new Random();
        int randomValue = r.nextInt(allProducts.size());
        allProducts.get(randomValue).click();
        Thread.sleep(1000);
    }
    public void SelectQuantity() throws InterruptedException {
        we = driver.findElement(By.name("quantity"));
        we.click();
        we.sendKeys(Keys.BACK_SPACE);
        we.sendKeys("2");
        Thread.sleep(1000);
    }
    public void isElementExist(By by){
        List<WebElement> l = driver.findElements(by);
        if(l.size() == 0){
            System.out.println(l +" is does not exist.");
        }
        else{
            System.out.println(l + " is exist in the page.");
        }
    }
}



