package com.webomates.app.testcases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Execution {
	static WebDriver driver;
	@Parameters({"nodeURl", "browser"})
	@BeforeTest
	public static void test (String nodeURL, String browser ) throws Exception  {
	DesiredCapabilities capability = DesiredCapabilities.chrome();	
	driver = new RemoteWebDriver(new URL(nodeURL), capability);
	}
	@Test
	public static void chrome_execution () {
		driver.get("https://in.linkedin.com/");	
		driver.findElement(By.id("login-email")).sendKeys("raktim@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("hello");
		driver.findElement(By.xpath(".//*[@id='pagekey-uno-reg-guest-home']/div[1]/div/form/input[6]")).click();
	}
	@AfterTest
	public void close () {
		driver.quit();
	}
}
