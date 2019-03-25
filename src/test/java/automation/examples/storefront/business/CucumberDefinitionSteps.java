package automation.examples.storefront.business;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CucumberDefinitionSteps {

    protected String getTimestamp() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");

        return simpleDateFormat.format(new Date());
    }

}
