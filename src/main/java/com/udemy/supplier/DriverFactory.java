package com.udemy.supplier;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    //private static final Supplier<WebDriver> chromeSupplier = () -> {return new ChromeDriver();};
    //private static final Supplier<WebDriver> firefoxSupplier =   () -> {return new FirefoxDriver();};

    private static final Supplier<WebDriver> chromeSupplier = ChromeDriver::new;
    private static final Supplier<WebDriver> firefoxSupplier =   FirefoxDriver::new;

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put ("chrome", chromeSupplier);
        MAP.put ("firefox", firefoxSupplier);
    }
    public static WebDriver getDriver (String browser) {
        return MAP.get(browser).get();
    }
}
