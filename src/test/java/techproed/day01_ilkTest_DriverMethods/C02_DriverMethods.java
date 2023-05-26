package techproed.day01_ilkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");

        //getTitle()
        System.out.println("Amazon Actual Title : "+driver.getTitle());
        System.out.println("Amazon Actual Url : "+driver.getCurrentUrl());
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri : "+amazonWindowHandle);

        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actual Title : "+driver.getTitle());//getTitle() methodu sayfa basligini verir.

        //getCurrentUrl() Gidilen sayfanin Url'ini verir.
        System.out.println("Techproed Actual Url : "+driver.getCurrentUrl());

        //getPageSource() İçinde olunan sayfanın kaynak kodlarını String olarak verir.
        //System.out.println(driver.getPageSource()); bilerek yoruma aldik her calistirdigimizda konsola butun kaynak kodlari vercegi icin.

        //getWindowHandle() Gidilen sayfanin handle degerini(hashkod) verir.Bu handle degerini sayfalar arasi gecis icin kullaniriz.
        System.out.println("Techproed Window Handle Degeri : "+driver.getWindowHandle());//Techproed Window Handle Degeri : 4969FBEB14287C7E10D6156B3DD6CA27


    }
}
