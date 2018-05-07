package test;

import application.TestBase;
import pages.DMSPage;
import pages.MainPage;
import org.junit.Test;
import pages.RequestDMSPage;
import waiting.Waiter;
/**
 * Created by Rogoza Dimity on 04.05.2018.
 */
public class Insurance extends TestBase {
    @Test
    public void formalizeDMC(){
        Waiter waiter = new Waiter(driver,3);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickInsurance();
        mainPage.clickDMS();

        DMSPage dmsPage = new DMSPage(driver);
        dmsPage.checkTitle();
        dmsPage.clickSendRequest();

        RequestDMSPage requestDMSPage = new RequestDMSPage(driver);
        waiter.waitElement(requestDMSPage.getTitleRequest());
        requestDMSPage.checkTitleRequest();
        requestDMSPage.checkRequestForm(requestDMSPage.fillRequestForm(requestDMSPage.getFillFields()), requestDMSPage.getFillFields());
        requestDMSPage.checkErrorMessage();
    }
}
