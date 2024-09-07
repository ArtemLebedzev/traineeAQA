package tests.replenish_form;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class ReplenishFormTest extends BaseTest {
    @Test
    public void testTitle(){
        mtsReplenishPage.checkTitle();
    }

    @Test
    public void testPaySystemsAppearing(){
        mtsReplenishPage.checkPaySystemsAppearing();
    }

    @Test
    public void testIsLinkClickable(){
        mtsReplenishPage.checkIsLinkClickable();
    }

    @Test
    public void testIsButtonClickable(){
        mtsReplenishPage
                .toFillFormAndClick()
                .checkFrameIsAppearing();
    }

    @Test
    public void testCommunicationServicesPlaceholders(){
        mtsReplenishPage.checkPlaceholders();
    }

}
