package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class DMSPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@class ='h1']")
    private WebElement titleDMC;

    @FindBy(xpath = "//a[normalize-space(text())='Отправить заявку']")
    private WebElement sendRequest;

    public DMSPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement getTitleDMC() {
        return titleDMC;
    }
    public WebElement getSendRequest() {
        return sendRequest;
    }
    public void checkTitle(){
        Assert.assertEquals("Соостветсвует ДМС",
                "Добровольное медицинское страхование (ДМС)", titleDMC.getText());
    }
    public void clickSendRequest(){
        sendRequest.click();
    }
}
