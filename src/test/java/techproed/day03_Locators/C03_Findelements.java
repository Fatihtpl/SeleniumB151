package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Findelements {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelim.
        driver.get("https://amazon.com");
        //Sayfadaki linklerin sayisini ve linkleri yazdiralim.
        /*
          findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelements() methodunu kullanırız.
          Bu webelementlerin sayısına ulaşmak için ya da bu web elementlerin yazısını konsola yazdırabilmek için
          List<Webelement> linklerLlistesi=driver.findelements(By.locator("locator değeri")) olarak kullanırız.
          Oluşturmuş olduğumuz List'i loop ile konsola yazdırabiliriz
         */

        List<WebElement> linklerinListesi= driver.findElements(By.tagName("a"));//tagname a ise tum elmentler demek.
        System.out.println("Linklerin sayisi = "+ linklerinListesi.size());
        /*
        1.yol for each

        for (WebElement w:linklerinListesi) {
            if (!w.getText().isEmpty()){             //yazi olmayan linklerin gelmemesi icin if kullandik.
                System.out.println(w.getText());         //web elmentin uzerindeki yaziyi aldik
            }
        }
        */
        //2.yol lambda ile yazdirma

        linklerinListesi.forEach(link -> {if (!link.getText().isEmpty())
        {System.out.println(link.getText());}});


        //Shop deals in Electronics webelementinin yazisini yazdiralim.
        System.out.println("********************");
        System.out.println(driver.findElement(By.linkText("Shop deals in Electronics")).getText());


        driver.close();



    }
}
