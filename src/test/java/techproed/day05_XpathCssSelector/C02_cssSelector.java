package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*

            cssSelector ile xpath arasındaki farklar;
        1- cssSelector de @ işareti ve // işaretleri kullanılmaz
        2- xpath ile index alabiliriz ama cssSelector ile index alamayız
        3- xpath ile text olarak locate edebiliriz ama cssSelector ile bunu yapamayız
        4- cssSelector xpath'e göre daha hızlı çalışır
          */


         //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

         //Add Element butonuna basin
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        Thread.sleep(3000);
        addElement.click();

         //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");


         //Delete tusuna basin
        Thread.sleep(3000);
        deleteButton.click();


         //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElements = driver.findElement(By.cssSelector("h3"));
        if (addRemoveElements.isDisplayed()){
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");

    }
}
