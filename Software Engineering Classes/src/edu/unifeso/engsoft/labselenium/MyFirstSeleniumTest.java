package edu.unifeso.engsoft.labselenium;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyFirstSeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	FirefoxOptions ffOptions = new FirefoxOptions();
    ffOptions.setBinary(ffBinary);
    driver = new FirefoxDriver(ffOptions);
    baseUrl = "https://www.google.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyFirstSelenium() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("lst-ib")).sendKeys("Engenharia de Software");
    driver.findElement(By.name("btnK")).click();
    Thread.sleep(5000); //Aguarda 5 segundos para que vocês possam ver o resultado
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
