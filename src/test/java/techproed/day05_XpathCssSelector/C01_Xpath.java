package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         // https://www.amazon.com sayfasına gidiniz
        driver.get("https://amazon.com");

        // arama kutusuna "city bike"  yazıp aratın


       // kodlari komple alip icinden sectik.
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
        tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */

        driver.findElement(By.xpath("//*[@ id='twotabsearchtextbox']")).sendKeys("city bike", Keys.ENTER);

        // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();// --> //*[.='Hybrid Bikes']



        // sonuc sayısını yazdırın
       WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
       System.out.println(sonucYazisi.getText()); //14 results for "city bike"
       String sonucSayisi[] = sonucYazisi.getText().split(" ");  // bosluklardan kesdik ve index o degerini aldik 14 basta oldugu icin
       System.out.println("Sonuc Sayisi :" + sonucSayisi[0]);


         // ilk ürününe tıklayın
        // driver.findElement(By.xpath("(//h2)[1]")).click();  // baslikla aldik
          driver.findElement(By.xpath("//*[@class='s-image']")).click(); //imagele aldik.

        // Sayfayı kapatınız.
        driver.close();


    }
}
