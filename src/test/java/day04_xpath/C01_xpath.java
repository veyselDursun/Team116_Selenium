package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_xpath {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
Thread.sleep(2000);

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonElementi= driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButonElementi.isDisplayed()){
            System.out.println("delete butonu gorunme testi PASSED");
        }else {
            System.out.println("delete butonu gorunme testi FAILED");
        }
        Thread.sleep(2000);
        //4- Delete tusuna basin
        deleteButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveyaziElementi = driver.findElement(By.tagName("h3"));

        if (addRemoveyaziElementi.isDisplayed()){
            System.out.println("Add Remove Yazi Elementi gorunme testi PASSED");
        }else {
            System.out.println("Add Remove Yazi Elementi gorunme testi FAILED");
        }

        Thread.sleep(2000);

        driver.close();
    }
}
