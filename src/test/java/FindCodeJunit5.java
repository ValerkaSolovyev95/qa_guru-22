import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class FindCodeJunit5 {

    public static final String HTTPS_GITHUB_COM = "https://github.com/";

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldBeExampleCodeJunit5() {
        open(HTTPS_GITHUB_COM);
        $x("//span[@data-target = 'qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $x("//a[@href=\"/selenide/selenide\"]").click();
        $("#wiki-tab").click();
        //Проверка, что в списке страниц есть необходимая страница
        $x("//div[@class=\"markdown-body\"]//ul").shouldHave(text("Soft assertions"));
        $x("//li/a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        //Проверка, что мы перешли на необходимую страницу
        $("body").shouldHave(text("SoftAssertions"));
        //Проверка необходимого примера текста
        $(".markdown-body").shouldHave(text(
                        """
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
                        """
                )
        );
        $(".markdown-body").shouldHave(text(
                        """
                        class Tests {
                          @RegisterExtension\s
                          static SoftAssertsExtension softAsserts = new SoftAssertsExtension();
                                                
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                                                
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }
                        """
                )
        );
    }
}
