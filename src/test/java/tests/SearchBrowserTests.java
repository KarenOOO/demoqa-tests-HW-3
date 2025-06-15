package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тестирование запросов в браузер Duckduckgo")
public class SearchBrowserTests {

    @BeforeAll
    static void setUpConfiguration() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");
    }

    @ValueSource(strings = {
            "QA Guru", "Selenide"
    })
    @ParameterizedTest(name = "Выполняется поиск {0} должен отдавать не пустой результат")
    @Tag("BLOCKER")
    void searchDuckduckgoElementTest(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "QA Guru, https://qa.guru",
            "Selenide, https://selenide.org"})
    @ParameterizedTest(name = "Выполняется поиск {0} должен найти {1}")
    @Tag("BLOCKER")
    void linkSearchDuckduckgoElementTest(String searchQuery, String url) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(url));
    }

    @ValueSource(strings = {
            "QA Guru", "Selenide"
    })
    @ParameterizedTest(name = "Выполняется поиск изображения {0} должен отдавать не пустой результат")
    @Tag("BLOCKER")
    void searchDuckduckgoElementImgTest(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='duckbar']").$(byText("Изображения")).click();
        $$("[data-testid='zci-images']")
                .shouldBe(sizeGreaterThan(0));
    }

    @MethodSource("searchQueries")
    @ParameterizedTest(name = "Поиск {0} должен давать результат")
    @Tag("BLOCKER")
    void searchWithMethodSourceTest(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }

    static Stream<String> searchQueries() {
        return Stream.of("QA Guru", "Selenide", "JUnit 5");
    }

    @Disabled("Временно отключено до фикса бага")
    @DisplayName("Выполняется поиск новостей про QA Guru должен отдавать не пустой результат")
    @Tag("LOW")
    @Test
    void searchDuckduckgoElementNewsTest() {
        $("#searchbox_input").setValue("QA Guru").pressEnter();
        $("[data-testid='duckbar']").$(byText("Новости")).click();
        $$("[data-testid='zci-images']")
                .shouldBe(sizeGreaterThan(0));
    }
}


