package Prueba_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageObject {

    private WebDriver driver;

    public PageObject (WebDriver adriver){

        driver= adriver;


    }

    public void ObtenTitulo(){

        System.out.println(driver.getTitle());

    }

    public void Registration(){
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//*[@href=\'/login\']")).click();

    }

    public void NotificaErrores(){


        driver.findElement(By.xpath("//*[@href=\'/login\']")).click();
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
        Assert.assertEquals(emptyFaceebock.getText(),"Iniciar sesión con Facebook");


    }


}
