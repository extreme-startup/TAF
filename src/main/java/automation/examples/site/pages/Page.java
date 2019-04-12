package automation.examples.site.pages;

import static com.codeborne.selenide.Selenide.refresh;

public interface Page {

    void openPage();

    default void refreshPage(){
        refresh();
    }

}
