package automation.examples.site.components.trainings;

import com.codeborne.selenide.SelenideElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


@Component
@Scope(SCOPE_PROTOTYPE)
public class TrainingFragmentImpl implements TrainingFragment {

    private SelenideElement element;

    public TrainingFragmentImpl(final SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getName() {
        return element.$("div.v-card__title h5");
    }

    @Override
    public SelenideElement getDescription() {
        return element.$("div.flex.xs4 div.v-card__text");
    }

    @Override
    public SelenideElement getDeleteButton() {
        return element.$x(".//button[(contains(@class, 'error'))]");
    }

    @Override
    public SelenideElement getEditButton() {
        return element.$x(".//button[(contains(text(), 'Edit'))]");
    }

    @Override
    public void clickDelete() {
        getDeleteButton().click();
    }

    @Override
    public void clickEdit() {
        getEditButton().click();
    }

    @Override
    public String getNameText() {
        return getName().getText();
    }

    @Override
    public String getDescriptionText() {
        return getDescription().getText();
    }

}
