package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim.
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edelim.
        /*
           Bir webelementin locate'ini birden fazla kullanacaksanız bir Webelement'e değişken olarak atayabilirsiniz.
           Webelement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
           1-Locate işlemi bittikten sonra webelemente bir metin göndereceksek sendKeys() methodu kullanırız.
           2-Webelement'e tıklayacaksak click() methodu kullanırız
           3-Webelement'in üzerindeki yazıyı almak istiyorsak getText()methodunu kullanırız.
           4-sendKeys() methodundan sonra(yani webElemente metin gönderdikten sonra) Keys.ENTER ile yada
        submit() methodu ile manuel olarak enter yaptığımız gibi otomasyonda da yapabiliriz.
          */
        //Arama kutusunu locate edelim.
        //Arama kutusuna iphone yazdiralim ve aratalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sayfayi kapatalim.
        driver.close();


    }
}
