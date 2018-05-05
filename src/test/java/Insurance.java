import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rogoza Dimity on 04.05.2018.
 */
public class Insurance {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.rgs.ru");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void formalizeDMC(){
    driver.findElement(By.xpath("//a[normalize-space(text())='Страхование']")).click();

    driver.findElement(By.xpath("//a[normalize-space(text())='ДМС']")).click();

    WebElement titleDMC = driver.findElement(By.xpath("//*[@class ='h1']"));
    Assert.assertEquals("Соостветсвует ДМС",
                "Добровольное медицинское страхование (ДМС)", titleDMC.getText());
    driver.findElement(
            By.xpath("//*[@data-toggle='page-common-popup-form'][1]")).click();

    WebElement titleApplication = driver.findElement(By.xpath("//*[@data-bind='text: options.title']"));
    WebDriverWait wait = new WebDriverWait(driver, 3);
    wait.until(ExpectedConditions.visibilityOf(titleApplication));
    Assert.assertEquals("Соответствует заявке","Заявка на добровольное медицинское страхование",
                titleApplication.getText());

    checkFields(fillFields(driver));

    driver.findElement(By.xpath("//*[@class = 'btn btn-primary btn-sm text-uppercase text-semibold']")).click();

    WebElement errorEmail = driver.findElement(By.xpath("//span[text() = 'Введите адрес электронной почты']"));
    WebDriverWait wait12 = new WebDriverWait(driver, 3);
    wait12.until(ExpectedConditions.visibilityOf(errorEmail));
    Assert.assertEquals("Сообщение о неправильной почте:", "Введите адрес электронной почты",
            errorEmail.getText());
    }

    public static void checkFields(List<WebElement> elements){
        Assert.assertEquals("Проверяем фамилию", "Фам", elements.get(0).getAttribute("value"));
        Assert.assertEquals("Проверяем имя", "Им",elements.get(1).getAttribute("value"));
        Assert.assertEquals("Проверяем отчество", "Отч",elements.get(2).getAttribute("value"));
        Assert.assertEquals("Проверяем телефон", "+7 (576) 767-67-68",
                elements.get(3).getAttribute("value"));
        Assert.assertEquals("Проверяем почту", "qwertyqwerty",elements.get(4).getAttribute("value"));
        Assert.assertEquals("Проверяем коммент", "Привет, я тут",elements.get(5).getAttribute("value"));
    }
    public static List<WebElement> fillFields(WebDriver driver){
        WebElement lastName = driver.findElement(By.xpath("//*[@name='LastName']"));
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='LastName']"))));
        lastName.sendKeys("Фам");

        WebElement firstName = driver.findElement(By.xpath("//*[@name='FirstName']"));
        WebDriverWait wait2 = new WebDriverWait(driver, 3);
        wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='FirstName']"))));
        firstName.sendKeys("Им");

        WebElement middleName = driver.findElement(By.xpath("//*[@name='MiddleName']"));
        WebDriverWait wait3 = new WebDriverWait(driver, 3);
        wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='MiddleName']"))));
        middleName.sendKeys("Отч");

        driver.findElement(By.xpath("//*[@name='Region']")).click();
        driver.findElement(By.xpath("//*[@value='77']")).click();

        WebElement phone = driver.findElement(By.xpath("//input[contains(@data-bind,'value: Phone')]"));
        WebDriverWait wait4 = new WebDriverWait(driver, 3);
        wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@data-bind,'value: Phone')]"))));
        phone.sendKeys("5767676768");

        WebElement email = driver.findElement(By.xpath("//*[@name='Email']"));
        WebDriverWait wait5 = new WebDriverWait(driver, 3);
        wait5.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='Email']"))));
        email.sendKeys("qwertyqwerty");

        WebElement comment = driver.findElement(By.xpath("//*[@name='Comment']"));
        WebDriverWait wait6 = new WebDriverWait(driver, 3);
        wait6.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='Comment']"))));
        comment.sendKeys("Привет, я тут");

        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        List<WebElement> webElements = new ArrayList<>();
        webElements.add(lastName);
        webElements.add(firstName);
        webElements.add(middleName);
        webElements.add(phone);
        webElements.add(email);
        webElements.add(comment);

        return webElements;
    }
}
