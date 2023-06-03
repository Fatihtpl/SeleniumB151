package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_relativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ORNEK:

        //Amazona gidelim

        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altındaki elemente tıklayalım
        //WEbelementlerin ustundaki yazisini konsala yazdiralim.
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBike.getText());
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBike));//electricbike i tikladik
        System.out.println(electricBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike)); // completeBike i tikladik
        System.out.println(completeBike.getText());
        //Bikes altindaki tum lnkleri(webelemnt)konsala yazdiralim

       List<WebElement> linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));
       //[position()>=10 and position()<=16] bu sekilde aralik belirterek istedgimiz webelementleri secebilriz.
       //lamda ile yazdirdik
       linklerListesi.forEach(t -> System.out.println(t.getText()));

        System.out.println("**************************************");

        //foreach ile yazdirdik
        for (WebElement w:linklerListesi){
            System.out.println(w.getText());
        }
        //Bu linklerin hepsini tiklayalim ve sayfa basliklarini alalim.

        for(int i=0 ; i<linklerListesi.size();i++){
            linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(3000);
            System.out.println(linklerListesi.get(i).getText());
            driver.navigate().back();
            Thread.sleep(3000);
        }







       }

    }
