package automation.examples.site.pages.home;

import automation.examples.site.pages.Page;
import com.codeborne.selenide.SelenideElement;

public interface HomePage extends Page {

    SelenideElement getLogoLink();

    void navigateViaLogoLink();

}
