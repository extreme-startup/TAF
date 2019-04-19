package automation.examples.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.time.LocalDate.now;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    private String id;
    private String type;
    private String text;
    private String answer;
    private String value;
    private boolean isDeleted;
    private String contestId;

    public static QuestionDTO getQuestionToAdd() {
        return QuestionDTO.builder()
                .type("static")
                .text("What is the capital of Ukraine?")
                .answer("Kyiv")
                .value("4")
                .contestId("2")
                .build();
    }

    public static QuestionDTO getQuestionToUpdate(final String questionId) {
        return QuestionDTO.builder()
                .id(questionId)
                .type("static")
                .text("What day is today?")
                .answer(now().toString())
                .value("4")
                .contestId("2")
                .build();
    }

}
