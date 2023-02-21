package tests.android.browserstackTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OpenFirstArticleTest extends TestBase {

    @DisplayName("Проверка поиска")
    @Test
    void searchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Проверка открытия первой статьи")
    @Test
    void openTest() {
        step("Open first article", () ->
                $$(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text"))
                        .first().click());
        step("Check country name of article", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text"))
                        .shouldHave(Condition.text("New Zealand")));
    }

}