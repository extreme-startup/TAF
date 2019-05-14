package automation.examples.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static automation.examples.framework.spring.utils.RandomUtils.getTimeStamp;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContestDTO {

    private String name;
    private String description;
    private String category;

    public static ContestDTO getContestToAdd() {
        return ContestDTO.builder()
                .name(String.format("Test Contest#%d", getTimeStamp()))
                .description(String.format("Some test description:%d", getTimeStamp()))
                .category(String.format("test category#%d", getTimeStamp()))
                .build();
    }

}
