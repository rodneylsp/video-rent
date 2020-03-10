package com.videorent.business.selenium;

import com.videorent.util.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",ConfigUtil.getChromeWebDriver());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement campoTexto = driver.findElement(By.name("q"));

        campoTexto.sendKeys("Club de Regatas Vasco da Gama");

        campoTexto.submit();

    }
}
