package com.udemy;

import com.udemy.predicate.Rules;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.util.List;


public class DriverTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String  browser) {

        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest(){
        this.driver.get("https://google.com");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
                //.forEach(e-> System.out.println(e.getText()));
//        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;
//        Predicate<WebElement> hasS = (e) -> e.getText().trim().toLowerCase().contains("s");

        System.out.println("Before :: " + elements.size());
        //elements.removeIf(isBlank.or(hasS));

        Rules.get().forEach(elements::removeIf);

        System.out.println("After :: " + elements.size());

        elements.forEach(e-> System.out.println(e.getText()));





    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
