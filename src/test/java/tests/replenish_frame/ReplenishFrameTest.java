package tests.replenish_frame;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class ReplenishFrameTest extends BaseTest {
    @Test
    public void testSumInFrame(){
        mtsReplenishFramePage
                .toFillFormAndClick()
                .waitForFrameAndSwitchToIt()
                .checkSumInFrame();
    }

    @Test
    public void testPhoneNumberInFrame(){
        mtsReplenishFramePage
                .toFillFormAndClick()
                .waitForFrameAndSwitchToIt()
                .checkFramePhoneNumber();
    }

    @Test
    public void testPlaceholdersInFrame(){
        mtsReplenishFramePage
                .toFillFormAndClick()
                .waitForFrameAndSwitchToIt()
                .checkFramePlaceholders();
    }

    @Test
    public void testPartnersListInFrame(){
        mtsReplenishFramePage
                .toFillFormAndClick()
                .waitForFrameAndSwitchToIt()
                .checkFramePartnersList();
    }

    @Test
    public void testSumInFrameButton(){
        mtsReplenishFramePage
                .toFillFormAndClick()
                .waitForFrameAndSwitchToIt()
                .checkSumInButtonFrame();
    }
}
