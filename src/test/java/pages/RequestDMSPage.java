package pages;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class RequestDMSPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@data-bind='text: options.title']")
    private WebElement titleRequest;
    @FindBy(xpath = "//*[@name='LastName']")
    private WebElement lastName;
    @FindBy(xpath = "//*[@name='FirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//*[@name='MiddleName']")
    private WebElement middleName;
    @FindBy(xpath = "//*[@name='Region']")
    private WebElement region;
    @FindBy(xpath = "//*[@value='77']")
    private WebElement valueRegion;
    @FindBy(xpath = "//input[contains(@data-bind,'value: Phone')]")
    private WebElement phone;
    @FindBy(xpath = "//*[@name='Email']")
    private WebElement email;
    @FindBy(xpath = "//*[@name='Comment']")
    private WebElement comment;
    @FindBy(xpath = "//*[@type='checkbox']")
    private WebElement acceptTerms;
    @FindBy(xpath = "//*[@class = 'btn btn-primary btn-sm text-uppercase text-semibold']")
    private WebElement sendRequest;
    @FindBy(xpath = "//span[text() = 'Введите адрес электронной почты']")
    private WebElement errorEmail;

    private  String[] fillFields = new String[]{"фам","им","от","5767676768",
            "qwertyqwerty","Привет, я тут"};

    public RequestDMSPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public WebElement getErrorEmail() {
        return errorEmail;
    }
    public WebElement getTitleRequest() {
        return titleRequest;
    }
    public String[] getFillFields() {
        return fillFields;
    }
    public WebElement getLastName() {
        return lastName;
    }
    public WebElement getFirstName() {
        return firstName;
    }
    public WebElement getMiddleName() {
        return middleName;
    }
    public WebElement getRegion() {
        return region;
    }
    public WebElement getValueRegion() {
        return valueRegion;
    }
    public WebElement getPhone() {
        return phone;
    }
    public WebElement getEmail() {
        return email;
    }
    public WebElement getComment() {
        return comment;
    }
    public WebElement getAcceptTerms() {
        return acceptTerms;
    }
    public WebElement getSendRequest() {
        return sendRequest;
    }

    public void checkTitleRequest(){
        Assert.assertEquals("Соответствует заявке","Заявка на добровольное медицинское страхование",
                titleRequest.getText());
    }
    public void checkErrorMessage(){
        Assert.assertEquals("Сообщение о неправильной почте:", "Введите адрес электронной почты",
                errorEmail.getText());
    }
    public List<WebElement> fillRequestForm(String[] fillFields){
        lastName.sendKeys(fillFields[0]);
        firstName.sendKeys(fillFields[1]);
        middleName.sendKeys(fillFields[2]);
        region.click();
        valueRegion.click();
        phone.sendKeys(fillFields[3]);
        email.sendKeys(fillFields[4]);
        comment.sendKeys(fillFields[5]);
        acceptTerms.click();
        sendRequest.click();

        List<WebElement> webElements = new ArrayList<WebElement>();
        webElements.add(lastName);
        webElements.add(firstName);
        webElements.add(middleName);
        webElements.add(phone);
        webElements.add(email);
        webElements.add(comment);
        return webElements;
    }
    public void checkRequestForm(List<WebElement> formFields, String[] fillFields){
        Assert.assertEquals("Проверяем фамилию", fillFields[0], formFields.get(0).getAttribute("value") );
        Assert.assertEquals("Проверяем имя", fillFields[1], formFields.get(1).getAttribute("value"));
        Assert.assertEquals("Проверяем отчество", fillFields[2], formFields.get(2).getAttribute("value"));
        Assert.assertEquals("Проверяем телефон", "+7 (576) 767-67-68", formFields.get(3).getAttribute("value"));
        Assert.assertEquals("Проверяем почту", fillFields[4], formFields.get(4).getAttribute("value"));
        Assert.assertEquals("Проверяем коммент", fillFields[5], formFields.get(5).getAttribute("value"));
    }
}
