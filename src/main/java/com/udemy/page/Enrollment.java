package com.udemy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Enrollment {

    private final WebDriver driver;

    public Enrollment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
