package com.example.KitapYurdu;
import com.codeborne.selenide.Selectors;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.io.IOException;



public class TestScenario extends Methods {

    @Test
    public void TestScenario() throws CsvValidationException, IOException, InterruptedException {
        isElementExist(By.className("content-home")); // Ana Sayfaya özgü content-home sınıfı kontrol edilir.
        DataReadFromCsv("search-input"); // CSV dosyasından okunan veri search-input isimli alana girilir ve enter tuşuna basılır.
        RandomItem();
        clickBy(By.id("button-cart")); // Sepete ekle butonuna tıklanır.
        clickBy(By.id("cart")); // Sepetim butonuna tıklanır.
        clickBy(By.id("js-cart")); // Sepete git butonuna tıklanır .
        SelectQuantity(); // Ürün sayısında değişiklik yapılır.
        clickBy(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/i")); // Yenile butonuna tıklanır
        isElementExist(By.className("swal2-header")); // Sepetiniz güncellenior yazısının geldiği kontrol edilir.
        Thread.sleep(1000); // Sayfa yüklenmesi için bekleme süresi.
        clickBy(By.className("red-icon")); // Sepetten kaldır butonuna tıklanır.
        isElementExist(By.xpath("//*[@class=\"button\"]")); // Eğer giriş yap butonu varsa sepet boş anlamına gelen kontrol yapılır.
    }
}
