import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideHomeWork5 {

    public static final String HTTPS_GITHUB_COM = "https://github.com/";
    public static final String HTTPS_THE_INTERNET_HEROKUAPP_COM_DRAG_AND_DROP = "https://the-internet.herokuapp.com/drag_and_drop";

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldBeExampleCodeJunit5Test() {
        open(HTTPS_GITHUB_COM);
        $x("//span[@data-target = 'qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $x("//a[@href=\"/selenide/selenide\"]").click();
        $("#wiki-tab").click();
        $x("//div[@id=\"wiki-pages-box\"]//button").click();
        //Проверка, что в списке страниц есть необходимая страница
        $x("//div[@id=\"wiki-pages-box\"]").shouldHave(text("SoftAssertions"));
        $x("//div[@id=\"wiki-pages-box\"]//a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
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

    @Test
    void pageContainsTitleTest() {
        open(HTTPS_GITHUB_COM);
        $(withText("Solutions")).hover();
        $x("//ul[@class=\"list-style-none f5\"]//a[@href=\"/enterprise\"]").click();
        $("body").shouldHave(text("Build like the best"), visible);
    }

    @Test
    void dragAndDropTest() {
        open(HTTPS_THE_INTERNET_HEROKUAPP_COM_DRAG_AND_DROP);
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
