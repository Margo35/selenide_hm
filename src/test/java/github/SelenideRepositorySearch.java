package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void softAssertionsPageWithJUnit5ExampleTest () {
        open("/selenide/selenide");
        $("#wiki-tab").click();

        $(".wiki-more-pages-link").click();
        //$("#wiki-pages-box button.js-wiki-more-pages-link").shouldHave(text("Show 3 more pages…")).click();
        $("#wiki-pages-box").$(byText("Show 3 more pages…")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));
    }

}
