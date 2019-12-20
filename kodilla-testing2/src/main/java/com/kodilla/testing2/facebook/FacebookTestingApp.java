package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_NAME = "//input[@name = \"firstname\"]";
    public static final String XPATH_SURNAME = "//input[@name = \"lastname\"]";
    public static final String XPATH_EMAIL = "//input[contains(@name, \"reg_email\")]";
    public static final String XPATH_EMAIL_CONFIRM = "//input[contains(@name, \"email_confirmation\")]";
    public static final String XPATH_PASSWORD = "//input[contains(@name, \"passwd\")]";
    public static final String XPATH_DAY = "//div[@class = \"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[@class = \"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[@class = \"_5k_5\"]/span/span/select[3]";
    public static final String XPATH_GENDER = "//span[@class = \"_5k_3\"]/span[2]/input";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement nameInput = driver.findElement(By.xpath(XPATH_NAME));
        nameInput.sendKeys("Jan");

        WebElement surnameInput = driver.findElement(By.xpath(XPATH_SURNAME));
        surnameInput.sendKeys("Gajda");

        WebElement emailInput = driver.findElement(By.xpath(XPATH_EMAIL));
        emailInput.sendKeys("jangajdakodilla@gmail.com");

        while (!driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM)).isDisplayed());
        WebElement emailConfirmationInput = driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM));
        emailConfirmationInput.sendKeys("jangajdakodilla@gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath(XPATH_PASSWORD));
        passwordInput.sendKeys("password123");

        WebElement dayCombo = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(dayCombo);
        selectDay.selectByIndex(29);

        WebElement monthCombo = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthCombo);
        selectMonth.selectByIndex(5);

        WebElement yearCombo = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(yearCombo);
        selectYear.selectByValue("1996");

        WebElement genderRadio = driver.findElement(By.xpath(XPATH_GENDER));
        genderRadio.click();
    }
}
