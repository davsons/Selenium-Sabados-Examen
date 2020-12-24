package Prueba_Selenium;
import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.testng.annotations.Factory;


public class Fabrica_Netflix {
    private static Faker FAKER = new Faker();

    @Factory

    public Object[] netxlixfactory() {
        return new Object[]{new prueba_netflix(),new prueba_netflix()};


    }
}



