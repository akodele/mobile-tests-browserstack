package tests.android.browserstackTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OpenFirstArticleTest extends TestBase {
    @Test
    void goToTheArticleTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });
        step("Click on the first article", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });
        step("Check text on article", () -> {
            $(id("pcs-edit-section-title-description")).shouldHave(text("Chemical element, symbol Se and atomic number 34"));
        });

    }

}