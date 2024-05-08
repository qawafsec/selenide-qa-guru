package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearchTest {
  @BeforeAll
  static void configuration() {
    Configuration.pageLoadStrategy = "eager";
  }

  @Test
  void shouldFindSelenideRepositoryAtTheTop() {

    open("https://github.com/selenide/selenide");
    $("#wiki-tab").click();
    $("#wiki-body").shouldHave(text("Soft assertions"));
    $("#wiki-body").$(byText("Soft assertions")).click();
    $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
    $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "@Test\n" +
            "void test() {\n" +
            "Configuration.assertionMode = SOFT;\n" +
            "open(\"page.html\");\n" +
            "$(\"#first\").should(visible).click();\n" +
            "$(\"#second\").should(visible).click();\n" +
            "}\n" +
            "}"));

  }
}
