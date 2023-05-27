package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //1-Amazon sayfasina gidelim
        //2-Sayfa basliginin Amazon icerdigini test edelim.
        //3-Url'in https://www.amazon.com oldugunu test edelim.
        //4-Sayfayi kapatalim.

        //1
        driver.get("https://www.amazon.com");

        //2
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //3
        String actualUrl = driver.getCurrentUrl();
        String ecpectedUrl = "https://www.amazon.com/";
        if(actualUrl.equals(ecpectedUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED ->" + actualUrl);

        //4

        driver.close();//Browser'i kapatir.
        //driver.quit();-> Birden fazla browser varsa hepsini kapatir.








    }

}
