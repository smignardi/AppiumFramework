package page.bars;

import base.BasePage;
import element.$;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import utilities.Logs;

import static element.$.LocatorType.ACCESSIBILITY_ID;
import static element.$.LocatorType.UIAUTOMATOR2;

public class TopBarPage extends BasePage {
    private final $ menuOption = $(ACCESSIBILITY_ID, "test-Menu");
    private final $ cartOption = $(ACCESSIBILITY_ID, "test-Cart");
    private final $ itemCountLabel = $(UIAUTOMATOR2,
            "description(\"test-Cart\").childSelector(className(\"android.widget.TextView\"))");

    public TopBarPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Top Bar to Load")
    public void waitPageToLoad() {
        waitPage(menuOption, "Top Bar Page");
    }

    @Override
    @Step("Verifying Top Bar")
    public void verifyPage() {
        softAssert.assertTrue(menuOption.isDisplayed());
        softAssert.assertTrue(cartOption.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Verifying item count")
    public void verifyItemCount(int expectedCount) {
        Logs.info("Verifying item count");
        final var actualCount = Integer.parseInt(itemCountLabel.getText());

        Assert.assertEquals(actualCount, expectedCount);
    }

    @Step("Clicking on menu burger icon")
    public void clickMenuBurger() {
        Logs.info("Clicking on menu burger icon");
        menuOption.click();
    }


}
