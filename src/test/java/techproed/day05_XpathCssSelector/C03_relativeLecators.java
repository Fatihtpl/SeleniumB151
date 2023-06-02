package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLecators {
    public static void main(String[] args) {
        System.setProperty("chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Relative Locators

    --> Bir web elementi direk locate edemedigimiz durumlarda,
        o web elementi etrafındaki web elementlerin refaransi ile tarif etmemizi saglar

    --> Bir web sayfasında benzer özellikler sahip webelementlerin oldugu durumlarda kullanılabilir

    --> above       ==> Belirtilen elementin üstünde olan elementi secer
    --> below       ==> Belirtilen elementin altında olan elementi secer
    --> to_left_of  ==> Belirtilen elementin solunda olan elementi secer
    --> to_right_of ==> Belirtilen elementin sagında olan elementi secer
    --> near        ==> Belirtilen elementin yanında/yakınında olan elementi secer


    i)   Benzer ozelliklere sahip webelementler icin relative locator kullanabiliriz.

    ii)  Syntax ==> driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near()) gibi
         methodlar ile benzer ozelliklere sahip webelementleri locatini almadan o webelemente ulasabiliriz

         */




       //ORNEK:

         //Amazona gidelim

        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altındaki elemente tıklayalım
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBike));//electricbike i tikladik
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike)); // completeBike i tikladik
        completeBike.click();




    }
}
