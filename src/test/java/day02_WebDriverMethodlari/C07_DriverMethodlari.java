package day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        // 1) ChromeDriver kullanarak, facebook sayfasina gidin
        // 2) ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.get("https://www.facebook.com");

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle))     {
            System.out.println("Facebook title testi PASSED");
        }else{
            System.out.println("Facebook Title testi FAILED \nActual title : " + actualTitle);
        }

        //3) Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrlIcerik = "facebook";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Facebook Url testi PASSED");
        }else {
            System.out.println("Facebook Url testi FAILED \nActual Url : " + actualUrl);
        }

        //4) https://www.walmart.com/ sayfasina gidin.

        driver.navigate().to("https://www.walmart.com/");

        // 5) Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        actualTitle = driver.getTitle();
        String expectedTitleIcerik = "Walmart.com";

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart title testi PASSED");
        }else {
            System.out.println("Walmart title testi FAILED,\nActual Title : " + actualTitle);
        }

        // 6) Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // 7) Sayfayi yenileyin
        driver.navigate().refresh();

        // 8) Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9) Browser’i  kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
