package automation.examples.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    private String id;
    private String type;
    private String text;
    private String answer;
    private String value;
    private boolean isDeleted;
    private String contestId;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(final boolean deleted) {
        isDeleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(final String contestId) {
        this.contestId = contestId;
    }

}
