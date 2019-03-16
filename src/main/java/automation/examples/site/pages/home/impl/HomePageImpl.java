package automation.examples.site.pages.home.impl;

import automation.examples.site.pages.home.HomePage;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Component
public class HomePageImpl implements HomePage {

    @Override
    public void openPage() {
        open("/");
    }

    @Override
    public SelenideElement getLogoLink() {
        return $(".logo");
    }

    @Override
    public void navigateViaLogoLink() {
        getLogoLink().shouldBe(visible).click();
    }
}
