package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space(text())='Страхование']")
    private WebElement insurance;

    @FindBy(xpath = "//a[normalize-space(text())='ДМС']")
    private WebElement DMS;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement getInsurance() {
        return insurance;
    }
    public WebElement getDMS() {
        return DMS;
    }
    public void clickInsurance(){
        insurance.click();
    }
    public void clickDMS(){
        DMS.click();
    }
}
