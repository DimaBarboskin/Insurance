package waiting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class Waiter {
    WebDriver driver;
    private long second;

    public Waiter(WebDriver driver, long second) {
        this.driver = driver;
        this.second = second;
    }
    public void waitElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
