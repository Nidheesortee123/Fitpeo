package com.automation.Base;

import com.automation.factory.DriverFactory;
import com.automation.pages.homePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    DriverFactory df;
    protected homePage homepage;
    @BeforeTest
    public void setup() {
        df = new DriverFactory(); // Initialize DriverFactory
        driver = df.getDriver();  // Now df is not null
        driver.get("https://fitpeo.com");
        driver.manage().window().maximize();
        homepage = new homePage(driver);
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
