package Prueba_Selenium;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class prueba_netflix {

    WebDriver driver;
    private static final String LANDING_PAGE_TITLE ="Ve series online, ve películas online";
    private static Faker FAKER = new Faker();
    private PageObject pageObject;


    @BeforeMethod

    public void stup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\INM-217\\IdeaProjects\\CursoSeleniumAcademy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageObject = new PageObject(driver);


    }

    @Test

    public void entryNetflix(){
        System.out.println(driver.getTitle());
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageObject.ObtenTitulo();
    }

    @Test

    public void validarTituloTest(){
        driver.manage().window().fullscreen();
        Assert.assertEquals(LANDING_PAGE_TITLE,"Ve series online, ve películas online");


    }

    @Test

    public void iniciarSesionPageTest (){
        //driver.findElement(By.xpath("//*[@href=\'/login\']")).click();
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        pageObject.Registration();

    }

    @Test

    public void loginToNetflixErrorTest(){
        /*driver.findElement(By.xpath("//*[@href=\'/login\']")).click();
        driver.manage().window().fullscreen();
        driver.findElement(By.id("id_userLoginId")).sendKeys("test@gmail.com");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");
        driver.findElement(By.cssSelector("[type=\'submit\']")).click();

        WebElement ds = driver.findElement(By.id("bxid_rememberMe_true"));
        System.out.println(ds.isSelected());
        Assert.assertTrue(ds.isSelected());

        WebElement emptyEmailError = driver.findElement(By.xpath("//*[contains(text(),'Contraseña incorrecta.')]"));
        System.out.println(emptyEmailError.getText());
        Assert.assertEquals(emptyEmailError.getText(),"Contraseña incorrecta.");
        WebElement checkbox = driver.findElement(By.id("bxid_rememberMe_true"));
        System.out.println(checkbox.isSelected());

        WebElement emptyFaceebock = driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión con Facebook')]"));
        System.out.println(emptyFaceebock.getText());
        Assert.assertEquals(emptyFaceebock.getText(),"Iniciar sesión con Facebook");*/

        pageObject.NotificaErrores();



    }

    @Test

    public void fakeEmailTest(){

        String email = FAKER.internet().emailAddress();
        driver.manage().window().fullscreen();
        driver.findElement(By.cssSelector("[class=\'cta-btn-txt\']")).click();
        driver.findElement((By.id("id_email_hero_fuji"))).sendKeys(email);


    }



    @AfterMethod

    public void tearDown(){
        //driver.close();
    }
}


