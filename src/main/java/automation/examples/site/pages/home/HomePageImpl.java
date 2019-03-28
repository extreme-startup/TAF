package automation.examples.site.pages.home;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Component
public class HomePageImpl implements HomePage {

    @Autowired
    private Logger logger;

    @Override
    public void openPage() {
        logger.debug("Logger works!");
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
